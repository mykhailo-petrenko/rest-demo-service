# Demo REST Spring Boot Application

## Useful Tips
### Static Filtering
Just add `@JsonIgnore` to exclude corresponding bean properties from response.
Or use the `@JsonIgnoreProperties` to configure class. 
### Dymanic Filtering
Use `MappingJacksonValue` and `SimpleFilterProvider`.

### Monitoring
Please use the `spring-boot-started-actuator` and `spring-data-rest-hal-browser`.
Do not forget to setup `mapagement.endpoints.web.exposure.inclue=` into .properties file.
