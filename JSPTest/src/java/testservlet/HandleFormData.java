
package testservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.apache.tomcat.jni.User.username;

/**
 *
 * @author User
 */
public class HandleFormData extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
//        try {
        // TODO output your page here
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet HandleFormData</title>");  
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>User Name " + request.getParameter("name") + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
//        if (name.equals("admin") && pass.equals("123abc")) {
//            request.setAttribute("name", name);
//            request.setAttribute("pass", pass);
//            RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
//            dispatcher.forward(request, response);
//            //response.sendRedirect("welcome.jsp");
//        } else {
//            response.sendRedirect("error.jsp");
//        }

        //my
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsptest", "root", "1234");
            String sql = "Select * from login where username='" + name + "' and password = '"+ pass +"' ";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String un = rs.getString("username");
                String pw = rs.getString("password");
                if (name.equals(un) && pass.equals(pw)) {
                    request.setAttribute("name", name);
                    request.setAttribute("pass", pass);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
                    dispatcher.forward(request, response);
                    //response.sendRedirect("welcome.jsp");
                } else {
                    response.sendRedirect("error.jsp");
                }
            }
        } catch (Exception e) {
        }

//        } finally {            
//            out.close();
//        }
    }
}
