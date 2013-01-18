<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-16" />
	<meta http-equiv="Pragma" content="no-cache" />
		
		<meta name="author" content="Juan D." />
		<meta name="Publisher" content="BGF Abogados" />
		<meta name="Copyright" content="BGF Abogados" />
		<meta name="Robots" content="all" />
		<meta name="Audience" content="all" />
		<meta name="description" content="Asesoramiento jurídico y solución a los problemas legales, en una extensa variedad de disciplinas jurídicas." />
		<meta name="keywords" content="abogados, oviedo, abogados oviedo, bgf abogados, bgf, civil, penal, administrativo, laboral, mercantil." />
		<meta name="Pagetopic" content="Página de inicio" />
		<meta name="Pagetype" content="homepage" />
		
	<title>BGF Abogados</title>

	<link href="css/bgfabogados.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div align="center">
		<table width="780" border="0" cellpadding="0" cellspacing="0"
			class="fondo">
			<tr>
				<td height="30" colspan="3" valign="top" class="menu">
					<div class="menuw">
						<ul id="menu">
							<li><a href="index.xhtml">Inicio</a></li>
							<li><a href="quienes-somos.xhtml">Quiénes somos</a></li>
							<li><a href="materias.xhtml">Materias</a></li>
							<li><a href="localizacion.xhtml">Localización</a></li>
							<li><a href="contacto.xhtml">Contacto</a></li>
						</ul>
					</div>
				</td>
			</tr>
			<tr>
				<td height="100" colspan="3" valign="top" class="header">
					<!--DWLayoutEmptyCell-->&nbsp;
				</td>
			</tr>
			<tr>
				<td width="14" height="15"></td>
				<td width="754"></td>
				<td width="13"></td>
			</tr>
			<tr>
				<td height="180" colspan="3" valign="top" bgcolor="#333333"	background="images/fondomenumaterias.gif">
					<div align="center">
						<a href="materias.php#civil"><img src="images/civil.jpg" width="155" height="180" border="0" /></a>
						<a href="materias.php#penal"><img src="images/penal.jpg" width="155" height="180" border="0" /></a>
						<a href="materias.php#admin"><img src="images/administrativa.jpg" width="155" height="180" border="0" /></a>
						<a href="materias.php#laboral"><img src="images/laboral.jpg" width="155" height="180" border="0" /></a>
						<a href="materias.php#mercantil"><img src="images/mercantil.jpg" width="155" height="180" border="0" /></a>
					</div>
				</td>
			</tr>
			<tr>
				<td height="18"></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td height="208"></td>
				<td valign="top" class="contenido"><div class="contenidow">
						<span class="conw">
							<tiles:insertAttribute name="body" />
						</span>
					</div></td>
				<td></td>
			</tr>
			<tr>
				<td height="18"></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td height="31" colspan="3" valign="top" class="footer"><div
						class="footerw">BGF Abogados &copy; 2013</div></td>
			</tr>
		</table>
	</div>
</body>
</html>
