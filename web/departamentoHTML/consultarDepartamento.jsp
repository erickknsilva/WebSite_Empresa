<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="model.entity.Departamento"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Acesso Gerente</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="<c:url value="/css/departamento/consultDep.css"/>">
    </head>

    <style>

        a{
            text-decoration: none;
            background-color: none;
        }
        a:visited{
            background-color: none;
        }
        a:visited{
            background-color: none;

        }
    </style>

    <body>
    <center>

        <div class="div-table" > 
            <table>

                <caption><span id="ani">Lista de Departamentos</span></caption>
                <thead>
                    <tr>
                        <th style="color: blueviolet">Id</th>
                        <th style="color: blueviolet">Nome Departamento</th>
                        <th style="color: blueviolet">Telefone</th>
                        <th style="color: blueviolet">Editar</th>
                        <th style="color: blueviolet">Excluir</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${lista}" var="dp">
                        <tr>
                            <td>${dp.getIdDepartamento()}</td>
                            <td>${dp.getNomeDepartamento()}</td>
                            <td id="tt">${dp.getFoneDepartamento()}</td>
                            <td>
                                <a href="departamentoHTML/editForm.jsp?id=${dp.getIdDepartamento()}">
                                    Editar
                                </a>
                            </td>
                            <td><a href="excluirDepartamento?id=${dp.getIdDepartamento()}" >
                                    Excluir
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </center>
</body>
</html>