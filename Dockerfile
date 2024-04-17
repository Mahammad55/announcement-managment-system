FROM openjdk:17
COPY build/libs/announcement-management-system-0.0.1-SNAPSHOT.jar /app/
CMD ["java","-jar","/app/announcement-management-system-0.0.1-SNAPSHOT.jar"]