package jetbrains.buildServer.dockerDeploy.agent;

import org.jetbrains.annotations.NotNull;

import jetbrains.buildServer.RunBuildException;
import jetbrains.buildServer.agent.plugins.beans.PluginDescriptor;
import jetbrains.buildServer.agent.runner.BuildServiceAdapter;
import jetbrains.buildServer.agent.runner.CannotBuildCommandLineException;
import jetbrains.buildServer.agent.runner.JavaCommandLineBuilder;
import jetbrains.buildServer.agent.runner.ProgramCommandLine;

public class DockerDeployBuildService extends BuildServiceAdapter {

  @NotNull
  private final PluginDescriptor pluginDescriptor;

  public DockerDeployBuildService(@NotNull final PluginDescriptor pluginDescriptor) {
    this.pluginDescriptor = pluginDescriptor;
  }

  @NotNull
  @Override
  public ProgramCommandLine makeProgramCommandLine() throws RunBuildException {
    JavaCommandLineBuilder jclBuilder = new JavaCommandLineBuilder();
    return buildCommandLine(jclBuilder);
  }

  @NotNull
  public ProgramCommandLine buildCommandLine(@NotNull final JavaCommandLineBuilder builder) throws RunBuildException {
    try {
      return builder.build();
    } catch(CannotBuildCommandLineException ex) {
      throw new RunBuildException(ex.getMessage());
    }
  }
}
