package com.automationanywhere.googledrive.com.automationanywhere.googledrive.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class Controller {

    @GetMapping
    public String hello() {
        return "Hello World";
    }

    @PostMapping
    public ResponseEntity<?> webhook(@RequestBody String obj) {
        System.out.println(obj);
        return new ResponseEntity<>("Successfully received notification", HttpStatus.OK);
    }


}
