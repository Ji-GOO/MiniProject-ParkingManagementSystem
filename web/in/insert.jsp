<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>차량 등록 | 주차 관리 시스템</title>
    <jsp:include page="/header.jsp"></jsp:include>
</head>
<body>
    <div id="container">
        <div class="col-lg-4">
            <div class="jumbotron">
                <h1>차량 등록</h1><br>
                <form action="/InsertCar" method="POST">
                    차량 번호 : <input type="text" name="car_number" placeholder="Ex) 37거6444"><br><br>
                    차종 : <input type="radio" name="car_kind" value="소형"> 소형
                            <input type="radio" name="car_kind" value="중형"> 중형
                            <input type="radio" name="car_kind" value="대형"> 대형<br><br>
                    <p>주차 요금 : 10분당 500원</p><br>
                    <input type="submit" class="btn btn-primary" value="등록">
                    <input type="button" class="btn btn-danger" value="취소" onclick="location.href='/in/car.jsp'">
                </form>
            </div>
        </div>
    </div>
    <jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>
