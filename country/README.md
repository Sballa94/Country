## Instruction how to build and run project:
 This project is configured with a target and source compiler version 1.8 so is preferable to use a java SDK 1.8
##Add this project as Maven project
1. right click on Country main pom.xml inside the sw directory and then click on Add as Maven Project command in the opening popup.
2.right click on Country main pom.xml i and then click on Maven-->Generate Sources and Update Folder command.
3.right click on Country main pom.xml and then click on Maven-->Reload Project.
4.build the project: Build-->Rebuild Project.
If the compilation at point 4 fails with errors, try to close the project (File-->Close Project), reopen it and repeat the steps starting from the point 2.

##The steps to run app:
 1.Use “mvn clean install” command in terminal
 2.java -jar “java -jar <your-project-folder>/ country/country/target/country-0.0.1-SNAPSHOT.jar” 