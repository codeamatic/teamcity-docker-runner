package jetbrains.buildServer.runner.dockerdeploy.server;

import org.jetbrains.annotations.NotNull;

import jetbrains.buildServer.runner.dockerdeploy.common.DockerDeployBuildFromType;
import jetbrains.buildServer.runner.dockerdeploy.common.DockerDeployConstants;

public class DockerDeployConstantsBean {

  @NotNull
  public String getBuildFrom() {
    return DockerDeployConstants.SETTINGS_BUILD_FROM;
  }

  @NotNull
  public DockerDeployBuildFromType[] getBuildFromTypes() {
    return DockerDeployBuildFromType.values();
  }

  @NotNull
  public String getDockerfileLocation() {
    return DockerDeployConstants.SETTINGS_DOCKERFILE_LOCATION;
  }

  @NotNull
  public String getDockerComposeLocation() {
    return DockerDeployConstants.SETTINGS_DOCKER_COMPOSE_LOCATION;
  }

  @NotNull
  public String getContainerArguments() {
    return DockerDeployConstants.SETTINGS_CONTAINER_ARGUMENTS;
  }

  @NotNull
  public String getDocumentRoot() {
    return DockerDeployConstants.SETTINGS_DOCUMENT_ROOT;
  }

  @NotNull
  public String getHostname() {
    return DockerDeployConstants.SETTINGS_HOSTNAME;
  }
}