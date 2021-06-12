package webpackage;

import java.io.*;
import java.util.Date;
import javax.servlet.*;

public class MyServlet implements Servlet {

public void init(ServletConfig config) throws ServletException {

}

public void service(ServletRequest request, ServletResponse response)
        throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<html><head><title> BasicServlet </title></head>");
    out.println("<body><h2>Bashir</h2>");

    out.println("<hr></body></html>");
    out.close();
}

public void destroy() {

}

@Override
public ServletConfig getServletConfig() {
    return null;
}

@Override
public String getServletInfo() {
   return null;
}
}
