= an Inventory management System (IMS) implementation with Spring Boot

This project shows the usage of the Spring Boot framework for the implementation of an coding assignment

== The assignment
Merchants need to keep track of the inventory of their store or warehouse. Keeping items in
stock has costs associated with it and they need to know when to order new items, or when to
start a promotion on overstocked items.
Create a small application what exposes a web service the allows merchants to keep track of
their inventory and helps them make decisions on purchases and promotions. 

=== Implementation notes
Create a java application that:
** Exposes a RESTful API
** Has basic security features in place
** Connects to a local database
The description above has no strict functional requirements. Focus on writing code that shows
off your abilities to write well structured, well documented, secure and testable code. 

== The implementation
I implemented the assignment with a (for me) new framework: Spring Boot
Spring Boot enables us to quickly build a simple or complicated Web- or Enterprise application

=== Caveats
** Somehow I couldn't get Lombok to work. The lombok enabled entity's (pojo's) didn't expose their attributes in the json translation
** Like the assignments states: "no strict functional requirements" the dataset is limited in size and therefor I didn't use Paging
** Unfortunately I couldn't fix the security in the limited timeframe. The web-part (home.html) is challenged by the server-response, to use Basic-Authentication, while the server expects Digest Authentication
** In the file: resources/statis/js/main.js you will see that two of the jquery error ajax-error event handlers contain the location.reload() call. This is because, for an unknown reason, the error event is triggered while the call seems to be successful 

== Components
** JPA
** H2
** Web
** RestRepositories
** Res Docs
** Thymeleaf (not really needed)

== Installing and running the app
** git clone https://github.com/diederv/inventory-management-system.git
** cd inventory-management-system/
** mvn spring-boot:run
** open in a browser: http://localhost:8081/home.html
 