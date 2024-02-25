FROM openjdk:17
EXPOSE 8083
ADD target/streaming-service.jar streaming-service.jar
CMD ["java","-jar","streaming-service.jar"]