<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h2>Contacto</h2>
<div>
	<ul>
		<li>TLF: 985 20 93 81</li>
		<li>FAX: 985 20 93 82</li>
		<li>Correo electrónico: informacion@bgfabogados.com</li>
	</ul>
</div>
<form:form method="post" action="${flowExecutionUrl}"  commandName="contactusForm">
	<p>Si quiere también puede utilizar el formulario que le ofrecemos a continuación:</p>
	<div>
		<table>
			<tbody>
				<tr>
					<td><label for="nombre">Nombre</label></td>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<td><label for="eMail">Correo electrónico</label></td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td><label for="comentario">Comentario</label></td>
					<td><form:textarea path="comments" /></td>
				</tr>
			</tbody>
		</table>
		<input type="submit" name="_eventId_send" value="Enviar" />
	</div>
</form:form>