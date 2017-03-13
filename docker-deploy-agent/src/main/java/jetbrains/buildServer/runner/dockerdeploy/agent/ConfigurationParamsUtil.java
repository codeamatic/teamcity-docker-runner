package jetbrains.buildServer.runner.dockerdeploy.agent;

import jetbrains.buildServer.runner.dockerdeploy.common.DockerDeployBuildFromType;

public class ConfigurationParamsUtil {

  static boolean isDefaultBuildType(final String deployType) {
    return deployType.equals(DockerDeployBuildFromType.APACHE_DEFAULT.getBuildFromValue());
  }

  public static boolean isDockerfileBuildType(final String deployType) {
    return deployType.equals(DockerDeployBuildFromType.DOCKERFILE.getBuildFromValue());
  }

  public static boolean isDockerComposeBuildType(final String deployType) {
    return deployType.equals(DockerDeployBuildFromType.DOCKER_COMPOSE.getBuildFromValue());
  }
}