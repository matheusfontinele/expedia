# Expedia

## Intro

Java version: Java 15
Chrome version: 95.0.4638.54

The project has been created with the following dependencies:
- UI Tests
    - Selenium WebDrive
    - TestNG
    - AssertJ
- API Tests
    - Rest Assured
    - Cucumber + Parallelism
    - PicoContainer (Dependency Injection)
    - AssertJ
    - TestNG

## Project Repository
https://github.com/matheusfontinele/expedia

## Installation

[Java JDK 15](https://www.oracle.com/java/technologies/javase/jdk15-archive-downloads.html) after the installation, you will need to create/edit the following environment variables:
- JAVA_HOME: JDK installed path
  
  Example: C://(USER)/Program Files/Java/(JDK)
- PATH: Edit variable and add the new Java path value
  Example: %JAVA_HOME%\bin

To verify if the java is installed or not, just open CMD and execute the instruction below:
```sh
java -version
```
Example of message return when the java is installed:
```sh
java version "15.0.2" 2021-01-19
Java(TM) SE Runtime Environment (build 15.0.2+7-27)
Java HotSpot(TM) 64-Bit Server VM (build 15.0.2+7-27, mixed mode, sharing)
```

[Maven](https://maven.apache.org/download.cgi) after the unzip, it will be necessary to add the maven PATH into environment variable PATH.

Example: C:\Program Files\apache-maven-3.6.3\bin

Open CMD and type:
```sh
mvn --v
```
If the version is printed successfully, indicates that the environment is correct.
Example:
```sh
Apache Maven 3.6.3 (cecedd343002696d0abb50b32b541b8a6ba2883f)
Maven home: C:\Program Files\apache-maven-3.6.3\bin\..
Java version: 1.8.0_211, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk1.8.0_211\jre
Default locale: pt_BR, platform encoding: Cp1252
OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
```
## Execution
In the root project, open the terminal or command prompt and type:
```sh
mvn clean install
```
The maven will install all dependencies and execute a test suite that contains the UI and API tests.
```sh
[INFO] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 95.179 s - in TestSuite
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO]
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ expedia ---
[INFO] Building jar: C:\Users\matheus.fontinele\Desktop\Projects\workspaces\expedia\target\expedia-1.0.jar
[INFO]
[INFO] --- maven-install-plugin:2.4:install (default-install) @ expedia ---
[INFO] Installing C:\Users\matheus.fontinele\Desktop\Projects\workspaces\expedia\target\expedia-1.0.jar to C:\Users\matheus.fontinele\.m2\repository\loans\anchor\
expedia\1.0\expedia-1.0.jar
[INFO] Installing C:\Users\matheus.fontinele\Desktop\Projects\workspaces\expedia\pom.xml to C:\Users\matheus.fontinele\.m2\repository\loans\anchor\expedia\1.0\exp
edia-1.0.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  01:53 min
[INFO] Finished at: 2021-11-03T20:41:06-03:00
[INFO] ------------------------------------------------------------------------
```

