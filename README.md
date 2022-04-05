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
- Actuator
    - for health check etc
- Lombok
    - as maven plugin

## (3) Editor & settings

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
- RUN modes(either is OK)
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

## (7) sample uris

- get(, from master)

> http://localhost:8080/api/targets  
> http://localhost:8080/api/projects

- post(will add project from master database)

> http://localhost:8099/api/targets/add/1

- put

> http://localhost:8099/api/targets/update/7?projectName=helloChange

- delete

> http://localhost:8099/api/targets/delete/3

## (8) Running sample batch w/o web server start but active dependencies

- RUN Modes(either is ok)
    - IntelliJ application
    - 👇 command if using jar
  > java -cp target/usecasemib-0.0.1-SNAPSHOT.jar -Dloader.main=co.jp.spring.usecasemib.batch.Extraction org.springframework.boot.loader.PropertiesLauncher

## (9) Multi-DB datasource configured at startup with mybatis active

- usecasemib
- useasemib_master
