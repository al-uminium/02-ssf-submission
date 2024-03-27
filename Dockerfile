# Build container
FROM openjdk:21-jdk-bullseye AS builder

## Build
# Create a directory for our application
WORKDIR /app

COPY mvnw .
COPY pom.xml .
COPY movies.json .
COPY .mvn .mvn
COPY src src

# target/weather-0.0.1-SNAPSHOT.jar
RUN /app/mvnw package -Dmaven.test.skip=true

# Run container
FROM openjdk:21-jdk-bullseye 

WORKDIR /app_run
COPY --from=builder /app/target/ibf-b4-ssf-assessment-0.0.1-SNAPSHOT.jar movie.jar
COPY --from=builder /app/movies.json .
## RUN
ENV PORT=8080
EXPOSE ${PORT}

HEALTHCHECK --interval=30s --timeout=5s --start-period=5s --retries=3 \
      CMD curl http://127.0.0.1:${PORT}/healthz || exit 1

ENTRYPOINT SERVER_PORT=${PORT} java -jar movie.jar