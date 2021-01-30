FROM adoptopenjdk:11-jre-hotspot

ARG JAR_FILE=target/powergiphy*.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]

#WORK IN PROGRESS----------------------------------------->
#FROM adoptopenjdk:11-jre-hotspot as builder
#WORKDIR application
#ARG JAR_FILE=target/powergiphy*.jar
#COPY ${JAR_FILE} application.jar
#RUN java -Djarmode=layertools -jar application.jar extract

#FROM adoptopenjdk:11-jre-hotspot
#WORKDIR application
#COPY --from=builder application/dependencies/ ./
#COPY --from=builder application/snapshot-dependencies/ ./
#COPY --from=builder application/application/ ./
#ENTRYPOINT ["java","-jar","/application.jar"]
