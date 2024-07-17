FROM maven:3-eclipse-temurin-21-alpine as build
COPY . .
RUN mvn clean package -DskipTests


FROM amazoncorretto:21-alpine
RUN mkdir /apk
WORKDIR /apk
COPY --from=build /target/*.jar atipera-api.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","atipera-api.jar"]