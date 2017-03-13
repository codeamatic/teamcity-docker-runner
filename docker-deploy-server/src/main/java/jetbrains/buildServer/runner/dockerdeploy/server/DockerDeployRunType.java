package jetbrains.buildServer.runner.dockerdeploy.server;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import jetbrains.buildServer.runner.dockerdeploy.common.DockerDeployConstants;
import jetbrains.buildServer.requirements.Requirement;
import jetbrains.buildServer.requirements.RequirementType;
import jetbrains.buildServer.serverSide.InvalidProperty;
import jetbrains.buildServer.serverSide.PropertiesProcessor;
import jetbrains.buildServer.serverSide.RunType;
import jetbrains.buildServer.serverSide.RunTypeRegistry;

public class DockerDeployRunType extends RunType {

  public DockerDeployRunType(@NotNull final RunTypeRegistry runTypeRegistry) {
    runTypeRegistry.registerRunType(this);
  }

  @Override
  @NotNull
  public String getType() {
    return DockerDeployConstants.RUNNER_TYPE;
  }

  @NotNull
  @Override
  public String getDisplayName() {
    return DockerDeployConstants.RUNNER_DISPLAY_NAME;
  }

  @NotNull
  @Override
  public String getDescription() {
    return DockerDeployConstants.RUNNER_DESCRIPTION;
  }

  @Nullable
  @Override
  public PropertiesProcessor getRunnerPropertiesProcessor() {
    return new PropertiesProcessor() {
      public Collection<InvalidProperty> process(Map<String, String> properties) {
        List<InvalidProperty> invalidProperties = new LinkedList<InvalidProperty>();
        // TODO: Validate any properties for the agent
        return invalidProperties;
      }
    };
  }

  @Nullable
  @Override
  public String getEditRunnerParamsJspFilePath() {
    return DockerDeployConstants.EDIT_RUN_PARAMS_PATH;
  }

  @Nullable
  @Override
  public String getViewRunnerParamsJspFilePath() {
    return DockerDeployConstants.VIEW_RUN_PARAMS_PATH;
  }

  @Nullable
  @Override
  public Map<String, String> getDefaultRunnerProperties() {
    return null;
  }

  @NotNull
  @Override
  public List<Requirement> getRunnerSpecificRequirements(@NotNull Map<String, String> runParameters) {
    final List<Requirement> requirements = new ArrayList<Requirement>(super.getRunnerSpecificRequirements(runParameters));
    requirements.add(new Requirement(DockerDeployConstants.PARAMETER_DOCKER, null, RequirementType.EXISTS));
    // TODO: Docker-compose should not be a requirement.  But lack of  Docker-compose should reflect in deploy type dropdown
    //requirements.add(new Requirement(DockerDeployConstants.PARAMETER_DOCKER_COMPOSE, null, RequirementType.EXISTS));

    return requirements;
  }
}