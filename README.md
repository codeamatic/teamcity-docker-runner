Teamcity: Docker Deploy Runner
================

The purpose of this plugin is to provide functionality for Docker deployment support in TeamCity. This is for using Docker solely for development and staging purposes, as opposed to a production workflow where Docker Images would be stored privately or within a Docker Hub.

This plugin assumes that any Dockerfiles associated with a project will be used to deploy a __local__ container.

This plugin is architected based on the [Gradle TeamCity Plugin](https://github.com/rodm/gradle-teamcity-plugin).  It provides an environment based on  Gradle instead of Maven.

## Requirements
* Docker
* Docker-Compose

## Build and Deploy Plugin/Runner

```
gradlew clean build
```

## Run Test Server

You can quickly create a TeamCity (v9.1.6) test server instance by running the following commands.

```
gradle docker-deploy-server:installTeamCity91

gradle docker-deploy-server:startTeamCity91Server
````

## Run Test Agent

You can quickly create a TeamCity (v.9.1.6) test agent instance by running the following command.

```
gradle docker-deploy-server:startTeamcity91Agent
```
