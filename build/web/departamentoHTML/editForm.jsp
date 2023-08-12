<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.entity.Departamento"%>
<%@page import="model.modelDAO.EmpresaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="empresa" class="model.modelDAO.EmpresaDAO" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="<c:url value="/css/departamento/editForm.css"/>"/>
    </head>
    <body>

        <%

            EmpresaDAO dao = new EmpresaDAO(Departamento.class);
            Departamento dep = new Departamento(request.getParameter("id"));
            dep = (Departamento) dao.consultarDepartamento(dep.getIdDepartamento());
            

        %>

        <form action="../editarDepartamento?flag=alterarDepartamento" method="POST" class="formulario">
            <input type="hidden" name="id" value="<%= dep.getIdDepartamento()%>"/>

            <div class="dpto">
                <label for="idDep">Indentificação do Departamento</label>
                <input type="text" name="idDepartamento" value="<%= dep.getIdDepartamento()%>" maxlength="3" minlength="2"
                       id="idDep" required>
            </div>
            <div class="nomeEtelefone">
                <label for="nome">Nome Departamento</label>
                <input type="text" name="nomeDepartamento" value="<%= dep.getNomeDepartamento()%>" maxlength="50" minlength="8" id="nome" required">


                <label for="telefone">Telefone</label>
                <input type="tel" name="telefoneDepartamento" value="<%= dep.getFoneDepartamento()%>" id="telefone" minlength="14" maxlength="15" required>
            </div>
            <div>
                <input style="font-size: 18px; height:30px; " type="submit" value="Cadastrar"/>
            </div>

        </form>

    </body>
</html>