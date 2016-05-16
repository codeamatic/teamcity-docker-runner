package jetbrains.buildServer.dockerDeploy.agent;

import org.apache.log4j.Logger;

public class Docker {
  private static final Logger LOG = Logger.getLogger(Docker.class);

  /**
   * Determines whether or not Docker is available on the current system or not.
   * Somewhat based on the DockerVM class programmed by Jonnyzzz for Teamcity.virtual.
   *
   * @return true if Docker is available, false otherwise
   */
  public String getDockerVersion() {

    return "1.13.0";
  }

}
