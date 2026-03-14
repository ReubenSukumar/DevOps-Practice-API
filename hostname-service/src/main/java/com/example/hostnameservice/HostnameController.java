package com.example.hostnameservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class HostnameController {

    @GetMapping("/hostname")
    public Map<String, String> hostname() throws UnknownHostException {
        Map<String, String> response = new LinkedHashMap<>();
        response.put("service", "hostname-service");
        response.put("hostname", InetAddress.getLocalHost().getHostName());
        response.put("ip_address", InetAddress.getLocalHost().getHostAddress());
        response.put("Message", "Boliye Bhai!");
        return response;
    }
}