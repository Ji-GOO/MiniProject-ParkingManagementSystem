<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>결과 | 주차 관리 시스템</title>
    <jsp:include page="/header.jsp"></jsp:include>
</head>
<body>
    <%
        int pay_result = (int) request.getAttribute("pay_result");
    %>
    <div id="container">
        <div class="col-lg-4">
            <div class="jumbotron">
                <h1>결과</h1><br>
                <%
                    if(pay_result == 1) {
                %>
                <p>성공적으로 결제가 완료되어 출차되었습니다.</p>
                <p>이용해 주셔서 감사합니다.</p><br>
                <input type="button" class="btn btn-warning" value="처음으로" onclick="location.href='/index.jsp'">
                <%
                } else if(pay_result == 0) {
                %>
                <p>오류가 발생했습니다.</p>
                <p>다시 시도해주세요.</p><br>
                <input type="button" class="btn btn-warning" value="돌아가기" onclick="location.href='/out/calculate.jsp'">
                <%
                    }
                %>
            </div>
        </div>
    </div>
    <jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>
