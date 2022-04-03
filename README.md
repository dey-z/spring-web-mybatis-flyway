# spring-web-mybatis-flyway

## (1) project dependencies

- maven: 4.0.0 (no install required)
- SpringBoot: 2.6.6 (no install required)
- Java: 1.8/11/14 (install required)

## (2) other springboot dependencies

- migration
    - flyway: 5.2.4
- Persistence APIS
    - MyBatis: 2.2.2
- MySql connector
    - for 5.7 MySql version

## (3) Editor used

- IntelliJ Idea
- CheckStyle-IDEA plugin installed but real time scans disabled
- Save Actions plugin installed with Auto Save Actions configured
- Code Style for Java configured from local checkstyle.xml schema

## (4) Running web application from Editor

- local profile run(port 8099)

> use the following VM arg

```
-Dspring.profiles.active=local
```

- default profile can also be run(port 8080)
- RUN modes
    - Java Application(for IntelliJ community edition)
    - SpringBoot Application(for IntelliJ ultimate edition)

## (5) Running web application using mvn

- clean build

```
./mvnw clean install -Dmaven.test.skip=true
```

- run

```
java -jar -Dspring.profiles.active=local target/usecasemib-0.0.1-SNAPSHOT.jar
```

## (6) MySQL is needed either dockerized or local
