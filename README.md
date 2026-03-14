# Java Microservices Deployment with GitHub Actions

## Project Overview

This project demonstrates how to deploy multiple **Java Spring Boot microservices** on a **single AWS EC2 instance** using **GitHub Actions CI/CD pipelines**.

Each microservice runs independently on its own port and exposes a specific REST endpoint.

The deployment workflow allows selecting which services to deploy during runtime.

---

## Architecture

GitHub Repository
│
├── GitHub Actions Pipeline
│
└── AWS EC2 Instance
│
├── info-service (Port 8090)
├── health-service (Port 8091)
└── hostname-service (Port 8092)

---

# Services

| Service | Port | Endpoint |
|------|------|------|
| info-service | 8090 | /info |
| health-service | 8091 | /health |
| hostname-service | 8092 | /hostname |

---

# Repository Structure

├── info-service
│ ├── src
│ └── pom.xml
│
├── health-service
│ ├── src
│ └── pom.xml
│
├── hostname-service
│ ├── src
│ └── pom.xml
│
└── .github/workflows
└── deploy-selected-service.yml

---

# CI/CD Pipeline

Deployment is handled through **GitHub Actions**.

The workflow allows selecting which services to deploy.

### Options

- Deploy info-service
- Deploy health-service
- Deploy hostname-service
- Deploy all services

---

# GitHub Secrets Required

| Secret | Description |
|------|------|
| EC2_HOST | Public IP or DNS of EC2 instance |
| EC2_SSH_KEY | Private SSH key used for deployment |

---

# Deployment Process

1. Build selected service(s) using Maven
2. Copy JAR files to EC2 via SSH
3. Restart corresponding systemd service
4. Verify service status

---

# API Endpoints

Example:
http://EC2-IP:8090/info

http://EC2-IP:8091/health

http://EC2-IP:8092/hostname

---

# Systemd Services

Each microservice runs as an independent **systemd service** on EC2.

info-service.service
health-service.service
hostname-service.service

---

# Local Build

Example build:
cd info-service
mvn clean package

---

# Future Improvements

Possible enhancements:

- API Gateway using Nginx
- Service discovery
- Docker containerization
- Kubernetes deployment
- Automatic service detection in CI/CD

---

# Author

DevOps Practice Project  
Java + GitHub Actions + AWS EC2
