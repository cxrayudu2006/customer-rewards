# Customer Rewards

In this app, I used H2 in-memory database for demo purpose

**Application.properties**

```
spring.datasource.url=jdbc:h2:mem:test_db;DB_CLOSE_DELAY=-1;
spring.datasource.username=sa
spring.datasource.password=
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.platform=h2
spring.jpa.hibernate.ddl-auto=none
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect
```

**To Run without Docker**

```
> mvn clean install
> java -jar target/customer-rewards.jar
```
