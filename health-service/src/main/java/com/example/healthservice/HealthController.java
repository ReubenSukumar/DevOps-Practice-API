package com.example.healthservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class HealthController {

    @GetMapping("/health")
    public Map<String, String> health() {
        Map<String, String> response = new LinkedHashMap<>();
        response.put("status", "UP");
        response.put("service", "Health-service");
        response.put("updated_on", "Updated on 14-03-2026 T 14:50PM IST");
        response.put("timestamp", LocalDateTime.now().toString());
        return response;
    }
}