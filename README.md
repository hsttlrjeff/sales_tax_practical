Liferay Practical Readme

The entire project was developed utilizing Maven inside STS.  The project does not need an IDE to execute the unit tests or the application itself.  To execute the application please make sure you have Maven installed and configured, then all you will need to do is execute the following:

mvn clean
mvn install
mvn –q exec:java

At this point all unit tests should have been run successfully and the application should provide the expected output.

You can also import the project into an IDE my utilizing a maven import of exiting code, at that point it can also be executed.

There design of the application follows a standard layout and organization.
