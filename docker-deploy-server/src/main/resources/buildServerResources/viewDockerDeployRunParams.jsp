<%@ taglib prefix="props" tagdir="/WEB-INF/tags/props" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="propertiesBean" scope="request" type="jetbrains.buildServer.controllers.BasePropertiesBean"/>
<jsp:useBean id="constants" class="jetbrains.buildServer.runner.dockerdeploy.server.DockerDeployConstantsBean" />

<%@include file="dockerDeployConstants.jsp" %>

<div class="parameter">
     Build container from: <strong><props:displayValue name="${constants.buildFrom}" /></strong>
</div>

<c:choose>
    <c:when test="${propertiesBean.properties[constants.buildFrom] == BF_DOCKERFILE.buildFromValue}">
        <div class="parameter">
             Dockerfile path: <strong><props:displayValue name="${constants.dockerfileLocation}" emptyValue="not specified"/></strong>
        </div>
    </c:when>
    <c:when test="${propertiesBean.properties[constants.buildFrom] == BF_DOCKER_COMPOSE.buildFromValue}">
        <div class="parameter">
             Docker Compose file path: <strong><props:displayValue name="${constants.dockerComposeLocation}" emptyValue="not specified"/></strong>
        </div>
    </c:when>
</c:choose>

<div class="parameter">
    Additional container parameters: <strong><props:displayValue name="${constants.containerArguments}" emptyValue="not specificed"/></strong>
</div>

<div class="parameter">
    Hostname: <strong><props:displayValue name="${constants.hostname}" emptyValue="not specified"/></strong>
</div>

<div class="parameter">
    Document Root: <strong><props:displayValue name="${constants.documentRoot}" emptyValue="not specified" /></strong>
</div>