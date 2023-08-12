<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="<c:url value="/css/funcionario/consultFunc.css"/>">
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
                <caption><span id="ani">Lista de Funcionarios</span></caption>
                <thead>
                    <tr>
                        <td style="color: blueviolet; padding: 10px 50px">Nome</td>
                        <td style="color: blueviolet; padding: 10px 50px">Cargo</td>
                        <td style="color: blueviolet">Email</td>
                        <td style="color: blueviolet">Salario</td>
                        <td style="color: blueviolet; padding: 10px 40px">Departamento</td>
                        <td style="color: blueviolet">Editar</td>
                        <td style="color: blueviolet">Excluir</td>
                    </tr>
                </thead>
                <tbody >
                    <c:forEach items="${listaFunc}" var="func" >
                        <tr>
                            <td >${func.getNomeFuncionario()}</td>
                            <td style="padding: 10px 15px">${func.getCargoFuncionario()}</td>
                            <td style="padding: 10px 15px">${func.getEmailFuncionario()}</td>
                            <td style="padding: 10px 15px">${func.getSalarioFuncionario()}</td>
                            <td style="padding: 10px 15px">${func.getIdDepartamento().getNomeDepartamento()}</td>
                            <td>
                                <a href="funcionarioHTML/alterarFuncionario.jsp?id=${func.getEmailFuncionario()}">
                                    Editar
                                </a>
                            </td>
                            <td>
                                <a href="excluirFuncionario?id=${func.getEmailFuncionario()}">
                                    excluir
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
