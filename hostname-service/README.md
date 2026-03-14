# hostname-service

## Description

The **hostname-service** returns the hostname and IP address of the server.

This is useful for verifying which server instance is responding.


---

# Port

8092

---

# Endpoint

GET /info

Example:
http://EC2-IP:8092/hostname

---

# Example Response

{
"service": "hostname-service",
"hostname": "ip-172-31-21-10",
"ip_address": "172.31.21.10"
}

---

# Build

mvn clean package

---

# Deployment

Deployment is performed through the **GitHub Actions workflow**.

Deploy hostname-service

option can be selected when running the workflow.



