package com.agan.boot.controller;

import com.agan.boot.annotation.Phone;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Date;
@ApiModel(value = "用户信息")
@Data
public class UserVO {
    @ApiModelProperty(value = "用户ID")
    private Integer id;

    @ApiModelProperty(value = "用户名")
    @NotEmpty(message = "用户名不能为空")
    @Length(min=6,max = 12,message = "用户名长度必须位于6到12之间")
    private String username;

    @ApiModelProperty(value = "密码")
    @NotEmpty(message = "密码不能为空")
    @Length(min = 6,message = "密码长度不能小于6位")
    private String password;

    @ApiModelProperty(value = "邮箱")
    @Email(message = "请输入正确的邮箱")
    private String email;

    @ApiModelProperty(value = "手机号码")
    @Phone
    private String phone;

    @ApiModelProperty(value = "身位证号")
    @Pattern(regexp = "^(\\d{18,18}|\\d{15,15}|(\\d{17,17}[x|X]))$",message = "身份证格式错误")
    private String idCard;


    @ApiModelProperty(value = "性别 0=女 1=男")
    private Byte sex;
    @ApiModelProperty(value = "删除标志，默认0不删除，1删除")
    private Byte deleted;
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

}
