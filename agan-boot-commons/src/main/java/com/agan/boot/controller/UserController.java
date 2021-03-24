package com.agan.boot.controller;

import com.sun.javafx.tools.packager.Log;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@Api(description = "用户接口")
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @PostMapping(value = "/user/create",produces = APPLICATION_JSON_UTF8_VALUE,consumes= APPLICATION_JSON_UTF8_VALUE)
    public void crreteUser(@RequestBody @Validated UserVO userVO){
        Log.info("-----crreteUser-----");
    }

    @GetMapping(value = "/getSrt")
    public String getStr(){
        return "test";
    }

    @GetMapping(value = "/getObject")
    public UserVO getObject(){
        UserVO vo = new UserVO();
        vo.setUsername("agan");
        return vo;
    }
    @GetMapping(value = "empty")
    public void empty(){

    }

    @GetMapping("/error")
    public void error(){
        int i=9/0;
    }








    @ApiOperation("修改某条数据")
    @GetMapping(value = "/u/{id}")
    public UserVO findById(@PathVariable int id){
        Random rand = new Random();
        UserVO user = new UserVO();
        user.setId(id);
        String temp = "temp01";
        user.setUsername(temp);
        user.setPassword(temp);
        int n = rand.nextInt(2);
        user.setSex((byte)n);
        return user;
    }

}
