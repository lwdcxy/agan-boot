package com.agan.boot.controller;

import com.agan.boot.enums.ResultCode;
import com.agan.boot.exceptions.BusinessException;
import com.agan.boot.response.Result;
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

    @PostMapping(value = "/user/update",produces = APPLICATION_JSON_UTF8_VALUE,consumes = APPLICATION_JSON_UTF8_VALUE)
    public void updateUser(@RequestBody @Validated UserVO userVO){
        UserVO user = null;
        Assert.notNull(user,"用户不存在！");
    }

//    @PostMapping("/error1")
//    public void error(){
//        int i=9/0;
//    }
//
//    @PostMapping("/error11")
//    public String error1(){
//        try {
//            int i=9/0;
//        }catch (Exception ex){
//            log.error("异常:{}",ex);
//            return "no";
//        }
//        return "ok";
//
//    }
//
//    @PostMapping("/error2")
//    public void error2(){
//        Integer.valueOf("a");
//    }
//
//    @PostMapping(value = "/error3")
//    public void error3(){
//        throw new BusinessException(ResultCode.USER_HAS_EXISTED);
//    }
//
//    @PostMapping("/error4")
//    public void error4(){
//        throw new RuntimeException("用户已存在！！");
//    }




//    @GetMapping(value = "/getSrt")
//    public String getStr(){
//        return "test";
//    }
//
//    @GetMapping(value = "/getObject")
//    public UserVO getObject(){
//        UserVO vo = new UserVO();
//        vo.setUsername("agan");
//        return vo;
//    }
//    @GetMapping(value = "empty")
//    public void empty(){
//
//    }
//
//    @GetMapping("/error")
//    public void error(){
//        int i=9/0;
//    }
//
//    @GetMapping(value = "/getResult")
//    public Result getResult(){
//        return Result.suc("test222");
//    }









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
