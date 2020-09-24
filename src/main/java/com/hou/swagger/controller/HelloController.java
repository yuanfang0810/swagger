package com.hou.swagger.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hou
 * @description
 * @data 2020/9/23 14:34
 **/
@RestController
public class HelloController {

    @RequestMapping(value = "hello")
    public String hello(){
        return "hello";
    }
}
