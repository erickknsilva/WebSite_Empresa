<%@page import="model.entity.Departamento"%>
<%@page import="model.funcionarioDAO.FuncDAO"%>
<%@page import="model.entity.Funcionario"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="../css/funcionario/cadastrarFuncionario.css"/>
        <title>Formulario de Funcionarios</title>
    </head>
    <style>
        div{
            display: flex;
            flex-direction: row;
        }
        input{
            font-size: 16px;
        }

    </style>
    <body>

        <%
            FuncDAO dao = new FuncDAO();
            Funcionario func = dao.findByFunc(request.getParameter("id"));

            List<Departamento> listaDep = dao.findAllDep();
        %>

        <h1 style="text-align: center">Editar de Funcionario</h1>


        <form action="../editarFuncionario?flag=editarFuncionario" method="POST" class="formulario">
            <input type="hidden" name="id" value="<%=func.getEmailFuncionario()%>">

            <div>

                <label for="nome">Nome:</label><br>
                <input type="text" id="nome" name="nome" 
                       value="<%= func.getNomeFuncionario()%>" required><br><br>

                <label for="cargo">Cargo:</label><br>
                <input type="text" id="cargo"
                       value="<%= func.getCargoFuncionario()%>" name="cargo" required><br><br>

                <label for="email">E-mail:</label><br>
                <input type="email" id="email" 
                       value="<%= func.getEmailFuncionario()%>" readonly required><br><br>
            </div>
            <div>
                <label for="salario">Salario:</label><br>
                <input pattern="[0-9]+([,\.][0-9]+)?" name="salario" 
                       value="<%=func.getSalarioFuncionario()%>" id="salario" placeholder="1343.60" required><br><br>

                <label for="departamento">Departamento:</label><br>


                <select id="departamento" name="departamento" required>

                    <% for (Departamento dep : listaDep) {%>
                    <option value="<%=dep.getIdDepartamento()%>"><%=dep.getNomeDepartamento()%></option>
                    <%}%>
                </select>
                <br><br>
                <input style="margin-left: 20px; font-size: 18px;   padding: 0px 10px" type="submit" value="Cadastrar">
            </div>

        </form>

    </body>
</html>
