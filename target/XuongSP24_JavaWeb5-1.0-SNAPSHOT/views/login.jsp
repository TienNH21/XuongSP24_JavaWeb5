<%--
  Created by IntelliJ IDEA.
  User: tiennh
  Date: 4/8/24
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<c:if test="${ not empty sessionScope.error }">
    <span style="color: red">${ sessionScope.error }</span>
</c:if>

<form method="POST" action="/login">
    <div>
        <label>Ten dang nhap</label>
        <input type="text" name="tenDangNhap" />
    </div>
    <div>
        <label>Mat khau</label>
        <input type="password" name="matKhau" />
    </div>
    <div>
        <button>Login</button>
    </div>
</form>

</body>
</html>
