FROM openjdk:11
MAINTAINER habibie

ENV JAVA_HOME /opt/jdk

ENV PATH ${PATH}:${JAVA_HOME}/bin

RUN apt-get update -y
RUN apt-get upgrade -y

RUN apt-get install -y libxext6
RUN apt-get install -y libxrender1
RUN apt-get install -y libxtst6
RUN apt-get install -y libxi6

COPY ReportClientApp-1.0-SNAPSHOT-jar-with-dependencies.jar ReportClientApp-1.0-SNAPSHOT-jar-with-dependencies.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Djava.awt.headless=true","-jar","/ReportClientApp-1.0-SNAPSHOT-jar-with-dependencies.jar", "--no-gui"]
