/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.el;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ScopedVars extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("attribute1", "First Value");
        HttpSession session = request.getSession();
        session.setAttribute("attribute2", "Second Value");
        ServletContext application = getServletContext();
        application.setAttribute("attribute3",
                new java.util.Date());
        request.setAttribute("repeated", "Request");
        session.setAttribute("repeated", "Session");
        application.setAttribute("repeated", "ServletContext");
        RequestDispatcher dispatcher =
                request.getRequestDispatcher("/results/scoped-vars.jsp");
        dispatcher.forward(request, response);
    }
}
