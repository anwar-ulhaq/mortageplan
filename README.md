# Mortgageplan (<!--strong--> **Mortgage Calculator**)

**Mortgageplan** is a web-application which calculates fixed monthly payment for the given amount of loan, fixed annual interest percentage and pay back period in years.  
This app has been built with Spring framework using Java 11 and mongoDB. Gradle is used as a build tool.
## Prerequisite

In order to run this application, following tools must be installed.


1. Installation guide. [Java 11](https://docs.oracle.com/en/java/javase/11/install/overview-jdk-installation.html#GUID-8677A77F-231A-40F7-98B9-1FD0B48C346A)
1. Installation guide. [MongoDB Enterprise](https://docs.mongodb.com/manual/administration/install-enterprise/)

 **Note:** Gradle distribution is provided along with the project, hence no need to install it. 

## How to run project?

###1. Clone

```
git clone https://github.com/anwar-ulhaq/mortageplan.git
```
```
cd mortageplan
```

### 2. Build
On Windows system
```
gradlew build
```

On MacOS/Unix system
```
./gradlew build
```

###3. Run
#####3.1 Start MongoDB instance.
Open a Terminal window and run following command.<br><br>
On Windows system
```
mongod.exe --dbpath="c:\data\db"
```
On MacOS/Unix system

```
sudo mongod --dbpath /usr/local/var/mongodb
```

#####3.2 Run Application.
In the project directory run following command.

On Windows system
```
gradlew bootRun
```

On MacOS/Unix system
```
./gradlew bootRun
```

Now application is running, open a web browser and browse to http://localhost:8080/

###4. Running Tests

To run test,  
On Windows system
```
gradlew test
```

On MacOS/Unix system
```
./gradlew test
```