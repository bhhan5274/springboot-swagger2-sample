package com.bhhan.swagger.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hbh5274@gmail.com on 2020-09-28
 * Github : http://github.com/bhhan5274
 */

@RestController
public class RegularRestController {
    @GetMapping("/home")
    public String getSession(){
        return "hello";
    }
}
