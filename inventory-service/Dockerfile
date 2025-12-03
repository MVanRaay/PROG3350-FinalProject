# Build Stage
FROM eclipse-temurin AS build
WORKDIR /workspace

COPY pom.xml ./
COPY .mvn .mvn
COPY mvnw ./

RUN ./mvnw -q -DskipTests dependency:go-offline

COPY src ./src

RUN ./mvnw -q -DskipTests package

# Runtime Stage
FROM eclipse-temurin:21-jre
WORKDIR /app
RUN useradd -ms /bin/bash spring
USER spring

COPY --from=build /workspace/target/*.jar /app/app.jar

#EXPOSE 0
ENTRYPOINT ["java", "-jar", "/app/app.jar"]