/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
public class DemoServletContext extends HttpServlet {

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

        ServletContext context = getServletContext();
        //to set attribute
        context.setAttribute("company", "IBM");
        //to get attribute
        String n = (String) context.getAttribute("company");
        out.println("Welcome to " + n);
        
        //get all attributes
        Enumeration<String> e = context.getInitParameterNames();

        String str = "";
        while (e.hasMoreElements()) {
            str = e.nextElement();
            out.print("<br> " + context.getInitParameter(str));
        }
    }
}
