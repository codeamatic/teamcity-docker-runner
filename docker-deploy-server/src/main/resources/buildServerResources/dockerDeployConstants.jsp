<%@ page import="jetbrains.buildServer.runner.dockerdeploy.common.DockerDeployBuildFromType" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="BF_APACHE_DEF" value="<%=DockerDeployBuildFromType.APACHE_DEFAULT%>"/>
<c:set var="BF_DOCKERFILE" value="<%=DockerDeployBuildFromType.DOCKERFILE%>"/>
<c:set var="BF_DOCKER_COMPOSE" value="<%=DockerDeployBuildFromType.DOCKER_COMPOSE%>"/>