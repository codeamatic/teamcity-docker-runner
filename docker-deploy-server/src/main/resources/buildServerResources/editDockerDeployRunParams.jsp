<%@ taglib prefix="props" tagdir="/WEB-INF/tags/props" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="bs" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="forms" tagdir="/WEB-INF/tags/forms" %>
<%@ taglib prefix="l" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:useBean id="propertiesBean" scope="request" type="jetbrains.buildServer.controllers.BasePropertiesBean"/>
<jsp:useBean id="constants" class="jetbrains.buildServer.dockerDeploy.server.DockerDeployConstantsBean" />

<%@include file="dockerDeployConstants.jsp" %>

<l:settingsGroup title="Build Type">
    <tr>
        <th><label for="${constants.buildFrom}">Build Container From:</label></th>
        <td>
            <props:selectProperty name="${constants.buildFrom}" id="dockerdeploy_bf_opt" onchange="BS.DockerDeploy.updateBFType();" enableFilter="true" className="mediumField">
                <c:forEach var="item" items="${constants.buildFromTypes}">
                    <props:option value="${item.buildFromValue}"><c:out
                            value="${item.buildFromName}"/></props:option>
                </c:forEach>
            </props:selectProperty>
            <span class="error" id="error_${constants.buildFrom}"></span>
            <span class="smallNote"><strong>Apache Default:</strong> Project will be deployed to a container using a customized default Apache image.<br><strong>Dockerfile:</strong> Project will be deployed to a container using the custom Dockerfile associated with it.<br><strong>Docker Compose:</strong> Project will be deployed to container(s) using the Docker Compose file associated with it.</span>
        </td>
    </tr>

    <tr id="buildFromDockerfile">
        <th><label for="${constants.dockerfileLocation}">Dockerfile path:</label></th>
        <td>
            <props:textProperty name="${constants.dockerfileLocation}" className="longField"/>
            <bs:vcsTree fieldId="${constants.dockerfileLocation}"/>
            <span class="error" id="error_${constants.dockerfileLocation}"></span>
             <span class="smallNote">Optional, set only if 'Dockerfile' is not located at the root of the project.<br>Relative to project directory.</span>
        </td>
    </tr>

    <tr id="buildFromDockerCompose">
        <th><label for="${constants.dockerComposeLocation}">Docker Compose file path:</label></th>
        <td>
            <props:textProperty name="${constants.dockerComposeLocation}" className="longField"/>
            <bs:vcsTree fieldId="${constants.dockerComposeLocation}"/>
            <span class="error" id="error_${constants.dockerComposeLocation}"></span>
            <span class="smallNote">Optional, set only if 'docker-compose.yml' is not located at the root of the project.<br>Relative to project directory.</span>
        </td>
    </tr>
</l:settingsGroup>

<l:settingsGroup title="Container Settings">
    <tr>
        <th><label for="${constants.containerArguments}">Docker parameters: </label></th>
        <td>
            <props:multilineProperty name="${constants.containerArguments}"
                                     linkTitle="Additional container parameters" className="longField"
                                     cols="40" rows="3" expanded="true"/>
            <span class="smallNote">Additional parameters to be used during the startup of the Docker container.  This is not applicable when<br/>containers are created through a Docker Compose file.</span>
        </td>
    </tr>

    <tr>
        <th><label for="${constants.hostname}">Hostname:</label></th>
        <td>
            <props:textProperty name="${constants.hostname}" className="longField"/>
            <span class="error" id="error_${constants.hostname}"></span>
            <span class="smallNote">Example:  example.dev.rfisite.com</span>
        </td>
    </tr>

    <tr>
        <th><label for="${constants.documentRoot}">Document root:</label></th>
        <td>
            <props:textProperty name="${constants.documentRoot}" className="longField"/>
            <span class="error" id="error_${constants.documentRoot}"></span>
            <span class="smallNote">Relative folder where all public facing files will be accessed by the server.  Example: /public, /dist</span>
        </td>
    </tr>
</l:settingsGroup>

<script>
    BS.DockerDeploy = {
        /**
         *  Hide and display input fields related to the Build From type dropdown.
         */
        updateBFType : function() {
            var val = $('dockerdeploy_bf_opt').value;

            if(val == '${BF_DOCKER_COMPOSE.buildFromValue}') {
                BS.Util.show($('buildFromDockerCompose'));
                BS.Util.hide($('buildFromDockerfile'));
                console.log($('${constants.dockerfileLocation}'));
                $('${constants.dockerComposeLocation}').focus();
            } else if(val == '${BF_DOCKERFILE.buildFromValue}') {
                BS.Util.show($('buildFromDockerfile'));
                BS.Util.hide($('buildFromDockerCompose'));
                console.log($('${constants.dockerfileLocation}'));
                $('${constants.dockerfileLocation}').focus();
            } else {
                BS.Util.hide($('buildFromDockerfile'));
                BS.Util.hide($('buildFromDockerCompose'));
            }

            BS.VisibilityHandlers.updateVisibility('mainContent');
        }
    };

    BS.DockerDeploy.updateBFType();
</script>