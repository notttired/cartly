FROM eclipse-temurin:21-jdk-alpine

RUN apk update && apk add --no-cache \
    maven \
    chromium-chromedriver \
    chromium \
    nss \
    freetype \
    harfbuzz \
    ttf-freefont && \
    chromium --version

ENV CHROME_BIN=/usr/bin/chromium-browser \
    CHROME_DRIVER=/usr/bin/chromedriver \
    JAVA_OPTS="-Dwebdriver.chrome.driver=/usr/bin/chromedriver"

WORKDIR /app

COPY pom.xml ./

RUN mvn dependency:go-offline -B

COPY . .

RUN mvn clean package spring-boot:repackage

ENV PORT=8080

EXPOSE 8080

CMD ["java", "-jar", "target/cartly-1.0-SNAPSHOT.jar"]