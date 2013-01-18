<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h1>Example</h1>
<form:form method="post" action="${flowExecutionUrl}"
	commandName="editForm">
	<p>Formulario de contacto en construcción.</p>
	<div>
		<input type="submit" name="_eventId_done" value="Aceptar" />
	</div>
</form:form>