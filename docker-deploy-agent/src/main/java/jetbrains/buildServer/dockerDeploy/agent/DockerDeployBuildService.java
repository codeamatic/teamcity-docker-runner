package jetbrains.buildServer.dockerDeploy.agent;

import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import jetbrains.buildServer.RunBuildException;
import jetbrains.buildServer.agent.plugins.beans.PluginDescriptor;
import jetbrains.buildServer.agent.runner.BuildServiceAdapter;
import jetbrains.buildServer.agent.runner.ProgramCommandLine;
import jetbrains.buildServer.agent.runner.SimpleProgramCommandLine;
import jetbrains.buildServer.dockerDeploy.common.DockerDeployConstants;

public class DockerDeployBuildService extends BuildServiceAdapter {
  private static final Logger LOG = Logger.getLogger(DockerDeployBuildService.class.getName());
  private static final String DOCKERFILE_ARG_NAME = "PUBDIR";

  private final PluginDescriptor pluginDescriptor;

  public DockerDeployBuildService(@NotNull final PluginDescriptor pluginDescriptor) {
    this.pluginDescriptor = pluginDescriptor;
  }

  @NotNull
  @Override
  public ProgramCommandLine makeProgramCommandLine() throws RunBuildException {

    String checkoutDir = getRunnerParameters().get("teamcity.build.checkoutDir");
    List<String> params = new LinkedList<String>();
    String exeName = DockerDeployConstants.RUNNER_EXE_NAME;

    // Determine type of deploy this will be.
    Map<String, String> runnerParameters = getRunnerParameters();
    String dockerDeployType = runnerParameters.get(DockerDeployConstants.SETTINGS_BUILD_FROM);

    generateDockerfile(checkoutDir);
    generateDockerIgnore(checkoutDir);

    return new SimpleProgramCommandLine(getRunnerContext(), exeName, params);
  }

  /**
   * Generates a default Dockerfile to be used with projects that don't
   * include their own Dockerfile.
   *
   * @param checkoutDirectory Directory where all resources have been checked out
   * @throws RunBuildException Thrown when unable to write Dockerfile
   */
  private void generateDockerfile(String checkoutDirectory) throws RunBuildException {
    Path filePath = Paths.get(checkoutDirectory + "\\Dockerfile");

    if(filePath.toFile().exists()) {
      getLogger().message("Overwriting existing Dockerfile with a generic default.");
    }

    try (BufferedWriter writer = Files.newBufferedWriter(filePath)) {
      String lineSeparator = System.getProperty("line.separator");
      writer.write("FROM alpine:3.4" + lineSeparator);
      writer.write("ARG " + DOCKERFILE_ARG_NAME + lineSeparator);
      writer.write("COPY [\"$" + DOCKERFILE_ARG_NAME + "\", \"/var/www/html\"]");
    } catch(IOException ex) {
      throw new RunBuildException("Unable to write Dockerfile: " + ex.getMessage());
    }
  }


  /**
   * Generates a default .dockerignore file.  Ignoring node_modules and bower_components.
   *
   * @param checkoutDirectory Directory where all resources have been checked out
   * @throws RunBuildException Thrown when unable to write .dockerignore
   */
  private void generateDockerIgnore(String checkoutDirectory) throws RunBuildException {
    Path filePath = Paths.get(checkoutDirectory + "\\.dockerignore");

    if(filePath.toFile().exists()) {
      getLogger().message("Overwriting existing .dockerignore file with a generic default.");
    }

    try (BufferedWriter writer = Files.newBufferedWriter(filePath)) {
      String lineSeparator = System.getProperty("line.separator");
      writer.write("node_modules" + lineSeparator);
      writer.write("bower_components");
    } catch(IOException ex) {
      throw new RunBuildException("Unable to write .dockerignore file: " + ex.getMessage());
    }
  }
}
