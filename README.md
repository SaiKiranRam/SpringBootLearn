# SpringBootLearn

  The sample project is based on mapping programmer tables with the technologies they learnt using REST WS. Programmer has a @OneToMany relation with Technology

###### Primary Keys are to be passed by user for now

DataBase URL: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:course

**Adding Programmer(along with technologies):  URL: http://localhost:8080/4   POST Method

JSON:
{
        "id": 4,
        "first_name": "Iron",
        "last_name": "Man",
        "technologies": [{
                            "tId": 1,
                            "techno": "AWS",
                            "exp": 3,
                            "specialization": "IAM"
                        },
                        {
                            "tId": 2,
                            "techno": "GCP",
                            "exp": 4,
                            "specialization": "Data Store"
                        }]
    }
    
**Adding Programmer Only:   URL: http://localhost:8080/1    POST Method

JSON
{
        "id": 1,
        "first_name": "Green",
        "last_name": "Hulk"
}

**Get
  All Programmers URL: http://localhost:8080/
  Specific Programmer http://localhost:8080/4 or http://localhost:8080/1
  All Technologies of a programmer: http://localhost:8080/1/tech or http://localhost:8080/4/tech
  
**Delete URLs for
    Programmer(with linked techs):   http://localhost:8080/1 or http://localhost:8080/4
    One Tech:     http://localhost:8080/1/tech/Java
    All Techs:    http://localhost:8080/4/allTech
    
**Update(even add if doesn't exist) any field(s) of a programmer   (POST)
 URL:    http://localhost:8080/1
 
 **Add a new technology to a user:
  URL: http://localhost:8080/1/tech



