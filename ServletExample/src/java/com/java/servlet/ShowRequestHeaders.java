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

//Servlet
//GenericServlet
//HttpServlet
public class ShowRequestHeaders extends HttpServlet {
String paramName = null;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.paramName = config.getInitParameter("version");
    }
    
    

    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Request Header";
        out.println(paramName);
        out.println("<HTML>\n"
                + "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n"
                + "<BODY BGCOLOR=\"#FDF5E6\">\n"
                + "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n"
                + "<B>Request Method: </B>"
                + request.getMethod() + "<BR>\n"
                + "<B>Request URI: </B>"
                + request.getRequestURI() + "<BR>\n"
                + "<B>Request Protocol: </B>"
                + request.getProtocol() + "<BR><BR>\n"
                + "<TABLE BORDER=1 ALIGN=\"CENTER\">\n"
                + "<TR BGCOLOR=\"#FFAD00\">\n"
                + "<TH>Header Name<TH>Header Value");
        Enumeration<String> headerNames =
                request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            out.println("<TR><TD>" + headerName);
            out.println(" <TD>" + request.getHeader(headerName));
        }
        out.println("</TABLE>\n</BODY></HTML>");
    }

    /** Since this servlet is for debugging, have it
     * handle GET and POST identically. */
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}