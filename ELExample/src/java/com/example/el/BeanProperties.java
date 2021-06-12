/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.el;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class BeanProperties extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        Name name = new Name("First Name", "Last Name");
        Company company =
                new Company("company info",
                "Company Description");
        Employee employee = new Employee(name, company);
        request.setAttribute("emp", employee);
        RequestDispatcher dispatcher =
                request.getRequestDispatcher("/results/bean-properties.jsp");
        dispatcher.forward(request, response);
    }
}