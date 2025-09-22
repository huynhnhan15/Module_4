<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Chi tiết cầu thủ</title>
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-3">
<h2>Chi tiết cầu thủ</h2>
<p><strong>ID:</strong> ${player.id}</p>
<p><strong>Họ và tên:</strong> ${player.name}</p>
<p><strong>Ngày sinh:</strong> ${player.birthday}</p>
<p><strong>Kinh nghiệm:</strong> ${player.experience} năm</p>
<p><strong>Vị trí:</strong> ${player.position}</p>
<p><strong>Ảnh:</strong></p>
<img src="${player.avatar}" alt="avatar" width="150" height="150"/>

<br><br>
<a href="/players" class="btn btn-primary">Quay lại danh sách</a>
</body>
</html>
