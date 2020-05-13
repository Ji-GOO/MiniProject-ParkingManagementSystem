package com.servlet;

import com.servlet.dao.TicketDAO;
import com.servlet.dto.TicketDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "TicketJoinServlet", urlPatterns = "/JoinTicket")
public class TicketJoinServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        TicketDAO ticketDAO = new TicketDAO();

        String ticket_name = request.getParameter("ticket_name");
        Boolean ticket_valid = true;
        LocalDate ticket_start = LocalDate.now();
        LocalDate ticket_end = ticket_start.plusMonths(1);
        String car_number = request.getParameter("car_number");
        String member_name = request.getParameter("member_name");
        String member_contact = request.getParameter("member_contact");

        TicketDTO dto = new TicketDTO(ticket_name, ticket_valid, ticket_start, ticket_end, car_number, member_name, member_contact);
        int result = ticketDAO.join(dto);
        request.setAttribute("result", result);

        if(result == 3) {
            ServletContext context = getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher("/in/result.jsp");
            dispatcher.forward(request, response);
        } else if(result == 4){
            ServletContext context = getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher("/in/result.jsp");
            dispatcher.forward(request, response);
        } else if(result == 5) {
            ServletContext context = getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher("/in/result.jsp");
            dispatcher.forward(request, response);
        } else if(result == 0) {
            ServletContext context = getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher("/in/result.jsp");
            dispatcher.forward(request, response);
        }
    }
}
