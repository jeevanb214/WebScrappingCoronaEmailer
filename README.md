# WebScrappingCoronaEmailer
it scrap the data from the "https://www.google.com/search?q=corona+cases+"+to.getCountry().toLowerCase();  and send the data to the email that had a subscription(we used the scheduler)

Tech Stack

Spring Boot
Java Mail API (For sending email)
HtmlUnit (headless web browser for java)
Jsoup (for scraping)


Create 'src/main/resources/application.properties' file

Enter the following lines.

spring.datasource.url=jdbc:.......................
spring.datasource.username=USERNAME
spring.datasource.password=PASSWORD
spring.jpa.generate-ddl=true
com.jeevan.emailFrom=EMAILID
com.jeevan.password=PASSWORD
