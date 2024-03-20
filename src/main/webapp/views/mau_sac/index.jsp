<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="#">Thêm mới</a>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Mã</th>
        <th>Tên</th>
        <th>Trạng thái</th>
        <th colspan="2">Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${ data }" var="ms">
        <tr>
            <td>${ ms.id }</td>
            <td>${ ms.ma }</td>
            <td>${ ms.ten }</td>
            <td>${ ms.trangThai }</td>
            <td>
                <a href="#">Cập nhật</a>
            </td>
            <td>
                <a href="/mau-sac/delete?id=${ ms.id }">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
