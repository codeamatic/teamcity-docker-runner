<%@ taglib prefix="props" tagdir="/WEB-INF/tags/props" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="bs" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="forms" tagdir="/WEB-INF/tags/forms" %>
<%@ taglib prefix="l" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:useBean id="propertiesBean" scope="request" type="jetbrains.buildServer.controllers.BasePropertiesBean"/>

<l:settingsGroup title="DockerBuild">
    <tr><th class="noBorder"><label for="sqsChooser">SonarQube Server: </label></th>
        <td>
            <props:multilineProperty name="additionalContainerParameters" linkTitle="Container Parameters" className="longField" cols="40" rows="3" expanded="true"/>
            <span class="smallNote">Additional parameters to be used during the startup of the Docker container.  This is not applicable when containers are created through a Docker Compose file.</span>
        </td>
    </tr>
</l:settingsGroup>