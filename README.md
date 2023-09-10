# <p align="center">:clapper: Cinema Control Application :clapper:</p>


# :closed_book: General info:
A simple web-application that supports authentication, registration and other CRUD operations. You can check movie sessions, buy tickets, add new movies, etc.
The application uses Spring Boot, Hibernate and is built on Rest principles. The user can have the `user` role or the `admin` role.

# :eyes: About project:
The application has the ability:
- View lists of cinema halls, movies, all movie sessions, orders, movie sessions for a movie on a date
- Find movie session by id, shopping cart by user, user by email
- Add movie, movie session, cinema hall, order
- Change movie session by id
- Delete movie session </br>

There are two types of roles in the application: `ADMIN` and `USER`. During registration, the user is assigned a role USER.
###### All users have access to APIs:
`/register` </br>
`/login` </br>
###### Users with role Admin or User have access to APIs:
`GET: /cinema-halls` - get a list of cinema halls </br>
`GET: /movies` - get a list of movies </br>
`GET: /movie-sessions/available` - get a list of all movie sessions for a movie (by id) on a date </br>
`GET: /movie-sessions/{id}` - get movie sessions with id </br>
###### Users with role User have access to APIs:
`GET: /orders` - get a list of user's orders </br>
`GET: /shopping-carts/by-user` - get user's shopping cart </br>
`POST: /orders/complete` - add order </br>
`PUT: /shopping-carts/movie-sessions` - change movie session (by id) from shopping cart </br>
###### Users with role Admin have access to User Role APIs, also for the next APIs:
`POST: /movies` - add movie </br>
`POST: /movie-sessions` - add movie session </br>
`POST: /cinema-halls` - add cinema hall </br>
`GET: /users/by-email` - get user by email </br>
`PUT: /movie-sessions/{id}` - change movie session by id </br>
`DELETE: /movie-sessions/{id}}` - delete movie session by id </br>

# :abacus: Technologies used:
- Java 17
- Hibernate, Spring Data JPA
- Spring, Spring Boot, Spring Security
- REST, SOLID
- PostgresSQL
- Lombok, Mapstruct
- Swagger
- Docker

# :computer: If you want to run this project on your computer, you need:
1. Clone this project:
```bash
git clone https://github.com/NikitaKvl/cinema-control.git
```
2. Add [Lombok](https://projectlombok.org/setup/overview) plugin to your IDE
3. Run docker-compose file
```bash
docker-compose up
```

After all these steps you will be able to run this project locally.
