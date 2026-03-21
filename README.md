# Container Design and Deployment
## Assignment 1: Deploying a Microservice on AWS with AutoScaling policy


![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.1.4-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![AWS](https://img.shields.io/badge/AWS-%23FF9900.svg?style=for-the-badge&logo=amazon-aws&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)

![GitHub repo size](https://img.shields.io/github/repo-size/joeaoregan/jor-tetris?color=orange)
![GitHub last commit](https://img.shields.io/github/last-commit/joeaoregan/jor-tetris?color=blue)

### Technological University of the Shannon
#### MSc Software Development with Cloud Native Computing

---

<a href="https://youtu.be/QPC0n3RcKgY" target="_blank"><img src="src\main\resources\static\asg_scaling.jpg" title="CDD CA1 Demo" width="200"/></a>

###### Demo Video on YouTube

---

# AWS Microservice: Auto Scaling & Load Balancing Deployment
## Project Overview
This project demonstrates the deployment of a stateless microservice (e.g., a coupon service) on AWS using a highly available and scalable architecture. The goal is to manage unpredictable and "spiky" incoming traffic through horizontal scaling and automated load distribution.

## Architecture Components
- **EC2 Instances**: Nano or micro instances running the microservice via a user data configuration script.
- **Application Load Balancer (ALB)**: An internet-facing balancer that distributes traffic across multiple instances.
- **Auto Scaling Group (ASG)**: Automatically manages the fleet size based on CPU demand, handling both scale-up and scale-down events.
- **External Database**: A centralized RDS instance or a separate EC2 database to ensure the application remains stateless.
- **CloudWatch**: Used for monitoring CPU usage, tracking instance counts, and triggering alarms for scaling events.

## Task Requirements
### Part 1: Service Launch & Load Simulation
1. **Deployment**: Provision an EC2 instance and use User Data to automate the microservice startup.
2. **Load Testing**: Modify the service with CPU-intensive code and use a Python script or the stress package to simulate heavy traffic.
3. **Monitoring**: Use the AWS Monitoring tab to verify CPU spikes during tests.

### Part 2: Scaling & High Availability
1. **Template Creation**: Define a Launch Template for standardized instance deployment.
2. **Automation**: Configure an ASG and attach it to an ALB.
3. **Validation**: Demonstrate the full lifecycle:
    - Traffic routing through the ALB.
    - Scale-up: New instances launching under load.
    - Scale-down: Instances terminating when idle.
    - Alerting: CloudWatch Alarms notifying on scaling events.
  
## Deliverables
- **Technical Report (30%)**: Documentation including an introduction to scaling concepts, configuration screenshots, CloudWatch test results, and an evaluation of costs and sustainability.
- **Screencast (70%)**: A maximum 5-minute video featuring a camera-on presentation. It must include text overlays and diagrams to explain the deployment and demonstrate the live scaling process