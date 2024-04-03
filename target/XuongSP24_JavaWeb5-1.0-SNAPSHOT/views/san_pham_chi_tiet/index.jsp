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

    <form action="/san-pham-chi-tiet/index?idSanPham=${sanPham.id}" method="GET">
        <input type="hidden" name="idSanPham" value="${sanPham.id}" />
        <div class="row">
            <div class="col-6">
                <label for="">Từ khóa</label>
                <input type="text" class="form-control" name="keyword" />
            </div>
            <div class="col-6">
                <label for="">Trạng thái</label>
                <div>
                    <input type="radio" class="form-check-input" name="trangThai" value="1" />
                    <label>Hoạt động</label>
                    <input type="radio" class="form-check-input" name="trangThai" value="0" />
                    <label>Ngừng hoạt động</label>
                </div>
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-6 offset-3 d-flex align-items-center justify-content-center">
                <button class="btn btn-primary">Tìm kiếm</button>
                <a href="/san-pham-chi-tiet/index?idSanPham=${sanPham}" class="btn btn-light mr-2">Làm mới</a>
            </div>
        </div>
    </form>

</div>
<div class="mt-5 col-10 offset-1">
    <a href="#" class="btn btn-success">Thêm mới</a>
    <table class="table table-stripped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Mã</th>
            <th>Tên SP</th>
            <th>Màu sắc</th>
            <th>Kích thước</th>
            <th>Số lượng</th>
            <th>Đơn giá</th>
            <th>Trạng thái</th>
            <th>Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${ data }" var="spct">
            <tr>
                <td>${ spct.id }</td>
                <td>${ spct.maSPCT }</td>
                <td>${ sanPham.ten }</td>
                <td>${ spct.tenMauSac }</td>
                <td>${ spct.tenKichThuoc }</td>
                <td>${ spct.soLuong }</td>
                <td>${ spct.donGia }</td>
                <td>${ spct.trangThai }</td>
                <td>
                    <a class="btn btn-primary" href="/mau-sac/edit?id=${ ms.id }">Cập nhật</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>


        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </table>
</div>
</body>
</html>
