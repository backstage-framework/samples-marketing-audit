ARG JDK_VERSION=17-jdk-slim

FROM openjdk:$JDK_VERSION as build
COPY . /tmp
WORKDIR /tmp
RUN ./gradlew -b build.gradle clean bootJar -PappVersion=$(date '+%Y-%m-%d') --no-daemon

FROM openjdk:$JDK_VERSION
COPY --from=build /tmp/app/build/libs/*.jar /opt/app.jar

EXPOSE 8080
WORKDIR /opt
ENTRYPOINT ["java","-jar","app.jar"]
