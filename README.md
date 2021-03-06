# Embedded Tomcat Guide
___Author: Malte B. P.___  
_Last updated 12/06-2020_

This is a very small example / guide on how to use an _embedded_ Tomcat server instead of a standalone server Tomcat server.

_Things to note_:
 - This guide assumes you're using Maven
 - This guide assumes you're using IntelliJ
 - This guide doesn't explain about JAX-RS/Jersey
 - The project is a working example of an embedded Tomcat, and should be clonable and immediately runnable
 - For a guide to standalone Tomcat server see [this link](https://docs.google.com/document/d/1x1pZkAR-qe3vQRmsBgSFtvOXE9I36gZKSZquLgG0los/edit#)


## TLDR

1. Copy the properties, dependencies and build sections from the `pom.xml` in this project to the `pom.xml` in your project
2. Copy the `Main` class from this project to your project
3. Place your website content (html, css, js etc.) in `src/main/webapp` folder, or adjust `WEBAPP_PATH` in the `Main` class to the path of your website
4. Done!

## Guide

__1. Create a new Maven project or use an existing one.__

__2. Setup the pom.xml:__ You should copy the following from the `pom.xml` file in this project to your project:

- The `<properties> ... </properties>` section

    > This supplies the pom with the `tomcat.version` property, which you may change in order to change the server version. It also tells Maven which Java version it should use for compilation.

- Tthe entire `<dependencies>...<dependencies>` section
    
    > Only the dependencies `tomcat-embed-core` and `tomcat-embed-jasper` from `org.apache.tomcat.embed` are necessary to actually run the embedded Tomcat server. The remaining dependencies are for Jersey.

- The entire `<build> ... </build>` section

    > This is not important for running the project from IntelliJ, but ensures that your become .jar-file becomes _executable_ (this is also how your create an executable .jar file from any Maven project)
    
- Remember to reimport Maven!
    
__3. Add the `Main.java` from this project to your project__

 > This class contains the main method, you'll run to start Tomcat server, and deploys your content (i.e. website and Jersey application). 
 > If you place the class within a package, you should add the package name to the `<mainClass>Main</mainClass>` element in the build section of you `pom.xml`. I.e. `Main.java` has the path `src/main/java/MyPackage/Main.java` you would write `<mainClass>MyPackage.Main</mainClass>` .


__4. Add content to your project:__

- Place your website content (.html, .js etc.) within the folder `src/main/java/webapp`.
 
    > If you use another folder, you should change the `WEBAPP_PATH` within the `Main` class to the same path (relative from project root)  

- Place your class `Application` class and resource/service/endpoint classes as you usually do (somewhere in `src/main/java`)

__5. Done!__ Running the project like a "regular" IntelliJ project will now start the Tomcat server and deploy your content to the server!

 > The project can be compiled to a .jar and run like any other Maven project. To do this open `View -> Tool Windows -> Maven Projects`. In the window that pops up, go into the `Lifecycles`"folder", select from `clean` to `package`(inclusive), and press the run icon (green arrow). This will build your .jar-file which anyone who has the correct version of Java installed should be able to run
 
 
