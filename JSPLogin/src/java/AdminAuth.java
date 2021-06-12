
import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class AdminAuth extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        System.out.println("Checking admin login");
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "jsptest";
        String dbDriver = "com.mysql.jdbc.Driver";
        String dbUser = "root";
        String dbPass = "1234";
        String username = "";
        String userpass = "";
        String strQuery = "";
        Statement st = null;
        ResultSet rs = null;
        HttpSession session = req.getSession(true);
        try {
            Class.forName(dbDriver);
            conn = DriverManager.getConnection(url + dbName, dbUser, dbPass);
            username = req.getParameter("usrnm").toString();
            userpass = req.getParameter("pwd").toString();
            strQuery = "select * from login where username ='" + username + "' and  password='" + userpass + "'";
            System.out.println(strQuery);
            st = conn.createStatement();
            rs = st.executeQuery(strQuery);
            int count = 0;
            while (rs.next()) {
                session.setAttribute("username", rs.getString(2));
                count++;
            }
            if (count > 0) {
                res.sendRedirect("adminHome.jsp");
            } else {
                //res.sendRedirect("index.jsp");
                req.setAttribute("err", "Login Failed");
                req.getRequestDispatcher("index.jsp").forward(req, res);
            }
        } catch (Exception e) {
            throw new ServletException("Login failed", e);
        } finally {

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
    }
}
