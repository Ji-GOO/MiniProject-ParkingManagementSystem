package com.servlet;

import com.servlet.dao.PayDAO;
import com.servlet.dto.PayDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PayServlet", urlPatterns = "/Pay")
public class PayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        PayDAO payDAO = new PayDAO();

        String car_number = (String) request.getSession().getAttribute("car_number");
        int pay_price = (int) request.getSession().getAttribute("pay_price");
        String pay_kind = request.getParameter("pay_kind");

        PayDTO dto = new PayDTO(car_number, pay_price, pay_kind);
        int pay_result = payDAO.pay(dto);
        request.setAttribute("pay_result", pay_result);

        if(pay_result == 1) {
            ServletContext context = getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher("/out/pay_result.jsp");
            dispatcher.forward(request, response);
        } else if(pay_result == 0) {
            ServletContext context = getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher("/out/pay_result.jsp");
            dispatcher.forward(request, response);
        }
    }
}
