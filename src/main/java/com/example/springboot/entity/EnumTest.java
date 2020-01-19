package com.example.springboot.entity;

import com.example.springboot.enums.StatusEnums;
import com.example.springboot.enums.TypeEnums;
import lombok.Data;

/**
 * @date : 2020/01/18
 * @author: liangenmao
 */
@Data
public class EnumTest {
    private Integer id;
    private StatusEnums status;
    private TypeEnums type;
    private Boolean delete;
}
