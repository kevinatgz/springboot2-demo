package com.example.springbootdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class TestController {
    @RequestMapping("index")
    public ResponseEntity<String> test(){

        return new ResponseEntity<String>("test",HttpStatus.OK);
    }

}
