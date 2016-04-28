package jetbrains.buildServer.runner.dockerDeploy.server;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import jetbrains.buildServer.runner.dockerDeploy.common.DockerDeployConstants;
import jetbrains.buildServer.serverSide.InvalidProperty;
import jetbrains.buildServer.serverSide.PropertiesProcessor;
import jetbrains.buildServer.serverSide.RunType;
import jetbrains.buildServer.serverSide.RunTypeRegistry;
import jetbrains.buildServer.web.openapi.PluginDescriptor;

public class DockerDeployRunType extends RunType {
  private final PluginDescriptor myPluginDescriptor;

  public DockerDeployRunType(final RunTypeRegistry runTypeRegistry, final PluginDescriptor pluginDescriptor) {
    myPluginDescriptor = pluginDescriptor;
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
//
//        final String serverId = properties.get(Constants.SONAR_SERVER_ID);
//        if (serverId == null) {
//          invalidProperties.add(new InvalidProperty(Constants.SQS_CHOOSER, "Choose a SonarQube Server to send information to"));
//        }

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
}
