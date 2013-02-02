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
		<div class="error_messages">
			<ul>
				<form:errors path="name" cssClass="error" element="li" />
				<form:errors path="email" cssClass="error" element="li" />
				<form:errors path="subject" cssClass="error" element="li" />
				<form:errors path="comments" cssClass="error" element="li" />
			</ul>
		</div>
		<div>
			<table>
				<tbody>
					<tr>
						<td class="label_column"><label for="nombre"><fmt:message key="contactus.form.field.name"/>:</label></td>
						<td>
							<form:input path="name" cssErrorClass="error" />
						</td>
					</tr>
					<tr>
						<td class="label_column"><label for="eMail"><fmt:message key="contactus.form.field.email"/>:</label></td>
						<td>
							<form:input path="email" cssErrorClass="error"/>
						</td>
					</tr>
					<tr class="row_subject">
						<td class="column_label"><label for="subject"><fmt:message key="contactus.form.field.subject"/>:</label></td>
						<td class="column_field">
							<form:input path="subject" cssErrorClass="error"/>
						</td>
					</tr>
					<tr class="row_comments">
						<td class="column_label"><label for="comentario"><fmt:message key="contactus.form.field.comments"/>:</label></td>
						<td class="column_field">
							<form:textarea path="comments" cssErrorClass="error"/>
						</td>
					</tr>
				</tbody>
			</table>
			<input type="submit" name="_eventId_send" value="<fmt:message key="common.form.send"/>" />
		</div>
	</form:form>
</div>