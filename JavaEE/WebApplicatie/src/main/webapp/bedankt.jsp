<%--
  Created by IntelliJ IDEA.
  User: manst03
  Date: 21-5-2021
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         import="nl.belastingdienst.Contact"
%>

<%
    Contact contact = (Contact) request.getAttribute("contact");
%>

<html>
<head>
    <title>Bedankt!</title>
</head>
<body>
    <p> Bedankt voor de registratie! </p>

    <p>
        Uw gegevens zijn:

        Naam: <%=contact.getNaam()%>
        Email: <%=contact.getEmail()%>
    </p>
</body>
</html>
