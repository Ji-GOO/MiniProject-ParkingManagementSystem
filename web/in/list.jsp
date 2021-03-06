<%@ page import="com.servlet.dao.CarDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.servlet.dto.CarDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>입차 차량 조회 | 주차 관리 시스템</title>
    <jsp:include page="/header.jsp"></jsp:include>
</head>
<body>
    <%
        CarDAO carDAO = new CarDAO();
        ArrayList<CarDTO> list = carDAO.inList();
    %>
    <div class="container">
        <h1>입차 차량 조회</h1>
        <input type="button" class="btn btn-info" value="돌아가기" onclick="location.href='/in/car.jsp'"><br><br>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>차량 번호</th>
                    <th>차종</th>
                    <th>입차 시간</th>
                    <th>경과 시간</th>
                    <th>정기권 유무</th>
                    <th>정기권 만료일자</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for(CarDTO dto : list) {
                %>
                <tr>
                    <td><%=dto.getCar_number()%></td>
                    <td><%=dto.getCar_kind()%></td>
                    <td><%=dto.getCar_in_date()%></td>
                    <td><%=dto.getParking_time()%>분</td>
                    <%
                        if(dto.getTicket_valid() == null) {
                    %>
                    <td>NO</td>
                    <%
                        } else {
                            if(dto.getTicket_valid().equals("1")) {
                    %>
                    <td>YES</td>
                    <%
                        } else {
                    %>
                    <td>NO</td>
                    <%
                        } }
                    %>
                    <%
                        if(dto.getTicket_end() == null) {
                    %>
                    <td>-</td>
                    <%
                        } else {
                    %>
                    <td><%=dto.getTicket_end()%></td>
                    <%
                        }
                    %>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>
    <jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>
