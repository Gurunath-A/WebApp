FROM tomcat:latest

LABEL maintainer="Gurunath"

ADD ./target/MyLoginApp.war /usr/local/tomcat/webapps/

EXPOSE 8080

CMD ["catalina.sh", "run"]
