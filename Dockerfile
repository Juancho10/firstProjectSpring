FROM openjdk:21-jdk-slim
EXPOSE 8080
COPY --from=build /build/libs/platzi-market-1.0.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]
