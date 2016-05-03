package jetbrains.buildServer.dockerDeploy.common;

import org.jetbrains.annotations.NotNull;

/**
 *  Defines allowed values for the Docker Deploy build from listing
 */
public enum DockerDeployBuildFromType {
  APACHE_DEFAULT("Apache Default", "Apache Default"),
  DOCKERFILE("Dockerfile", "Dockerfile"),
  DOCKER_COMPOSE("Docker Compose", "Docker Compose");

  private final String buildFromPrefix;
  private final String buildFromValue;

  DockerDeployBuildFromType(final String buildFromPrefix, final String buildFromValue) {
    this.buildFromPrefix = buildFromPrefix;
    this.buildFromValue = buildFromValue;
  }

  @NotNull
  public String getBuildFromPrefix() {
    return buildFromPrefix;
  }

  @NotNull
  public String getBuildFromValue() {
    return buildFromValue;
  }
}
