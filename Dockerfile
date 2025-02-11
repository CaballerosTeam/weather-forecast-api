FROM amazoncorretto:21.0.6 as builder
ARG APP_DIR='/usr/src/weather-forecast'
WORKDIR $APP_DIR
COPY . $APP_DIR
RUN ./gradlew clean bootJar

FROM amazoncorretto:21.0.6
WORKDIR /srv/www
COPY --from=builder /usr/src/weather-forecast/build/libs/weather-forecast-1.0.0.jar weather-forecast-1.0.0.jar
CMD java -Xmx512m -jar weather-forecast-1.0.0.jar
