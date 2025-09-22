<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Danh sách cầu thủ</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-3">
<h1 class="mb-3">Danh sách cầu thủ</h1>
<a href="/players/add" class="btn btn-success mb-3">Thêm cầu thủ</a>
<p class="text-success">${mess}</p>

<table class="table table-bordered table-striped">
  <thead class="table-dark">
  <tr>
    <th>STT</th>
    <th>ID</th>
    <th>Họ và tên</th>
    <th>Ngày sinh</th>
    <th>Kinh nghiệm</th>
    <th>Vị trí</th>
    <th>Ảnh đại diện</th>
    <th>Detail</th>
    <th>Detail</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${playerList}" var="player" varStatus="status">
    <tr>
      <td>${status.count}</td>
      <td>${player.id}</td>
      <td>${player.name}</td>
      <td>${player.birthday}</td>
      <td>${player.experience}</td>
      <td>${player.position}</td>
      <td>
        <img src="${player.avatar}" alt="avatar" width="80" height="80"/>
      </td>
      <td><a href="/players/detail?id=${player.id}" class="btn btn-primary btn-sm">Detail1</a></td>
      <td><a href="/players/detail/${player.id}" class="btn btn-secondary btn-sm">Detail2</a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
