### Taxi Service
This simple web app based on SOLID principles, N-tier architecture and used JDBC. Also this project includes custom-made annotations and an injector which utilizes Reflection.
In this web app we have next posibilites:
- Autenification and registration.
- Add new cars and drivers, And make dependency for them.
  
###  Technologies
- Apache Tomcat,
- MySQL
- JDBC
- Servlet
- JSTL
- JSP
- HTML, CSS

### Setup steps...
1) Create your DB. All settings you can take from file `src/main/resources/init_db.sql`

2) Add your parameters to `taxi/util/ConnectionUtil.java`

3) Configure Apache Tomcat (with taxi_service:war exploded and application context: "/")

### DB diagram

![image](https://user-images.githubusercontent.com/80956357/123057883-e9158900-d410-11eb-9919-8ddc5d74c675.png)


