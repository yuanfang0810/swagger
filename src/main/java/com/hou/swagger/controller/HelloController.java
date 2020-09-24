package com.hou.swagger.controller;

import com.hou.swagger.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

/**
 * @author hou
 * @description
 * @data 2020/9/23 14:34
 **/

@Api(description = "Hello控制类")
@RestController
public class HelloController {
    @ApiOperation("Hello控制类")
    @GetMapping (value = "hello")
    public String hello(){
        return "hello";
    }
    @ApiOperation("user控制类")
    @PostMapping("/user")
    public User user(){
        return new User();
    }
    @ApiOperation("Post测试类")
    @PostMapping ("/post")
    public User post(@ApiParam("用户名") User user){
        return user;
    }
    @ApiOperation("Post测试类")
    @PostMapping ("/post")
    public User postt(@ApiParam("用户名") User user){
        return user;
    }
}
