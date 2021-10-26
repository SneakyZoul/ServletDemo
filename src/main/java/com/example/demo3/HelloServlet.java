package com.example.demo3;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String navn = request.getParameter("name");
        String pass1 = request.getParameter("pass1");
        String pass2 = request.getParameter("pass2");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (pass1.equals(pass2)) {

            // Hello
            //  out.println("<html><body>");
            //out.println("<h1>" + message + "dit navn er "+ navn + "</h1>");
            //(out.println("</body></html>");

            HttpSession sessionID = request.getSession();

            request.setAttribute("navn",navn);
            request.setAttribute("sessionID",sessionID);

            request.getRequestDispatcher("WEB-INF/bruger.jsp").forward(request, response);
        } else {


            //out.println("<html><body>");
            // out.println("<h1>" + "dine passwords var ikke ens " + "</h1>");
            //out.println("</body></html>");


            String msg = "dit password var forkert";
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

    }

    public void destroy() {
    }
}