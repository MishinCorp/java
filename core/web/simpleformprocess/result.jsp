<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>Beer Recommendations JSP</h1>
<%
    StringBuilder html = new StringBuilder();
    List brands = (List) request.getAttribute("brands");
    Iterator it = brands.iterator();

    html.append("<p>");
    html.append(System.lineSeparator());
    while (it.hasNext()) {
        html.append("\t");
        html.append(it.next());
        html.append("<br/>");
        html.append(System.lineSeparator());
    }
    html.append("</p>");

    out.print(html.toString());
    out.close();
%>
</body>
</html>