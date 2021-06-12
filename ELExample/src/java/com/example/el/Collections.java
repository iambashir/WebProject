/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.el;

import java.util.*;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Collections extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String[] firstNames = {"Bill", "Scott", "Larry"};
        List<String> lastNames = new ArrayList<String>();
        lastNames.add("Ellison");
        lastNames.add("Gates");
        lastNames.add("McNealy");
        Map<String, String> companyNames =
                new HashMap<String, String>();
        companyNames.put("Ellison", "Sun");
        companyNames.put("Gates", "Oracle");
        companyNames.put("McNealy", "Microsoft");
        request.setAttribute("first", firstNames);
        request.setAttribute("last", lastNames);
        request.setAttribute("company", companyNames);
        RequestDispatcher dispatcher =
                request.getRequestDispatcher("/results/collections.jsp");
        dispatcher.forward(request, response);
    }
}