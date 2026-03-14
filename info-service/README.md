# info-service

## Description

The **info-service** exposes system information about the server running the application.

This includes hostname, IP address, Java version, and OS details.

---

# Port

8090

---

# Endpoint

GET /info

Example:
http://EC2-IP:8090/info

---

# Example Response

{
"service": "info-service",
"hostname": "ip-172-31-21-10",
"ip_address": "172.31.21.10",
"java_version": "17",
"os_name": "Linux"
}

---

# Build

mvn clean package

---

# Deployment

Deployment is handled through the **GitHub Actions pipeline**.

Deploy info-service

option can be selected during workflow execution.

