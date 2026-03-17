#FROM openjdk:17-alpine
# coupon-app1 - 615MB
#FROM openjdk:17-ea-alpine
# coupon-app2 - 548MB
FROM amazoncorretto:17-alpine
# coupon-app3 - 548MB
#FROM amazoncorretto:17-alpine-jdk
# coupon-app4 - 604MB
#FROM eclipse-temurin:17-alpine
# coupon-app5 - 546MB
#FROM eclipse-temurin:17.0.17_10-jre-ubi9-minimal
#FROM eclipse-temurin
ADD target/couponservice-0.0.1-SNAPSHOT.jar couponservice-0.0.1-SNAPSHOT.jar
ENTRYPOINT [ "java","-jar","couponservice-0.0.1-SNAPSHOT.jar" ]