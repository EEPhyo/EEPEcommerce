<%@ tag language="java" pageEncoding="ISO-8859-1"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:if test="${not empty sessionScope.errorMessage}">
    <div class="alert alert-error">
        <button type="button" class="close" data-dismiss="alert"><fmt:message key="common.times"/></button>
        <fmt:message key="${sessionScope.errorMessage}" >
            <c:forEach items="${sessionScope.errorMessageArgs}" var="arg">
                <fmt:param value="${arg}" />
            </c:forEach>
        </fmt:message>
    </div>
    <c:set scope="session" var="errorMessage" />
    <c:set scope="session" var="errorMessageArgs" />
</c:if>

<c:if test="${not empty sessionScope.successMessage}">
    <div class="alert alert-success">
        <button type="button" class="close" data-dismiss="alert"><fmt:message key="common.times"/></button>
        <fmt:message key="${sessionScope.successMessage}" >
            <c:forEach items="${sessionScope.successMessageArgs}" var="arg">
                <fmt:param value="${arg}" />
            </c:forEach>
        </fmt:message>
    </div>
    <c:set scope="session" var="successMessage" />
    <c:set scope="session" var="successMessageArgs" />
</c:if>

<c:if test="${not empty sessionScope.infoMessage}">
    <div class="alert alert-info">
        <button type="button" class="close" data-dismiss="alert"><fmt:message key="common.times"/></button>
        <fmt:message key="${sessionScope.infoMessage}" >
            <c:forEach items="${sessionScope.infoMessageArgs}" var="arg">
                <fmt:param value="${arg}" />
            </c:forEach>
        </fmt:message>
    </div>
    <c:set scope="session" var="infoMessage" />
    <c:set scope="session" var="infoMessageArgs" />
</c:if>

<c:if test="${not empty sessionScope.alertMessage}">
    <div class="alert">
        <button type="button" class="close" data-dismiss="alert"><fmt:message key="common.times"/></button>
        <fmt:message key="${sessionScope.alertMessage}" >
            <c:forEach items="${sessionScope.alertMessageArgs}" var="arg">
                <fmt:param value="${arg}" />
            </c:forEach>
        </fmt:message>
    </div>
    <c:set scope="session" var="alertMessage" />
    <c:set scope="session" var="alertMessageArgs" />
</c:if>