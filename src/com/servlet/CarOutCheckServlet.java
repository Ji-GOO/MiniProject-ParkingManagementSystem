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

@WebServlet(name = "CarOutCheckServlet", urlPatterns = "/OutCheckCar")
public class CarOutCheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        TicketDAO ticketDAO = new TicketDAO();

        String car_number = request.getParameter("car_number");
        request.getSession().setAttribute("check_car_number", car_number);

        TicketDTO dto = new TicketDTO(car_number);
        int result = ticketDAO.ticketOut(dto);
        request.setAttribute("result", result);

        if(result == 1) {   // 정기권 있음.
            ServletContext context = getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher("/out/result.jsp");
            dispatcher.forward(request, response);
        } else if(result == 2) {
            ServletContext context = getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher("/out/result.jsp");
            dispatcher.forward(request, response);
        } else if(result == 3) {
            ServletContext context = getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher("/out/pay_check.jsp");
            dispatcher.forward(request, response);
        } else if(result == 4) {
            ServletContext context = getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher("/out/result.jsp");
            dispatcher.forward(request, response);
        } else if(result == 5) {
            ServletContext context = getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher("/out/result.jsp");
            dispatcher.forward(request, response);
        } else if(result == 0) {
            ServletContext context = getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher("/out/result.jsp");
            dispatcher.forward(request, response);
        }
    }
}
