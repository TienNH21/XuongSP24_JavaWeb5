<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="mt-2 col-10 offset-1">
<form method="GET" action="/mau-sac/index" class="container">
    <div class="row">
        <div class="col-6">
            <label>Tìm kiếm</label>
            <div>
                <input type="text" name="keyword" class="form-control" value="${ keyword }"/>
            </div>
        </div>
        <div class="col-6">
            <label>Trạng thái</label>
            <div>
                <select class="form-select" name="trangThai">
                    <option></option>
                    <option value="1" ${ trangThai == 1 ? "selected" : "" } >Đang hoạt động</option>
                    <option value="0" ${ trangThai == 0 ? "selected" : "" } >Ngừng hoạt động</option>
                </select>
            </div>
        </div>
    </div>
    <div class="row mt-3">
        <div class="col-6 offset-3">
            <button class="btn btn-primary">Tìm kiếm</button>
            <a class="btn btn-light" href="/mau-sac/index">Làm mới</a>
        </div>
    </div>
</form>
</div>
<div class="mt-5 col-8 offset-2">
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
        <c:forEach items="${ data }" var="ms">
            <tr>
                <td>${ ms.id }</td>
                <td>${ ms.ma }</td>
                <td>${ ms.ten }</td>
                <td>${ ms.trangThai }</td>
                <td>
                    <a class="btn btn-primary" href="/mau-sac/edit?id=${ ms.id }">Cập nhật</a>
                </td>
                <td>
                    <a class="btn btn-danger" href="/mau-sac/delete?id=${ ms.id }">Xóa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>

        <nav aria-label="Page navigation example">
            <ul class="pagination">
                <li class="page-item">
                    <a class="page-link" href="/mau-sac/index?page=1&limit=${limit}">First</a>
                </li>

                <c:if test="${ page > 1 }">
                    <li class="page-item">
                        <a class="page-link" href="/mau-sac/index?page=${ page - 1 }&limit=${limit}">
                            ${ page - 1 }
                        </a>
                    </li>
                </c:if>

                <li class="page-item">
                    <span class="page-link">${ page }</span>
                </li>

                <c:if test="${ page < totalPage }">
                    <li class="page-item">
                        <a class="page-link" href="/mau-sac/index?page=${ page + 1 }&limit=${limit}">${ page + 1 }</a>
                    </li>
                </c:if>

                <li class="page-item">
                    <a class="page-link" href="/mau-sac/index?page=${ totalPage }&limit=${limit}">Last</a>
                </li>
            </ul>
        </nav>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </table>
</div>
</body>
</html>
