<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="model.entity.Departamento"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
         <link rel="stylesheet" href="<c:url value="/css/departamento/style.css"/>">
    </head>
    <body>

        <h1 >Pesquise por Id ou Departamento para alterar.</h1>

        <main>
            <div class="divSearch">
                <label for="search-">Buscar Departamentos</label>
                <input type="search" id="search-"/>
            </div>

            <div  class="container">
z
                <a href="../consultarDepartamento?flag=ConsultarDepartamento" class="content"> </a>
            </div>
        </main>

        <script src="../departamentoHTML/javaScript/script.js"></script>
    </body>
</html>