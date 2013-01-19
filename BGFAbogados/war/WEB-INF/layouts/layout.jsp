<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
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

<title>BGF Abogados</title>

<link href="css/bgfabogados.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container">
		<div class="menu">
			<ul>
				<li><a href="index.xhtml">Inicio</a></li>
				<li><a href="quienes-somos.xhtml">Quiénes somos</a></li>
				<li><a href="materias.xhtml">Materias</a></li>
				<li><a href="localizacion.xhtml">Localización</a></li>
				<li><a href="contacto.xhtml">Contacto</a></li>
			</ul>
		</div>
		<div class="header">
			<h1>BGF Abogados</h1>
		</div>
		<div class="pictures">
			<a href="materias.php#civil"><img src="images/civil.jpg" /></a> <a
				href="materias.php#penal"><img src="images/penal.jpg" /></a> <a
				href="materias.php#admin"><img src="images/administrativa.jpg" /></a>
			<a href="materias.php#laboral"><img src="images/laboral.jpg" /></a>
			<a href="materias.php#mercantil"><img src="images/mercantil.jpg" /></a>
		</div>
		<div class="body">
			<div class="bodyContainer">
				<tiles:insertAttribute name="body" />
			</div>
		</div>
		<div class="footer">BGF Abogados &copy; 2013</div>
	</div>
</body>
</html>
