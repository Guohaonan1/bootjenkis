package com.example.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity  //表示是一个实体类，对应数据库中一个表
@Data //Lombok，使用这个注解不用自己写Getter/Setter
//实体路径和描述
//@ApiModel(value = "com.example.demo.entity.SysUser",description = "用户")
public class SysUser {
    //字段描述
    @Id
    private Integer id;

    private String username;

    private String password;

    private String sex;

    private String phone;

    private String email;

}