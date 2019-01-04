FROM openjdk:8-jdk

RUN apt-get update \
    && apt-get install -y openssh-server vim

ADD ./spark-2.3.2-bin-hadoop2.7.tgz soft/

RUN mv /soft/spark-2.3.2-bin-hadoop2.7 /soft/spark-2.3.2

WORKDIR /soft/spark-2.3.2

ADD ./entrypoint.sh /

ENTRYPOINT ["/entrypoint.sh"]