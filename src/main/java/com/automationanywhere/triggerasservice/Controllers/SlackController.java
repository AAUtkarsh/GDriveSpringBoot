package com.automationanywhere.triggerasservice.Controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/slack")
public class SlackController {

    @GetMapping
    public ResponseEntity<String> sayHello() {
        return new ResponseEntity<>("Hello form webhook !", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> receiveNotifications(@RequestBody String payload) {
        System.out.println(payload);
        return new ResponseEntity<>("Notification Successfully received", HttpStatus.OK);
    }
}
