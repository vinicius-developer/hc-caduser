FROM openjdk:17
WORKDIR /app
COPY ./target/ /app
#COPY wait-for-it.sh  /app
#RUN chmod +x wait-for-it.sh
#ENTRYPOINT ["./wait-for-it.sh", "postgresqldb:5432", "--timeout=120" ,"--","java", "-jar", "cadusers-0.0.1-SNAPSHOT.jar"]
ENTRYPOINT ["java", "-jar", "cadusers-0.0.1-SNAPSHOT.jar"]
