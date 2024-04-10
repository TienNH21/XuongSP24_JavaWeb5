<%--
  Created by IntelliJ IDEA.
  User: tiennh
  Date: 3/18/24
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<form method="POST" action="/nhan-vien/store">
    <div>
        <label>Mã</label>
        <input type="text" name="ma" />
    </div>
    <div>
        <label>Tên</label>
        <input type="text" name="ten" />
    </div>
    <div>
        <label>Username</label>
        <input type="text" name="username" />
    </div>
    <div>
        <label>Password</label>
        <input type="password" name="password" />
    </div>
    <div>
        <button>Thêm mới</button>
    </div>
</form>
</body>
</html>
