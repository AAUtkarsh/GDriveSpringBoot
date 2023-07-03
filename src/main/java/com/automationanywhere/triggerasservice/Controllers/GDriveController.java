package com.automationanywhere.triggerasservice.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

@RestController
@RequestMapping("/gdrive")
public class GDriveController {

    @GetMapping
    public String hello() {
        return "Hello World";
    }


    @PostMapping("/file")
    public ResponseEntity<String> receiveNotificationForFileChange(HttpServletRequest request) {

        String channelId = request.getHeader("X-Goog-Channel-ID");
        String channelToken = request.getHeader("X-Goog-Channel-Token");
        String channelExpiration = request.getHeader("X-Goog-Channel-Expiration");
        String resourceId = request.getHeader("X-Goog-Resource-ID");
        String resourceUri = request.getHeader("X-Goog-Resource-URI");
        String resourceState = request.getHeader("X-Goog-Resource-State");
        String changed = request.getHeader("X-Goog-Changed");
        String messageNumber = request.getHeader("X-Goog-Message-Number");

        System.out.println("Received notification:");
        System.out.println("Channel ID: " + channelId);
        System.out.println("Channel Token: " + channelToken);
        System.out.println("Channel Expiration: " + channelExpiration);
        System.out.println("Resource ID: " + resourceId);
        System.out.println("Resource URI: " + resourceUri);
        System.out.println("Resource State: " + resourceState);
        System.out.println("Changed: " + changed);
        System.out.println("Message Number: " + messageNumber);


        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @PostMapping("/changes")
    public ResponseEntity<String> receiveNotificationForAllChanges(HttpServletRequest request) throws IOException {
        String channelId = request.getHeader("X-Goog-Channel-ID");
        String channelToken = request.getHeader("X-Goog-Channel-Token");
        String channelExpiration = request.getHeader("X-Goog-Channel-Expiration");
        String resourceId = request.getHeader("X-Goog-Resource-ID");
        String resourceUri = request.getHeader("X-Goog-Resource-URI");
        String resourceState = request.getHeader("X-Goog-Resource-State");
        String messageNumber = request.getHeader("X-Goog-Message-Number");

        System.out.println("Received notification:");
        System.out.println("Channel ID: " + channelId);
        System.out.println("Channel Token: " + channelToken);
        System.out.println("Channel Expiration: " + channelExpiration);
        System.out.println("Resource ID: " + resourceId);
        System.out.println("Resource URI: " + resourceUri);
        System.out.println("Resource State: " + resourceState);
        System.out.println("Message Number: " + messageNumber);

        String requestBody = extractRequestBody(request);
        System.out.println("Request Body: " + requestBody);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    private String extractRequestBody(HttpServletRequest request) throws IOException {
        StringBuilder requestBody = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            requestBody.append(line);
        }
        return requestBody.toString();
    }
}
