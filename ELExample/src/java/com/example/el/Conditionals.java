/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.el;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Conditionals extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        SalesBean apples =
                new SalesBean(150.25, -75.25, 22.25, -33.57);
        SalesBean oranges =
                new SalesBean(-220.25, -49.57, 138.25, 12.25);
        request.setAttribute("apples", apples);
        request.setAttribute("oranges", oranges);
        RequestDispatcher dispatcher =
                request.getRequestDispatcher("/results/conditionals.jsp");
        dispatcher.forward(request, response);
    }
}
