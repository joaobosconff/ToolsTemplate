# Build .jar
FROM maven:3.8.5-openjdk-17-slim as builder

WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src/ ./src/
RUN mvn clean package

# Create a custom jre using jlink
FROM eclipse-temurin:17 as jre-build

COPY --from=builder /app/target/*.jar /app/app.jar

WORKDIR /app

# Get all necessary modules from .jar using jdeps
RUN jar xf app.jar
RUN jdeps \
    --ignore-missing-deps \
    --print-module-deps \
    --multi-release 17 \
    --recursive \
    --class-path 'BOOT-INF/lib/*' \
    app.jar > modules.txt

# Create jre using list of modules from .jar
RUN $JAVA_HOME/bin/jlink \
         --add-modules $(cat modules.txt) \
         --strip-debug \
         --no-man-pages \
         --no-header-files \
         --compress=2 \
         --output /javaruntime


# Setting the env on base image
FROM debian:buster-slim

ENV JAVA_HOME=/opt/java/openjdk
ENV PATH "${JAVA_HOME}/bin:${PATH}"
COPY --from=jre-build /javaruntime $JAVA_HOME


# Copy the .jar and running
RUN mkdir /app
WORKDIR /app
COPY --from=jre-build /app/app.jar app.jar
ENV SERVER_PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","./app.jar"]