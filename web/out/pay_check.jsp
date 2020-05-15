<%@ page import="com.servlet.dao.PayDAO" %>
<%@ page import="com.servlet.dto.PayDTO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>결제 | 주차 관리 시스템</title>
    <jsp:include page="/header.jsp"></jsp:include>
</head>
<body>
    <%
        PayDAO payDAO = new PayDAO();
        String car_number = request.getParameter("car_number");

        if(car_number == null) {
            car_number = (String) request.getSession().getAttribute("check_car_number");
        }

        ArrayList<PayDTO> list = payDAO.checkPay(car_number);
    %>
    <div id="container">
        <div class="col-lg-4">
            <div class="jumbotron">
                <h1>결제</h1><br>
                <p>출차 전 정산이 필요한 차량입니다.</p>
                <form action="/Pay" method="POST">
                    <%
                        for(PayDTO dto : list) {
                    %>
                    차량 번호 : <%=dto.getCar_number()%><br><br>
                    입차 시간 : <%=dto.getIn_date()%><br><br>
                    주차 시간 : <%=dto.getParking_time()%>분<br><br>
                    결제 금액 : <%=dto.getPay_price()%>원<br><br>
                    <%
                            session.setAttribute("car_number", dto.getCar_number());
                            session.setAttribute("pay_price", dto.getPay_price());
                        }
                    %>
                    결제 수단 : <input type="radio" name="pay_kind" value="현금" checked="checked"> 현금
                        <input type="radio" name="pay_kind" value="신용카드"> 신용카드
                        <input type="radio" name="pay_kind" value="삼성페이"> 삼성페이<br><br><br>
                    <input type="submit" class="btn btn-primary" value="결제">
                    <input type="button" class="btn btn-danger" value="취소" onclick="location.href='/out/car.jsp'">
                </form>
            </div>
        </div>
    </div>
    <jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>