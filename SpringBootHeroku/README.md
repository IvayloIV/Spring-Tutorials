1. Create heroku database
https://dashboard.heroku.com/apps/springboot-app-iv/resources

2. Setup database configuration in application
3. Change application.properties port - server.port=${PORT:8080}
4. Create jar file
5. Install heroku
6. cmd - heroku container:login
7. cmd - heroku container:push web --app=springboot-app-iv
8. cmd - heroku container:release web --app=springboot-app-iv