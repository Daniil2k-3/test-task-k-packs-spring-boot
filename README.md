# Test task "K-PAC in K-PAC sets"
Note: unfortunately, I couldn't implement frontend component in this project, so I decided to shift accent to backend and implement it using the best technologies I could find. Sorry for inconvenience.
## Starting application
- clone project to your IDE
- configure application.properties file with your username and password
- you can use http://localhost:8080/inject to inject test data

## Available endpoints 
- POST http://localhost:8080/kpacks - create k-pack 
- POST http://localhost:8080/sets - create set of k-packs
- DELETE http://localhost:8080/kpacks/id  - delete k-pack by id
- DELETE http://localhost:8080/sets/id  - delete set by id
- GET http://localhost:8080/kpakcs  - get all k-packs(you can also specify amount of items displayed and sorting criteria)
- GET http://localhost:8080/kpakcs/by-title - get k-pack by title
- GET http://localhost:8080/kpakcs/by-date - get k-pack by date
- GET http://localhost:8080/sets - get all k-pack sets(you can also specify amount of items displayed)
- GET http://localhost:8080/set/id - get list of all k-packs from certain set
- GET http://localhost:8080/sets/by-title - get set of k-packs by title