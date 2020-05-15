<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>정산 | 주차 관리 시스템</title>
    <jsp:include page="/header.jsp"></jsp:include>
</head>
<body>
    <div id="container">
        <div class="col-lg-4">
            <div class="jumbotron">
                <h1>정산</h1><br>
                <form action="/OutCheckCar" method="POST">
                    차량 번호 : <input type="text" name="car_number" placeholder="예) 37거 6444"><br><br><br>
                    <input type="submit" class="btn btn-primary" value="조회">
                    <input type="button" class="btn btn-danger" value="취소" onclick="location.href='/out/car.jsp'">
                </form>
            </div>
        </div>
    </div>
    <jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>
