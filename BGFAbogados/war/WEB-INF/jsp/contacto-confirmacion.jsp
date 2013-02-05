<%@ page isELIgnored ="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h2><fmt:message key="contactus.form.title.delivery-confirmation"/></h2>
<form method="post" action="${flowExecutionUrl}">
	<c:if test="${deliveryStatus.sent}">
		<p><fmt:message key="contactus.form.text.send-success"/></p>
		<input type="submit" name="_eventId_done" value="<fmt:message key="common.form.accept"/>" />
	</c:if>
	<c:if test="${!deliveryStatus.sent}">
		<p><fmt:message key="contactus.form.text.send-fail"/></p>
		<p><fmt:message key="contactus.form.text.try-again"/></p>
		<input type="submit" name="_eventId_back" value="<fmt:message key="common.form.retry"/>" />
	</c:if>
</form>
