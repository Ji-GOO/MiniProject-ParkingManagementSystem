package com.servlet;

import com.servlet.dao.CarDAO;
import com.servlet.dto.CarDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "com.servlet.CarInsertServlet", urlPatterns = "/InsertCar")
public class CarInsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        CarDAO carDAO = new CarDAO();

        String car_number = request.getParameter("car_number");
        String car_kind = request.getParameter("car_kind");

        CarDTO dto = new CarDTO(car_number, car_kind);
        int result = carDAO.insert(dto);
        request.setAttribute("result", result);

        if(result == 1) {
            ServletContext context = getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher("/in/result.jsp");
            dispatcher.forward(request, response);
        } else if(result == 2){
            ServletContext context = getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher("/in/result.jsp");
            dispatcher.forward(request, response);
        } else if(result == 0){
            ServletContext context = getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher("/in/result.jsp");
            dispatcher.forward(request, response);
        }
    }
}
