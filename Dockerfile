FROM openjdk:8-jre-slim
MAINTAINER zwb
ENV PARAMS=""
ENV TZ=PRC
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
ADD target/demo-*.jar /demo.jar
ENTRYPOINT ["sh","-c","java -jar $JAVA_OPTS /demo.jar $PARAMS"]