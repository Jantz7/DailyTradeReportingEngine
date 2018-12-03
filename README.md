# DailyTradeReportingEngine
A Daily Reporting Engine which takes in an Instruction to execute in the International Market

## Quick Start

To build the application run the following command:

```
mvn clean install
```

To run the application run the following command: 

```
mvn spring-boot:run
```

You should see the output in the console.

### Additional Information

This is a Spring Boot and Maven application which takes in an Instruction which is sent to the application from a client.
The application validates the Instructions' settlement day to make sure it is a valid working day, depending on the currency of the trade.
The validated Instructions are then used to calculate the daily income, daily outcome, income rankings and outcome rankings.
These values are then outputted into the console.

#### Potential

The application is currently implemented with a demo in mind meaning the data outputted lives within the codebase.
Having a database was not in the current specification however a databse such as MongoDB could be used to store the Instructions before they are
used by the application which would produce a more production ready system.

