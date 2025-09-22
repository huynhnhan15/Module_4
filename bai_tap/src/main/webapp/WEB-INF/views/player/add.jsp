<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm cầu thủ</title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-3">
<h2>Thêm cầu thủ</h2>
<form action="/players/add" method="post" class="form">
    <div class="mb-3">
        <label for="name" class="form-label">Họ và tên</label>
        <input type="text" id="name" name="name" class="form-control" required>
    </div>
    <div class="mb-3">
        <label for="birthday" class="form-label">Ngày sinh</label>
        <input type="date" id="birthday" name="birthday" class="form-control" required>
    </div>
    <div class="mb-3">
        <label for="experience" class="form-label">Kinh nghiệm (năm)</label>
        <input type="number" id="experience" name="experience" class="form-control">
    </div>
    <div class="mb-3">
        <label for="position" class="form-label">Vị trí</label>
        <input type="text" id="position" name="position" class="form-control">
    </div>
    <div class="mb-3">
        <label for="avatar" class="form-label">Ảnh đại diện (URL)</label>
        <input type="text" id="avatar" name="avatar" class="form-control">
    </div>
    <button type="submit" class="btn btn-success">Lưu</button>
    <a href="/players" class="btn btn-secondary">Hủy</a>
</form>
</body>
</html>
