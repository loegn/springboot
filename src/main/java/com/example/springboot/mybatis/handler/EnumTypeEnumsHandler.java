package com.example.springboot.mybatis.handler;

import com.example.springboot.enums.TypeEnums;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @date : 2020/01/19
 * @author: liangenmao
 */
public class EnumTypeEnumsHandler extends BaseTypeHandler<TypeEnums> {
    public EnumTypeEnumsHandler() {
    }

    public EnumTypeEnumsHandler(Class<TypeEnums> type) {
        if (type == null) {
            throw new IllegalArgumentException("type argument cannot be null");
        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, TypeEnums typeEnums, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, typeEnums.getValue());
    }

    @Override
    public TypeEnums getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
        int i = resultSet.getInt(columnName);
        if (resultSet.wasNull()) {
            return null;
        } else {
            return locateEnum(i);
        }
    }

    @Override
    public TypeEnums getNullableResult(ResultSet resultSet, int columnIndex) throws SQLException {
        if (resultSet.wasNull()) {
            return null;
        } else {
            return locateEnum(columnIndex);
        }
    }

    @Override
    public TypeEnums getNullableResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        int i = callableStatement.getInt(columnIndex);
        if (callableStatement.wasNull()) {
            return null;
        } else {
            return locateEnum(columnIndex);
        }
    }

    private TypeEnums locateEnum(int value) {
        for (TypeEnums typeEnums : TypeEnums.values()) {
            if (typeEnums.getValue() == value){
                return typeEnums;
            }
        }
        throw new IllegalArgumentException("unknown TypeEnums：value = " + value);
    }
}
