FROM openjdk:8-jre-slim
MAINTAINER zwb
ENV PARAMS=""
ENV TZ=PRC
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
ADD target/test-*.jar /test.jar
#EXPOSE 8080
ENTRYPOINT ["sh","-c","java -jar $JAVA_OPTS /test.jar $PARAMS"]