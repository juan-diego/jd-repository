<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="contactus">
	<h2><fmt:message key="contactus.form.titre.contactus"/></h2>
	<div>
		<ul>
			<li><fmt:message key="contactus.form.field.phone"/>: 985 20 93 81</li>
			<li><fmt:message key="contactus.form.field.fax"/>: 985 20 93 82</li>
			<li><fmt:message key="contactus.form.field.email"/>: informacion@bgfabogados.com</li>
		</ul>
	</div>
	<p><fmt:message key="contaxtus.form.text.enter-your-comments"/>:</p>
	<form:form method="post" action="${flowExecutionUrl}"  commandName="contactus">
		<div>
			<table>
				<tbody>
					<tr>
						<td><label for="nombre"><fmt:message key="contactus.form.field.name"/>:</label></td>
						<td>
							<form:input path="name" cssErrorClass="error" />
							<form:errors path="name" cssClass="error" />
						</td>
					</tr>
					<tr>
						<td><label for="eMail"><fmt:message key="contactus.form.field.email"/>:</label></td>
						<td>
							<form:input path="email" cssErrorClass="error"/>
							<form:errors path="email" cssClass="error" />
						</td>
					</tr>
					<tr>
						<td><label for="subject"><fmt:message key="contactus.form.field.subject"/>:</label></td>
						<td>
							<form:input path="subject" cssErrorClass="error"/>
							<form:errors path="subject" cssClass="error" />
						</td>
					</tr>
					<tr>
						<td><label for="comentario"><fmt:message key="contactus.form.field.comments"/>:</label></td>
						<td>
							<form:textarea path="comments" cssErrorClass="error"/>
							<form:errors path="comments" cssClass="error" />
						</td>
					</tr>
				</tbody>
			</table>
			<input type="submit" name="_eventId_send" value="<fmt:message key="common.form.send"/>" />
		</div>
	</form:form>
</div>