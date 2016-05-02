package jetbrains.buildServer.dockerDeploy.common;

/**
 * Interface specifying a set of constants used across the plugin.
 */
public interface DockerDeployConstants {
  String RUNNER_TYPE = "docker-deploy";

  String RUNNER_DISPLAY_NAME = "Docker Deploy";
  String RUNNER_DESCRIPTION = "Runner for deploying builds as Docker containers.";

  String EDIT_RUN_PARAMS_PATH = "editDockerDeployRunParams.jsp";
  String VIEW_RUN_PARAMS_PATH = "viewDockerDeployRunParams.jsp";

  String SETTINGS_BUILD_FROM = "dockerdeployer.build_from";
  String SETTINGS_DOCKERFILE_LOCATION = "dockerdeployer.dockerfile_location";
  String SETTINGS_DOCKER_COMPOSE_LOCATION = "dockerdeployer.docker_compose_location";
  String SETTINGS_CONTAINER_ARGUMENTS = "dockerdeployer.container_arguments";
  String SETTINGS_DOCUMENT_ROOT = "dockerdeployer.document_root";
  String SETTINGS_HOSTNAME = "dockerdeployer.hostname";
}
