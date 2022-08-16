package com.example.demo.redis.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
public class TestController {

    @RequestMapping("test")
    public String test1(HttpSession session) {

        session.setAttribute("email", "test");

        return "test";
    }
}
