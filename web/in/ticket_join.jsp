<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>정기권 등록 | 주차 관리 시스템</title>
    <jsp:include page="/header.jsp"></jsp:include>
</head>
<body>
    <div id="container">
        <div class="col-lg-4">
            <div class="jumbotron">
                <h1>정기권 등록</h1><br>
                <form action="/JoinTicket" method="POST">
                    티켓 : <input type="radio" name="ticket_name" value="정기권" checked="checked"> 정기권<br><br>
                    차량 번호 : <input type="text" name="car_number" placeholder="Ex) 37거6444"><br><br>
                    이름 : <input type="text" name="member_name" placeholder="Ex) 홍길동"><br><br>
                    연락처 : <input type="text" name="member_contact" placeholder="Ex) 010-0000-0000"><br><br>
                    <p>정기권 기간 : 최초 등록 시 1달</p><br>
                    <input type="submit" class="btn btn-primary" value="등록">
                    <input type="button" class="btn btn-danger" value="취소" onclick="location.href='/in/car.jsp'">
                </form>
            </div>
        </div>
    </div>
    <jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>
