<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>출차 | 주차 관리 시스템</title>
    <jsp:include page="/header.jsp"></jsp:include>
</head>
<body>
<div id="container">
    <div class="col-lg-4">
        <div class="jumbotron">
            <h1>출차</h1><br>
            <input type="button" class="btn btn-success" value="정산" onclick="location.href='/out/calculate.jsp'"/><br><br>
            <input type="button" class="btn btn-success" value="출차 차량 조회" onclick="location.href='/out/list.jsp'"/><br><br>
            <input type="button" class="btn btn-warning" value="메인" onclick="location.href='/index.jsp'">
        </div>
    </div>
</div>
<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>
