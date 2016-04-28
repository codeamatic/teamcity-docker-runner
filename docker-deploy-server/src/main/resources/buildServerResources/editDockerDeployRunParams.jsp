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
            <c:choose>
                <c:when test="${not empty servers}">
                    <props:selectProperty name="sonarServer" enableFilter="true" className="sqsChooser mediumField">
                        <c:if test="${showUnknownServer}">
                            <props:option value="" selected="true">Unknown server</props:option>
                        </c:if>
                        <c:if test="${showSelectServer}">
                            <props:option value="" selected="true">Choose server</props:option>
                        </c:if>
                        <c:forEach items="${servers}" var="server">
                            <props:option value="${server.id}"><c:out value="${server.name}"/>: <c:out value="${server.url}"/></props:option>
                        </c:forEach>
                    </props:selectProperty>
                </c:when>
                <c:otherwise>
                    <span class="smallNote">No SonarQube Server registered yet for this project</span>
                </c:otherwise>
            </c:choose>
            <span id="error_sonarServer" class="error"></span>
        </td>
    </tr>
</l:settingsGroup>