<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>정기권 연장 | 주차 관리 시스템</title>
    <jsp:include page="/header.jsp"></jsp:include>
</head>
<body>
    <div id="container">
        <div class="col-lg-4">
            <div class="jumbotron">
                <h1>정기권 연장</h1><br>
                <form action="/ExtendTicket" method="POST">
                    차량 번호 : <input type="text" name="car_number" placeholder="Ex) 37거6444"><br><br>
                    기간 : <input type="radio" name="month" value="1" checked="checked"> 1달
                    <input type="radio" name="month" value="3"> 3달
                    <input type="radio" name="month" value="5"> 5달<br><br><br>
                    <input type="submit" class="btn btn-primary" value="연장">
                    <input type="button" class="btn btn-danger" value="취소" onclick="location.href='/in/car.jsp'">
                </form>
            </div>
        </div>
    </div>
<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>
