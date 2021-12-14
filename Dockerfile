FROM openjdk
COPY target/gerenciamento-financeiro-1.0-SNAPSHOT.jar gerenciamento-financeiro-1.0.jar
ENTRYPOINT ["java", "-jar", "gerenciamento-financeiro-1.0.jar"]