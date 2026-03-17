# Container Design and Deployment
## Assignment 1: Deploying a Microservice on AWS with AutoScaling policy
### Technological University of the Shannon
#### MSc Software Development with Cloud Native Computing

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