FROM tomcat:9.0
ENV APP_HOME=/usr/local/tomcat/webapps
WORKDIR $APP_HOME
COPY build/libs/conference.war .
ENTRYPOINT ["catalina.sh", "run"]