package com.example.springboot.shiro;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @date : 2018/11/06 14:24
 * @author: liangenmao
 */
public class PasswordUtils {
    /**
     * 随机生成 salt 默认长度为20
     *
     * @return salt
     */
    public static String generateSalt() {
        return generateSalt(20);
    }

    /**
     * 随机生成 salt 需要指定 它的字符串的长度
     *
     * @param len 字符串的长度
     * @return salt
     */
    public static String generateSalt(int len) {
        //一个Byte占两个字节
        int byteLen = len >> 1;
        SecureRandomNumberGenerator secureRandom = new SecureRandomNumberGenerator();
        return secureRandom.nextBytes(byteLen).toHex();
    }

    /**
     * 获取加密后的密码，使用默认hash算法SHA-256，hash迭代的次数 1 次
     *
     * @param password 需要加密的密码
     * @param salt     盐
     * @return 加密后的密码
     */
    public static String encryptPassword(String password, String salt) {
        return encryptPassword(password, salt, 1);
    }

    /**
     * 获取加密后的密码，使用默认hash迭代的次数 1 次
     *
     * @param password 需要加密的密码
     * @param salt     盐
     * @param hashIterations hash迭代的次数
     * @return 加密后的密码
     */
    public static String encryptPassword(String password, String salt, int hashIterations) {
        return encryptPassword("SHA-256", password, salt, hashIterations);
    }

    /**
     * 获取加密后的密码，需要指定 hash迭代的次数
     *
     * @param hashAlgorithm  hash算法名称 MD2、MD5、SHA-1、SHA-256、SHA-384、SHA-512、etc。
     * @param password       需要加密的密码
     * @param salt           盐
     * @param hashIterations hash迭代的次数
     * @return 加密后的密码
     */
    public static String encryptPassword(String hashAlgorithm, String password, String salt, int hashIterations) {
        SimpleHash hash = new SimpleHash(hashAlgorithm, password, salt, hashIterations);
        return hash.toString();
    }
}
