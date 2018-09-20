# Demo REST Spring Boot Application

## Useful Tips
### Authorization
Spring Boot Security Starter

`<!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-security -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>`

### Static Filtering
Just add `@JsonIgnore` to exclude corresponding bean properties from response.
Or use the `@JsonIgnoreProperties` to configure class. 
### Dymanic Filtering
Use `MappingJacksonValue` and `SimpleFilterProvider`.

### Monitoring
Please use the `spring-boot-started-actuator` and `spring-data-rest-hal-browser`.
Do not forget to setup `mapagement.endpoints.web.exposure.inclue=` into .properties file.
