<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>입차 | 주차 관리 시스템</title>
    <jsp:include page="/header.jsp"></jsp:include>
</head>
<body>
    <div id="container">
        <div class="col-lg-4">
            <div class="jumbotron">
                <h1>입차</h1><br>
                <input type="button" class="btn btn-success" value="차량 등록" onclick="location.href='/in/insert.jsp'"><br><br>
                <input type="button" class="btn btn-success" value="입차 차량 조회" onclick="location.href='/in/list.jsp'"><br><br>
                <input type="button" class="btn btn-success" value="정기권 등록" onclick="location.href='/in/ticket_join.jsp'"><br><br>
                <input type="button" class="btn btn-success" value="정기권 연장" onclick="location.href='/in/ticket_extend.jsp'"><br><br>
                <input type="button" class="btn btn-success" value="정기권 조회" onclick="location.href='/in/ticket_list.jsp'"><br><br>
                <input type="button" class="btn btn-warning" value="메인" onclick="location.href='/index.jsp'">
            </div>
        </div>
    </div>
    <jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>
