# ToDoList
System Requirements;

You must install mysql and you must create databese in mysql and as a result
Configure application-properties as in the example

application-properties EXAMPLE:

spring.jpa.database=mysql

security.basic.enabled=false

spring.datasource.driver-class-name = com.mysql.jdbc.Driver

spring.datasource.url = jdbc:mysql://localhost:3306/created-database?

useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC

spring.datasource.username = root

spring.datasource.password = 123456

spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL8Dialect

spring.jpa.hibernate.ddl-auto = update


