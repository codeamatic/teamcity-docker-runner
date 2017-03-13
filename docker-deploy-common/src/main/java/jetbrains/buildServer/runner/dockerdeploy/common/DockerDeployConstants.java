package jetbrains.buildServer.runner.dockerdeploy.common;

/**
 * Interface specifying a set of constants used across the plugin.
 */
public interface DockerDeployConstants {
  String RUNNER_TYPE = "docker-deploy";
  String RUNNER_EXE_NAME = "docker";
  String RUNNER_COMPOSE_EXE_NAME = "docker-compose";

  String RUNNER_DISPLAY_NAME = "Docker Deploy";
  String RUNNER_DESCRIPTION = "Runner for deploying builds as Docker containers.";

  String PARAMETER_DOCKER = "Docker";
  String PARAMETER_DOCKER_COMPOSE = "DockerCompose";

  String EDIT_RUN_PARAMS_PATH = "editDockerDeployRunParams.jsp";
  String VIEW_RUN_PARAMS_PATH = "viewDockerDeployRunParams.jsp";

  String SETTINGS_BUILD_FROM = "dockerdeploy.build_from";
  String SETTINGS_DOCKERFILE_LOCATION = "dockerdeploy.dockerfile_location";
  String SETTINGS_DOCKER_COMPOSE_LOCATION = "dockerdeploy.docker_compose_location";
  String SETTINGS_CONTAINER_ARGUMENTS = "dockerdeploy.container_arguments";
  String SETTINGS_DOCUMENT_ROOT = "dockerdeploy.document_root";
  String SETTINGS_HOSTNAME = "dockerdeploy.hostname";
}