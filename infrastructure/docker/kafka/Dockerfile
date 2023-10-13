FROM openjdk:8-jre-slim

ENV KAFKA_VERSION=3.6.0
ENV SCALA_VERSION=2.13
ENV KAFKA_HOME=/opt/kafka

RUN apt-get update && apt-get install -y wget && rm -rf /var/lib/apt/lists/*

RUN wget -q https://downloads.apache.org/kafka/${KAFKA_VERSION}/kafka_${SCALA_VERSION}-${KAFKA_VERSION}.tgz -O /tmp/kafka.tgz && \
    tar xfz /tmp/kafka.tgz -C /opt && \
    rm /tmp/kafka.tgz && \
    mv /opt/kafka_${SCALA_VERSION}-${KAFKA_VERSION} ${KAFKA_HOME}

# find a way to add 127.0.0.1 as advertised listener to server.properties to be able to use localhost in application.properties


EXPOSE 2181 9092

CMD ${KAFKA_HOME}/bin/zookeeper-server-start.sh ${KAFKA_HOME}/config/zookeeper.properties & \
    sleep 10 && \
    ${KAFKA_HOME}/bin/kafka-server-start.sh ${KAFKA_HOME}/config/server.properties
