<%@ page import="com.servlet.dto.TicketDTO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.servlet.dao.TicketDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>정기권 조회 | 주차 관리 시스템</title>
    <jsp:include page="/header.jsp"></jsp:include>
</head>
<body>
    <%
        TicketDAO ticketDAO = new TicketDAO();
        ArrayList<TicketDTO> list = ticketDAO.ticketList();
    %>
    <div class="container">
        <h1>정기권 조회</h1>
        <input type="button" class="btn btn-info" value="돌아가기" onclick="location.href='/in/car.jsp'"><br><br>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>차량 번호</th>
                <th>차종</th>
                <th>이름</th>
                <th>연락처</th>
                <th>티켓 이름</th>
                <th>시작일</th>
                <th>만료일</th>
            </tr>
            </thead>
            <tbody>
            <%
                for(TicketDTO dto : list) {
            %>
            <tr>
                <td><%=dto.getCar_number()%></td>
                <td><%=dto.getCar_kind()%></td>
                <td><%=dto.getMember_name()%></td>
                <td><%=dto.getMember_contact()%></td>
                <td><%=dto.getTicket_name()%></td>
                <td><%=dto.getTicket_start()%></td>
                <td><%=dto.getTicket_end()%></td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
</body>
</html>
