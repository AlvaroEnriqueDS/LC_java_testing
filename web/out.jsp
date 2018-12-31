<%--
  Created by IntelliJ IDEA.
  User: Alvaro
  Date: 11/09/2018
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    	//RECUPERAMOS LOS DATOS GUARDADOS EN EL ATRIBUTO "nombres" DE LA SESION
    	//=====================================================================
		String nombres=(String)session.getAttribute("nombres");
    %>
<!doctype html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Saliste de Recursos Humanos</title>
  <link rel="icon" type="image/png" href="imagenes/icon.png"/>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
  <link rel="stylesheet" href="css/Styles.css">
  <script src="js"></script>
</head>
<body  >
<div class="fondo">
<div class="container">
  <div class="row">
    <div class=" col-sd-2 col-md-6 "></div>
    <div class=" col-sd-1 col-md-1 "></div>
    <div class=" main-container col-sd-8 col-md-5">
      <div class="main-container__item1">
        <h1>SU SESION A SIDO FINALIZADA </h1>
      </div>
      <div class="main-container__item2">
        <p>Gracias por tu visita <%=nombres %></p>
      </div>
      <div class="main-container__item3 container">
        <div class="row">		
			
           <div class="col-lg-6 container_btn1" >
            <a href="index.jsp" class="btn-ghost ">Volver a inicio</a>
          </div>

        </div>

      </div>
    </div>
  </div>
</div>


</div>
</body>
</html>
