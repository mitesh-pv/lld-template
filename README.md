# Java Applications template

This is a template application to manage multiple simple java applications in one workspace.

### Adding and running new java application
* To Add a new java application, create a parent package inside `com.lld.app` package. <br>
Example, look for existing RegisterCallbackApplication.

* Create main class with Application as suffix example: `RegisterCallbackApplication`
* Create `mainApplication` method inside this Application class.
* Use this function as Driver class to write client code, object initialisation etc.

* To run this project, use the below maven build command:
```shell
compile exec:java -Dexec.mainClass=com.lld.app.DesignApplication -Dexec.args=<parent-package-name>.<application-class-name>
```

example:
```shell
compile exec:java -Dexec.mainClass=com.lld.app.DesignApplication -Dexec.args=registerCallback.RegisterCallbackApplication
```

### Following command is used to create this template application
To generate new template use the following command: 
```shell
mvn archetype:generate -DgroupId=com.lld.app -DartifactId=lld-template -DarchetypeArtifactId=maven-archetype-quickstart  -DinteractiveMode=false
```
### Implementations

1. Callback functions design pattern.
```shell
mvn compile exec:java -Dexec.mainClass=com.lld.DesignApplication -Dexec.args=registercallback.RegisterCallbackApplication
```