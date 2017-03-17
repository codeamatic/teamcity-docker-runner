package jetbrains.buildServer.dockerDeploy.agent;

import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import jetbrains.buildServer.RunBuildException;
import jetbrains.buildServer.agent.plugins.beans.PluginDescriptor;
import jetbrains.buildServer.agent.runner.BuildServiceAdapter;
import jetbrains.buildServer.agent.runner.ProgramCommandLine;
import jetbrains.buildServer.agent.runner.SimpleProgramCommandLine;
import jetbrains.buildServer.dockerDeploy.common.DockerDeployBuildFromType;
import jetbrains.buildServer.dockerDeploy.common.DockerDeployConstants;
import jetbrains.buildServer.util.OSType;
import jetbrains.buildServer.util.StringUtil;

public class DockerDeployBuildService extends BuildServiceAdapter {
  private static final Logger LOG = Logger.getLogger(DockerDeployBuildService.class.getName());

  private final PluginDescriptor pluginDescriptor;

  public DockerDeployBuildService(@NotNull final PluginDescriptor pluginDescriptor) {
    this.pluginDescriptor = pluginDescriptor;
  }

  @NotNull
  @Override
  public ProgramCommandLine makeProgramCommandLine() throws RunBuildException {

    List<String> params = new LinkedList<String>();
    String exeName = DockerDeployConstants.RUNNER_EXE_NAME;

    // Determine type of deploy this will be.
    Map<String, String> runnerParameters = getRunnerParameters();
    String dockerDeployType = runnerParameters.get(DockerDeployConstants.SETTINGS_BUILD_FROM);

    if(ConfigurationParamsUtil.isDockerfileBuildType(dockerDeployType)) {
      params.add("run");
    } else if(ConfigurationParamsUtil.isDockerComposeBuildType(dockerDeployType)) {
      // Change executable name to docker-compose
      exeName = DockerDeployConstants.RUNNER_COMPOSE_EXE_NAME;
      params.add("--version");
    } else {
      //
      params.add("--xyz");
    }

    return new SimpleProgramCommandLine(getRunnerContext(), exeName, params);
  }
}
