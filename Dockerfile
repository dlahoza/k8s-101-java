FROM gradle:jdk10 as builder

COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build 

FROM openjdk:10-jre-slim
EXPOSE 8080

COPY --from=builder /home/gradle/src/build/libs/todo-manager-1.0-SNAPSHOT.jar /app/todo-manager.jar
COPY --from=builder /home/gradle/src/entrypoint.sh /app/entrypoint.sh
WORKDIR /app/
CMD /app/entrypoint.sh

