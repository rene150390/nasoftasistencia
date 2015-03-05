<!DOCTYPE html> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html data-bb-scroll-effect="off">
    <head>
        <meta charset="utf-8">
        <title>AGS NASOFT</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no"> 
        <meta name="format-detection" content="telephone=no" />
        <meta name="msapplication-tap-highlight" content="no" /> 
        <meta name="apple-mobile-web-app-capable" content="yes" />
  
        <link rel="stylesheet" href="<c:url value="/resources/css/main.css" />" type="text/css"> 
    </head> 
    <body>
        <div class="wrapper">
            <div class="logo"></div>
            <!--<h1>Bienvenido al mundo digital</h1>
            <h2><i></i>Tenemos un regalo para ti</h2>
            <p>Ordena por prioridad la actividaden la cual utilizas más los medios digitales.</p>
            <ul class="opciones">
                <li><i></i>Pagos en línea</li>
                <li><i></i>Compra de boletos para viajes</li>
                <li><i></i>Entretenimiento</li>
                <li><i></i>Redes sociales</li>
            </ul>-->
            
	            <h3>Verifica la asistencia o da de alta a los invitados</h3>
	           <div class="buscador">
                <div>
                    <ul id="userList">
                        <!--li>Usuario 1</li>
                        <li>Usuario 2</li>
                        <li>Usuario 3</li>
                        <li>Usuario 4</li>
                        <li>Usuario 4</li>
                        <li>Usuario 4</li-->
                    </ul>
                </div>
                <input id="autocompleteInput" type="text" placeholder="Nombre" required>
            </div>
	            <ul class="inputs">
                	<li><input id="company" type="text" placeholder="Compañía" required ></li>
                	<li><input id="position" type="text" placeholder="Puesto" required></li>
                	<li><input id="email" type="text" placeholder="Correo electrónico" required></li>
                	<li><input id="phone" type="text" placeholder="Teléfono" required></li>
            	</ul>
	            <button onclick="sendUserData()">Activa tu regalo</button>
	      
        </div>

        <script src="<c:url value="/resources/js/jquery-min.js" />"></script>
        <script src="<c:url value="/resources/js/main.js" />"></script>
    </body>
</html>