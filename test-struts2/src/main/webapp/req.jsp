<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String id = request.getParameter("id");
    out.println(id);
    out.flush();
    System.out.println(id);
%>