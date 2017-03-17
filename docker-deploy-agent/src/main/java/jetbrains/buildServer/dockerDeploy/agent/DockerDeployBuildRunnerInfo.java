package jetbrains.buildServer.dockerDeploy.agent;

import org.jetbrains.annotations.NotNull;

import jetbrains.buildServer.agent.AgentBuildRunnerInfo;
import jetbrains.buildServer.agent.BuildAgentConfiguration;
import jetbrains.buildServer.dockerDeploy.common.DockerDeployConstants;

public class DockerDeployBuildRunnerInfo implements AgentBuildRunnerInfo {

  @NotNull
  public String getType() {
    return DockerDeployConstants.RUNNER_TYPE;
  }

  public boolean canRun(@NotNull BuildAgentConfiguration agentConfiguration) {
    return true;
  }
}
