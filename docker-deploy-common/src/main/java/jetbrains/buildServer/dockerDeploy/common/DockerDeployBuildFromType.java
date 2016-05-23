package jetbrains.buildServer.dockerDeploy.common;

import org.jetbrains.annotations.NotNull;

/**
 *  Defines allowed values for the Docker Deploy build from listing
 */
public enum DockerDeployBuildFromType {
  APACHE_DEFAULT("Apache Default", "Apache Default"),
  DOCKERFILE("Dockerfile", "Dockerfile"),
  DOCKER_COMPOSE("Docker Compose", "Docker Compose");

  private final String buildFromValue;
  private final String buildFromName;

  DockerDeployBuildFromType(final String buildFromValue, final String buildFromName) {
    this.buildFromValue = buildFromValue;
    this.buildFromName = buildFromName;
  }

  @NotNull
  public String getBuildFromName() {
    return buildFromName;
  }

  @NotNull
  public String getBuildFromValue() {
    return buildFromValue;
  }
}
