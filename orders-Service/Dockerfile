FROM maven:3.8.5-openjdk-18 as build
WORKDIR /home/app
COPY . .
RUN mvn -f pom.xml clean package

FROM openjdk:19-ea-5-jdk-alpine
WORKDIR /usr/local/lib/
COPY --from=build /home/app/target/app.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
