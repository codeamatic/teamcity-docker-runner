Teamcity: Docker Deploy Runner
================

Plugin provides functionality for Docker deployment support in TeamCity. This is for using Docker solely for development and staging purposes, as opposed to a production workflow where Docker Images would be stored privately or within a Docker Hub.

### Installation

### Agent Requirements
* Docker
* Docker-Compose (optional)

### Developers

This plugin is architected based on the [Gradle TeamCity Plugin](https://github.com/rodm/gradle-teamcity-plugin).  It provides development and build management based on Gradle instead of Maven.  Visit

#### Build and Deploy Plugin/Runner

```
gradle clean build
```

#### Run Test Server

You can quickly create a TeamCity (v9.1.6) test server instance by running the following commands.

```
gradle installTeamcity91
gradle startTeamcity91Server
````

#### Run Test Agent

You can quickly create a TeamCity (v.9.1.6) test agent instance by running the following command.

```
gradle startTeamcity91Agent
```

#### Debugging

The server debugging port is `5005` and the agent debugging port is `5006`.  If necessary, they can be modified in the [plugin agent server](plugin-agent-server/build.gradle) build configuration.
