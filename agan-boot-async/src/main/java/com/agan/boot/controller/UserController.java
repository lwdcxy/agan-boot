package com.agan.boot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {

    @RequestMapping("/user")
    public UserVO user(){
        UserVO userVO = new UserVO();
        userVO.setId(100);
        userVO.setUsername("agan");
        return userVO;
    }
    @RequestMapping("/log")
    public void log(){
        log.trace("---trace---");
        log.debug("---debug---");
        log.info("---info---");
        log.warn("---warn---");
        log.error("---error---");
    }
}
