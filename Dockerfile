FROM openjdk:8
VOLUME /tmp
ADD ./target/ProductosBancarioMS-0.0.1-SNAPSHOT.jar micro-bancario.jar
ENTRYPOINT ["java","-jar","/micro-bancario.jar"]