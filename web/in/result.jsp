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
                    <p>성공적으로 차량이 입차되었습니다.</p><br>
                    <input type="button" class="btn btn-warning" value="처음으로" onclick="location.href='/index.jsp'">
                    <%
                        } else if(result == 2) {

                    %>
                    <p>이미 입차되어 있는 차량 번호입니다.</p>
                    <p>확인 후 다시 입력해주세요.</p><br>
                    <input type="button" class="btn btn-warning" value="돌아가기" onclick="location.href='/in/car.jsp'">
                    <%
                        } else if(result == 3) {
                    %>
                    <p>성공적으로 정기권이 등록되었습니다.</p><br>
                    <input type="button" class="btn btn-warning" value="처음으로" onclick="location.href='/index.jsp'">
                    <%
                        } else if(result == 4) {
                    %>
                    <p>이미 등록되어 있는 정기권 차량 번호입니다.</p>
                    <p>확인 후 다시 입력해주세요.</p><br>
                    <input type="button" class="btn btn-warning" value="돌아가기" onclick="location.href='/in/car.jsp'">
                    <%
                        } else if(result == 5) {
                    %>
                    <p>입차된 적 없는 차량 번호입니다.</p>
                    <p>※ 한번이라도 입차된 기록이 있어야 합니다.</p><br>
                    <input type="button" class="btn btn-warning" value="돌아가기" onclick="location.href='/index.jsp'">
                    <%
                        } else if(result == 6) {
                    %>
                    <p>성공적으로 정기권이 연장되었습니다.</p><br>
                    <input type="button" class="btn btn-warning" value="처음으로" onclick="location.href='/index.jsp'">
                    <%
                        } else if(result == 7) {
                    %>
                    <p>정기권이 등록되지 않은 차량 번호입니다.</p>
                    <p>먼저 정기권 등록 후 이용해주세요.</p><br>
                    <input type="button" class="btn btn-warning" value="돌아가기" onclick="location.href='/index.jsp'">
                    <%
                        } else if(result == 0) {
                    %>
                    <p>올바르게 입력해주세요.</p><br>
                    <input type="button" class="btn btn-warning" value="돌아가기" onclick="location.href='/in/car.jsp'">
                    <%
                        }
                    %>
            </div>
        </div>
    </div>
    <jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>
