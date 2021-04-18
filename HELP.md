Spring Boot app & Postgresql & Docker compose
With Redis for Pub-Sub model


How to run app
By this command

./run.sh
 
  1. It clean docker files from the system (which is not necessary)
  2. Build project by using `mvn clean install` command which run test cases as well.
  3. `docker-compose build` build image of project
  4. `docker-compose up -d` runs the containers in background
  
  
  
What happens at startup.
1) One conatiner of postgress DB get started
2) A table name `credential` gets created with two column email and password.
3) A dummy record get created with following value
  "email": "ABC1@gmail.com", "password": "Java2blog11",



How to test?

URL: localhost:8080/update
Sample Request: 
  {
        "email": "ABC1@gmail.com",
        "password": "Java2blog11",
        "confirmPassword": "Java2blog1"
    }
    
Sample response :
1) Valid case:
   "SUCCESS" 
2) InValid Case:
{
    "timestamp": "2021-04-18T07:02:54.830+00:00",
    "status": 400,
    "error": "Email id doesnt exist in the system"
}
       
       
       
       
       