<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>결과 | 주차 관리 시스템</title>
    <jsp:include page="/header.jsp"></jsp:include>
</head>
<body>
    <%
        int result = (int) request.getAttribute("result");
    %>
    <div id="container">
        <div class="col-lg-4">
            <div class="jumbotron">
                <h1>결과</h1><br>
                    <%
                        if(result == 1) {
                    %>
                    <p>정기권 차량으로 무료 출차 대상입니다.</p>
                    <p>출차 처리되었습니다.</p><br>
                    <input type="button" class="btn btn-warning" value="처음으로" onclick="location.href='/index.jsp'">
                    <%
                        } else if(result == 2) {
                    %>
                    <p>정기권 만료일자가 경과했습니다.</p>
                    <p>정기권 연장 또는 정산을 선택해주세요.</p><br>
                    <input type="button" class="btn btn-success" value="정기권 연장" onclick="location.href='/in/ticket_extend.jsp'"><br><br>
                    <input type="button" class="btn btn-success" value="정산" onclick="location.href='/out/pay_check.jsp'"><br><br>
                    <input type="button" class="btn btn-warning" value="돌아가기" onclick="location.href='/out/calculate.jsp'">
                    <%
                        } else if(result == 4) {
                    %>
                    <p>이미 출차가 완료된 차량 번호입니다.</p>
                    <p>확인 후 다시 시도해주세요.</p><br>
                    <input type="button" class="btn btn-warning" value="돌아가기" onclick="location.href='/out/calculate.jsp'">
                    <%
                        } else if(result == 5) {
                    %>
                    <p>입차되어 있는 차량 번호가 아닙니다.</p>
                    <p>확인 후 다시 시도해주세요.</p><br>
                    <input type="button" class="btn btn-warning" value="돌아가기" onclick="location.href='/out/calculate.jsp'">
                    <%
                        } else if(result == 0) {
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
