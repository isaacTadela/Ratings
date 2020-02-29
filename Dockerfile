FROM java:8
EXPOSE 8081
ADD /target/Ratings.jar Ratings.jar
ENTRYPOINT ["java" , "-jar", "Ratings.jar"]