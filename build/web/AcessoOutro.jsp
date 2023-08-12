
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<!DOCTYPE html>

<% String m = (String) request.getAttribute("mensagem");%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2> Outro <%=m%> </h2>
    </body>
</html>
