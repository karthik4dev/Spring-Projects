FROM ubuntu:latest
LABEL "Maintainer" "KarthikPN"

RUN apt-get update
RUN apt-get install -y iputils-ping
# RUN add-apt-repository ppa:webupd8team/java
RUN apt-get install -y vim
RUN apt-get install -y mysql-client
# Since the license for Oracle JDK 8 has changed this is no longer applicable hence use Open JDK 8 instead
#RUN echo "oracle-java8-installer shared/accepted-oracle-license-v1-1 boolean true" | debconf-set-selections
# RUN apt-get update && apt-get install -y oracle-java8-installer maven

RUN apt-get install -y openjdk-17-jdk