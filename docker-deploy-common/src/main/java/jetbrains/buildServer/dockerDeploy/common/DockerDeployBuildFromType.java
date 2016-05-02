package jetbrains.buildServer.dockerDeploy.common;

import org.jetbrains.annotations.NotNull;

/**
 *  Defines allowed values for the Docker Deploy build from listing
 */
public enum DockerDeployBuildFromType {
  APACHE_DEFAULT("apache_default", "Apache Default"),
  DOCKERFILE("dockerfile", "Dockerfile"),
  DOCKER_COMPOSE("docker_compose", "Docker Compose");

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
