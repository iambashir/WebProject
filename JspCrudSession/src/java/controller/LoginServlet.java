/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.User;
import dao.UserDao;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/dologin"})
public class LoginServlet extends HttpServlet {

    UserDao userDao;
    User user;

    @Override
    public void init() throws ServletException {
        super.init();
        userDao = new UserDao();
        user = new User();
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String action = request.getParameter("action");
        user.setName(username);
        user.setPass(password);
        //if (action == "login") {
            boolean isLogin = userDao.doLogin(user);
            if (isLogin) {
                List<User> user = userDao.getAllUsers();
                request.setAttribute("user", user);
                request.getRequestDispatcher("welcome.jsp").forward(request, response);
            } else {
                response.sendRedirect("index.jsp");
            }
        //}
    }
}
