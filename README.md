# AgileManager
Nov 12, 2017:

This project is the back-end component of an Agile Manager Restful web appliation. It uses the Spring + springboot and hibernate. It is currently configured to use MySql for persistence. (refer to 'resources/application.properties' for DB info). 

Note that you need to create a database and after setting up the database name, user name and password, update the 'application.properites' accordingly. If the property 'spring.jpa.hibernate.ddl-auto' in 'application.properties' is set to 'create', the database tables are all created when the application is run for the first time. Make sure to change the value of property 'spring.jpa.hibernate.ddl-auto' to 'update' from that point on to run the application.

I have pushed the whole code base and the easiest way to call APIs is to import the project in Intellij IDEA (ultimate version that supports Spring and hibernate out of the box) and run the application. (It can be used in other environments of course by including required libraries in your build process). Either maven or gradle can be used for build.

As a Spring framework application,  it contains separate packages of 'model', 'controller', 'services', and 'repository'. 

This project is 'work in progress' and what is pushed in so far is only the start. Currently provides the basic CRUD APIs for all controllers. There will be more APIs as I progress. The intention is to utilize Java 8, and as I progress, there will be more of Java 8 features in the code.
There will be unit testing (for at least all the controller classes). 
Logging and using AspectJ is also something that I will add as I find it is needed for some actions.
Also handling API messages that are currently plain text in the code. And so many other changes of course.

There will be an API description document to be pushed as well.

At some point I am hoping to build a front end and real application out of this :)

I will update this readme document as I progress.

Nov 15, 2017:

Pushed new changes with some refactoring for model objects and also added two simple design documents in the designDocs directory for model objects.
