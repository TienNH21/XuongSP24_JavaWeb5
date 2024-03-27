<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="mt-5 col-10 offset-1">
    <a href="#" class="btn btn-success">Thêm mới</a>
    <table class="table table-stripped">
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
        <c:forEach items="${ data }" var="sp">
            <tr>
                <td>${ sp.id }</td>
                <td>${ sp.ma }</td>
                <td>${ sp.ten }</td>
                <td>${ sp.trangThai }</td>
                <td>
                    <a class="btn btn-primary" href="/mau-sac/edit?id=${ sp.id }">Cập nhật</a>
                </td>
                <td>
                    <a class="btn btn-light"
                       href="/san-pham-chi-tiet/index?idSanPham=${sp.id}">
                        Xem chi tiết
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>


        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </table>
</div>
</body>
</html>
