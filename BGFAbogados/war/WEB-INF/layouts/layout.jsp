<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<tiles:insertAttribute name="doctype" />
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Pragma" content="no-cache" />

<meta name="author" content="Juan D." />
<meta name="Publisher" content="BGF Abogados" />
<meta name="Copyright" content="BGF Abogados" />
<meta name="Robots" content="all" />
<meta name="Audience" content="all" />
<meta name="description"
	content="Asesoramiento jurídico y solución a los problemas legales, en una extensa variedad de disciplinas jurídicas." />
<meta name="keywords"
	content="abogados, oviedo, abogados oviedo, bgf abogados, bgf, civil, penal, administrativo, laboral, mercantil." />
<meta name="Pagetopic" content="Página de inicio" />
<meta name="Pagetype" content="homepage" />

<title><fmt:message key="common.label.firm"/></title>

<link href="/css/bgfabogados.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container">
		<div class="menu">
			<ul>
				<li><a href="/"><fmt:message key="layout.menu.link.home"/></a></li>
				<li><a href="/quienes-somos.xhtml"><fmt:message key="layout.menu.link.aboutus"/></a></li>
				<li><a href="/materias.xhtml"><fmt:message key="layout.menu.link.portfolio"/></a></li>
				<li><a href="/localizacion.xhtml"><fmt:message key="layout.menu.link.location"/></a></li>
				<li><a href="/contacto.xhtml"><fmt:message key="layout.menu.link.contactus"/></a></li>
			</ul>
		</div>
		<div class="header">
			<h1><fmt:message key="common.label.firm"/></h1>
		</div>
		<div class="pictures">
			<a href="materias.xhtml#civil"><img src="/images/civil.png" alt="<fmt:message key="layout.page.image.civil_law"/>" /></a>
			<a href="materias.xhtml#penal"><img src="/images/penal.jpg" alt="<fmt:message key="layout.page.image.criminal_law"/>" /></a>
			<a href="materias.xhtml#administrativo"><img src="/images/administrativa.jpg" alt="<fmt:message key="layout.page.image.administrative_law"/>"/></a>
			<a href="materias.xhtml#laboral"><img src="/images/laboral.jpg" alt="<fmt:message key="layout.page.image.labor_law"/>"/></a>
			<a href="materias.xhtml#mercantil"><img src="/images/mercantil.jpg" alt="<fmt:message key="layout.page.image.commertial_law"/>" /></a>
		</div>
		<div class="body">
			<div class="bodyContainer">
				<tiles:insertAttribute name="body" />
			</div>
		</div>
		<div class="footer"><fmt:message key="layout.page.label.copyright"/></div>
	</div>
</body>
</html>
