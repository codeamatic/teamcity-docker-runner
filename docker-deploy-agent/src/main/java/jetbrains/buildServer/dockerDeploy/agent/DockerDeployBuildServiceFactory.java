package jetbrains.buildServer.dockerDeploy.agent;

import org.jetbrains.annotations.NotNull;

import jetbrains.buildServer.agent.AgentBuildRunnerInfo;
import jetbrains.buildServer.agent.BuildAgentConfiguration;
import jetbrains.buildServer.agent.plugins.beans.PluginDescriptor;
import jetbrains.buildServer.agent.runner.CommandLineBuildService;
import jetbrains.buildServer.agent.runner.CommandLineBuildServiceFactory;
import jetbrains.buildServer.dockerDeploy.common.DockerDeployConstants;

public class DockerDeployBuildServiceFactory implements CommandLineBuildServiceFactory {

  private final PluginDescriptor pluginDescriptor;

  public DockerDeployBuildServiceFactory(@NotNull final PluginDescriptor pluginDescriptor) {
    this.pluginDescriptor = pluginDescriptor;
  }

  @NotNull
  public CommandLineBuildService createService() {
    return new DockerDeployBuildService(pluginDescriptor);
  }

  @NotNull
  public AgentBuildRunnerInfo getBuildRunnerInfo() {
    return new AgentBuildRunnerInfo() {

      @NotNull
      public String getType() {
        return DockerDeployConstants.RUNNER_TYPE;
      }

      public boolean canRun(@NotNull BuildAgentConfiguration agentConfiguration) {
        return true;
      }
    };
  }
}
