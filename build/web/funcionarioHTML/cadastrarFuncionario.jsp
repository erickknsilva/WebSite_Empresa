<%@page import="model.entity.Funcionario"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="./css/funcionario/cadastrarFuncionario.css"/>
        <title>Formulario de Funcionarios</title>
    </head>
    <style>
        div{
            display: flex;
            flex-direction: row;
        }

    </style>
    <body>

        <h1 style="text-align: center">Cadastro de Funcionario</h1>


        <form action="./cadastrarFuncionarios" method="POST" class="formulario">
            <input type="hidden" name="flag" value="cadastrarFuncionarios">

            <div>

                <label for="nome">Nome:</label><br>
                <input type="text" id="nome" name="nome" required><br><br>

                <label for="cargo">Cargo:</label><br>
                <input type="text" id="cargo" name="cargo" required><br><br>

                <label for="email">E-mail:</label><br>
                <input type="email" id="email" name="email" required><br><br>
            </div>
            <div>
                <label for="salario">Salario:</label><br>
                <input pattern="[0-9]+([,\.][0-9]+)?" name="salario" id="salario" placeholder="1343.60" required><br><br>

                <label for="departamento">Departamento:</label><br>


                <select id="departamento" name="departamento" required>
                    <c:forEach items="${listaDep}" var="dep"  >
                        <option value="${dep.getIdDepartamento()}">${dep.getNomeDepartamento()}</option>

                    </c:forEach>
                </select>
                <br><br>
                <input style="margin-left: 20px; font-size: 18px;   padding: 0px 10px" type="submit" value="Cadastrar">
            </div>

        </form>

    </body>
</html>
