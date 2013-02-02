<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="contactus">
	<h2><fmt:message key="contactus.form.titre.contactus"/></h2>
	<div class="vcard">
		<label for="contact_details" class="org">BGF Abogados</label>:
		<ul id="contact_details">
			<li class="tel"><fmt:message key="contactus.form.field.phone"/>: 985 20 93 81</li>
			<li class="fax"><fmt:message key="contactus.form.field.fax"/>: 985 20 93 82</li>
			<li class="email"><fmt:message key="contactus.form.field.email"/>: info@bgfabogados.com</li>
		</ul>
	</div>
	<p><fmt:message key="contaxtus.form.text.enter-your-comments"/>:</p>
	<form:form method="post" action="${flowExecutionUrl}"  commandName="contactus">
		<div class="error_messages">
			<spring:hasBindErrors name="contactus">
				<p><fmt:message key="contactus.validator.error-message"/></p>
				<ul>
					<form:errors path="name" cssClass="error" element="li" />
					<form:errors path="email" cssClass="error" element="li" />
					<form:errors path="subject" cssClass="error" element="li" />
					<form:errors path="comments" cssClass="error" element="li" />
				</ul>
			</spring:hasBindErrors>
		</div>
		<div>
			<table>
				<tbody>
					<tr>
						<td class="label_column"><label for="name"><fmt:message key="contactus.form.field.name"/>:</label></td>
						<td>
							<form:input id="name" path="name" cssErrorClass="error" />
						</td>
					</tr>
					<tr>
						<td class="label_column"><label for="email"><fmt:message key="contactus.form.field.email"/>:</label></td>
						<td>
							<form:input id="email" path="email" cssErrorClass="error"/>
						</td>
					</tr>
					<tr class="row_subject">
						<td class="column_label"><label for="subject"><fmt:message key="contactus.form.field.subject"/>:</label></td>
						<td class="column_field">
							<form:input id="subject" path="subject" cssErrorClass="error"/>
						</td>
					</tr>
					<tr class="row_comments">
						<td class="column_label"><label for="comments"><fmt:message key="contactus.form.field.comments"/>:</label></td>
						<td class="column_field">
							<form:textarea id="comments" path="comments" cssErrorClass="error" rows="10"/>
						</td>
					</tr>
				</tbody>
			</table>
			<input type="submit" name="_eventId_send" value="<fmt:message key="common.form.send"/>" />
		</div>
	</form:form>
</div>