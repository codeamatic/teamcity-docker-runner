package jetbrains.buildServer.runner.dockerdeploy.agent;

import org.jetbrains.annotations.NotNull;

import jetbrains.buildServer.agent.AgentLifeCycleAdapter;
import jetbrains.buildServer.agent.BuildAgent;
import jetbrains.buildServer.runner.dockerdeploy.common.DockerDeployConstants;
import jetbrains.buildServer.util.EventDispatcher;

/**
 * Life cycle adapter used for making agent changes during the
 * agent life cycle.
 */
public class DockerLifeCycleAdapter extends AgentLifeCycleAdapter {
  private final Docker docker;

  public DockerLifeCycleAdapter(@NotNull final Docker docker, @NotNull EventDispatcher<AgentLifeCycleAdapter> dispatcher) {
    this.docker = docker;
    dispatcher.addListener(this);
  }

  @Override
  public void beforeAgentConfigurationLoaded(@NotNull BuildAgent agent) {
    agent.getConfiguration().addConfigurationParameter(DockerDeployConstants.PARAMETER_DOCKER, "v.1.0");

//    String dockerVersion = docker.getVersion("docker");
//    String dockerComposeVersion = docker.getVersion("docker-compose");
//
//    if (dockerVersion != null) {
//      agent.getConfiguration().addConfigurationParameter(DockerDeployConstants.PARAMETER_DOCKER, dockerVersion);
//    }
//
//    if(dockerComposeVersion != null) {
//      agent.getConfiguration().addConfigurationParameter(DockerDeployConstants.PARAMETER_DOCKER_COMPOSE, dockerComposeVersion);
//    }
  }
}