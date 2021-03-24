package com.agan.boot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
@ApiModel(value = "用户信息")
@Data
public class UserVO {
    @ApiModelProperty(value = "用户ID")
    private Integer id;
    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "性别 0=女 1=男")
    private Byte sex;
    @ApiModelProperty(value = "删除标志，默认0不删除，1删除")
    private Byte deleted;
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

}
