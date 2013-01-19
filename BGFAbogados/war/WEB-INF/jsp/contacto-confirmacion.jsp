<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h2>Confirmación de envío</h2>
<form method="post" action="${flowExecutionUrl}">
	<c:if test="${deliveryStatus.sent}">
		<p>Gracias por su comentario. Le atenderemos lo antes posible.</p>
		<input type="submit" name="_eventId_done" value="Aceptar" />
	</c:if>
	<c:if test="${!deliveryStatus.sent}">
		<p>Los sentimos, por dificultades técnicas su comentario no ha podido ser enviado.</p>
		<p>Por favor inténtelo más tarde.</p>
		<input type="submit" name="_eventId_done" value="Reintentar" />
	</c:if>
</form>
