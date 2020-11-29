FROM adoptopenjdk:11-jre-hotspot
LABEL maintainer "P.Merdala@interia.pl"
#HEALTHCHECK --interval=5s \
#            -- timeout=5s \
#            CMD crul -f http://localhost:8000||exit 1
#EXPOSE 8000
RUN mkdir /opt/app
#COPY japp.jar /opt/app
#CMD ["java", "-jar", "/opt/app/japp.jar"]