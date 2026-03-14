# health-service

## Description

The **health-service** provides a simple health check endpoint used to verify whether the application is running.

---

# Port

8091

---

# Endpoint

GET /info

Example:
http://EC2-IP:8091/health

---

# Example Response

{
"status": "UP",
"service": "health-service",
"timestamp": "2026-03-14T12:34:10"
}

---

# Build

mvn clean package

---

# Deployment

Deployment is performed via **GitHub Actions workflow**.

Deploy health-service

option can be selected during pipeline execution.


