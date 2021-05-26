<%--
  Created by IntelliJ IDEA.
  User: manst03
  Date: 21-5-2021
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Registratieformulier</title>
</head>
<body>
    <form action="registratie" method="post">
        <span> Voornaam: <label><input type="text" name = "Voornaam"></label> </span>
        <span> Achternaam: <label><input type="text" name = "Achternaam"></label> </span>
        <span> Email: <label><input type="email" name = "Email"></label> </span>
        <input type="submit" name="Opslaan">
    </form>
</body>
</html>
