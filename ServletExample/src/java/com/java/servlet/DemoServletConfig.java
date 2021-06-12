/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
public class DemoServletConfig extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        ServletConfig config = getServletConfig();
        //get initialization parameter
        String username = config.getInitParameter("username");
        out.print("User Name is: " + username);
        //get all initialization parameters
        Enumeration<String> e = config.getInitParameterNames();

        String str = "";
        while (e.hasMoreElements()) {
            str = e.nextElement();
            out.print("<br>Name: " + str);
            out.print(" value: " + config.getInitParameter(str));
        }

        out.close();
    }
}
