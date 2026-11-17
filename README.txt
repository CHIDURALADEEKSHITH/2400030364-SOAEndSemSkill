ROUND ROBIN LOAD BALANCING - SOA LAB

REQUIREMENTS
- JDK 17
- Maven 3.8+
- Internet connection for first Maven dependency download
- Eclipse/STS or terminal

PROJECTS
1. eureka-server  : Eureka registry, port 8761
2. doctor-service : One Spring Boot service, run three times on ports 8081, 8082, 8083
3. api-gateway    : Gateway, port 8080

RUN ORDER
1. Import all three Maven projects into STS/Eclipse (File > Import > Existing Maven Projects).
2. Run EurekaServerApplication.
   Open http://localhost:8761
3. Run DoctorServiceApplication three times:
   - First run: right-click project > Run As > Spring Boot App.
   - For the second and third runs, use Run Configurations > Spring Boot App > Arguments.
   - Set Program arguments to: --server.port=8082
   - Create another launch configuration with: --server.port=8083
   The first instance uses the default port 8081.
   All three instances register as DOCTOR-SERVICE.
4. Run ApiGatewayApplication on port 8080.
5. Test repeatedly:
   GET http://localhost:8080/doctors
   Expected sequence (may start at any instance): 8081, 8082, 8083, then repeat.
6. Eureka dashboard: http://localhost:8761

IMPORTANT
- Do not start three copies on the same port.
- If Maven reports dependency download errors, update the Maven project and ensure internet access.
- The gateway uses Spring Cloud LoadBalancer with Eureka service discovery. The default load-balancing strategy is round robin.
