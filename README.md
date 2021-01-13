# VerivoxCucumberAutomation

# CucumberAutomationFramework
CucumberAutomationFramework With Logs Configured

Currently automation code can be run on Chrome Browser version 87 and Firefox browser version 78. Machine Should have Java 1.8 which is perfect fit for this project to execute.

Run Instrcutions:

To Run From Command Promt as maven test:

To execute the project, download project.
Open Command Prompt go to the Project Location Downloaded.
Go Inide the file CucumberAutomationFramework so that Pom.xml should be visible when dir is entered pom.xml should be visible.
Then provide the command mvn clean.
Execute mvn compile.
Execute mvn test.
Wait till execution gets completed.
Check TestNG Results once execution is completed to see execution reports.
TestNG reports, Fail report, Pass report and emailable reports can be found in CucumberAutomationFramework->/test-output/
Logs Can be seen CucumberAutomationFramework->/Logs/
To Run as TestNG

To execute the project, download project.
Go to Pom.xml of the project click on save.
Wait for all dependencies to be downloaded.
Then execute the /CucumberAutomationFramework/src/test/java/cucumberOptions/TestRunner.java file as Run as --> TestNG Test.
Wait till execution gets completed.
Check TestNG Results once execution is completed to see execution reports.
TestNG reports, Fail report, Pass report and emailable reports can be found in CucumberAutomationFramework->/test-output/
Logs Can be seen CucumberAutomationFramework->/Logs/
To Run as Junit

To execute the project, download project.
Go to Pom.xml of the project click on save.
Wait for all dependencies to be downloaded.
Uncomment line number 10 //@RunWith(Cucumber.class)
Then execute the /CucumberAutomationFramework/src/test/java/cucumberOptions/TestRunner.java file as Run as --> JUnit Test.
Wait till execution gets completed.
Check TestNG Results once execution is completed to see execution reports.
TestNG reports, Fail report, Pass report and emailable reports can be found in WorkSpace->/test-output/
Logs Can be seen CucumberAutomationFramework->/Logs/
