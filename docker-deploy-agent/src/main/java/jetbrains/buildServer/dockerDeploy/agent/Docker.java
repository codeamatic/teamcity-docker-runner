package jetbrains.buildServer.dockerDeploy.agent;

import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.openapi.util.SystemInfo;
import com.intellij.openapi.util.text.StringUtil;

import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import jetbrains.buildServer.ExecResult;
import jetbrains.buildServer.SimpleCommandLineProcessRunner;

public class Docker {
  private static final Logger LOG = Logger.getLogger(Docker.class.getName());

  /**
   * Determines whether or not Docker or Docker-Compose is available on the current system or not.
   * Heavily based on the DockerVM class programmed by Jonnyzzz for Teamcity.virtual.
   *
   * @return version of Docker installed, null if Docker doesn't exist
   */
  @Nullable
  public String getVersion(@NotNull String appName) {
    final String output = executeCommandWithShell(appName + " --version");
    if (output == null) {
      return null;
    }

    String ver = output.toLowerCase().trim();
    ver = ver.replaceAll("\\s*" + appName + "\\s+version\\s+", "");
    ver = ver.replaceAll(",?\\s+build\\s+", "-");

    if (StringUtil.isEmptyOrSpaces(ver)) {
      LOG.warn("Failed to parse " + appName + " version: " + output);
      return null;
    }

    return ver;
  }

  /**
   * Helper method for executing shell commands directly within the Agent.
   * Heavily based on the DockerVM class programmed by Jonnyzzz for Teamcity.virtual.
   *
   * @param command Command line command to be run on the agent
   * @return String result of the command being run.
   */
  @Nullable
  private String executeCommandWithShell(@NotNull final String... command) {
    GeneralCommandLine cmd = new GeneralCommandLine();
    if (SystemInfo.isWindows) {
      cmd.setExePath("cmd");
      cmd.addParameters("/c");
    } else {
      cmd.setExePath("/bin/sh");
      cmd.addParameters("-c");
    }
    cmd.addParameters(command);

    LOG.info("Running: " + cmd.getCommandLineString());

    final ExecResult result = SimpleCommandLineProcessRunner.runCommand(cmd, new byte[0]);

    //noinspection ThrowableResultOfMethodCallIgnored
    if (result.getException() != null || result.getExitCode() != 0) {
      LOG.info(("Failed running command [" + cmd.getCommandLineString() + "]. Exit code: " + result.getExitCode() + "\n " + result.getStdout() + "\n" + result.getStderr()).trim());
      return null;
    }

    return result.getStdout();
  }
}
