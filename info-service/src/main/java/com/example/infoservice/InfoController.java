package com.example.infoservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class InfoController {

    @GetMapping("/info")
    public Map<String, String> info() throws UnknownHostException {
        Map<String, String> response = new LinkedHashMap<>();
        response.put("service", "info-service");
        response.put("hostname", InetAddress.getLocalHost().getHostName());
        response.put("ip_address", InetAddress.getLocalHost().getHostAddress());
        response.put("java_version", System.getProperty("java.version"));
        response.put("os_name", System.getProperty("os.name"));
        response.put("Message", "Hello All!");
        return response;
    }
}