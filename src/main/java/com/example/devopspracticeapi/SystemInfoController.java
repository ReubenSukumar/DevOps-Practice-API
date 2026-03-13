package com.example.devopspracticeapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class SystemInfoController {

    @GetMapping("/health")
    public Map<String, String> health() {
        Map<String, String> response = new LinkedHashMap<>();
        response.put("status", "UP");
        response.put("service", "devops-practice-api");
        response.put("timestamp", LocalDateTime.now().toString());
        return response;
    }

    @GetMapping("/version")
    public Map<String, String> version() {
        Map<String, String> response = new LinkedHashMap<>();
        response.put("application", "devops-practice-api");
        response.put("version", "0.0.1-SNAPSHOT");
        response.put("environment", "Main");
        return response;
    }

    @GetMapping("/info")
    public Map<String, String> info() throws UnknownHostException {
        Map<String, String> response = new LinkedHashMap<>();
        response.put("hostname", InetAddress.getLocalHost().getHostName());
        response.put("ip_address", InetAddress.getLocalHost().getHostAddress());
        response.put("environment", "Main");
        response.put("java_version", System.getProperty("java.version"));
        response.put("os_name", System.getProperty("os.name"));
        return response;
    }

    @GetMapping("/hostname")
    public Map<String, String> hostname() throws UnknownHostException {
        Map<String, String> response = new LinkedHashMap<>();
        response.put("hostname", InetAddress.getLocalHost().getHostName());
        response.put("ip_address", InetAddress.getLocalHost().getHostAddress());
        return response;
    }

    @GetMapping("/memory")
    public Map<String, Object> memory() {
        Runtime runtime = Runtime.getRuntime();

        long totalMemoryMb = runtime.totalMemory() / (1024 * 1024);
        long freeMemoryMb = runtime.freeMemory() / (1024 * 1024);
        long usedMemoryMb = totalMemoryMb - freeMemoryMb;
        long maxMemoryMb = runtime.maxMemory() / (1024 * 1024);

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("used_memory_mb", usedMemoryMb);
        response.put("free_memory_mb", freeMemoryMb);
        response.put("total_memory_mb", totalMemoryMb);
        response.put("max_memory_mb", maxMemoryMb);
        return response;
    }

    @GetMapping("/cpu")
    public Map<String, Object> cpu() {
        double systemLoadAverage = ManagementFactory.getOperatingSystemMXBean().getSystemLoadAverage();

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("system_load_average", systemLoadAverage);
        response.put("available_processors", Runtime.getRuntime().availableProcessors());
        return response;
    }
}