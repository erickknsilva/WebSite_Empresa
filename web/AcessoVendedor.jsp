
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String mensagem = (String) request.getAttribute("mensagem");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> Vendedor <%=mensagem%>  </h1>
    </body>
</html>
