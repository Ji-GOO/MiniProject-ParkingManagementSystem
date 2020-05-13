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

@WebServlet(name = "TicketExtendServlet", urlPatterns = "/ExtendTicket")
public class TicketExtendServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        TicketDAO ticketDAO = new TicketDAO();

        String car_number = request.getParameter("car_number");
        String month = request.getParameter("month");

        TicketDTO dto = new TicketDTO(car_number, month);
        int result = ticketDAO.extend(dto);
        request.setAttribute("result", result);

        if(result == 6) {
            ServletContext context = getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher("/in/result.jsp");
            dispatcher.forward(request, response);
        } else if(result == 7) {
            ServletContext context = getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher("/in/result.jsp");
            dispatcher.forward(request, response);
        } else if(result ==0) {
            ServletContext context = getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher("/in/result.jsp");
            dispatcher.forward(request, response);
        }
    }
}
