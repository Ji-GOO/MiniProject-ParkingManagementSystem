<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>메인 | 주차 관리 시스템</title>
      <jsp:include page="/header.jsp"></jsp:include>
  </head>
  <body>
  <div id="container">
      <div class="col-lg-4">
        <div class="jumbotron">
      <h1>주차 관리 시스템</h1><br>
      <input type="button" class="btn btn-success" value="입차" onclick="location.href='/in/car.jsp'"><br><br>
      <input type="button" class="btn btn-success" value="출차" onclick="location.href='/out/car.jsp'">
        </div>
      </div>
  </div>
  <jsp:include page="/footer.jsp"></jsp:include>
  </body>
</html>
