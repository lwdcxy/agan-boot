package com.agan.boot.controller;


import lombok.Data;

import java.util.Date;

@Data
public class UserVO {
    private Integer id;
    private String username;
    private String password;
    private Byte sex;
    private Date updateTime;
    private Date createTime;


}

