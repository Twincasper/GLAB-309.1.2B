package com.perscholas.glab30912.glab30912b;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String user = "user";
        String userPassword = "123";
        String username = request.getParameter("myName");
        String password = request.getParameter("password");
        if(user.equals(username) & password.equals(userPassword)) {
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            RequestDispatcher rd = request.getRequestDispatcher("./success.jsp");
            rd.forward(request, response);
        }
        else {
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            RequestDispatcher rd = request.getRequestDispatcher("./fail.jsp");
            rd.forward(request, response);
        }
    }

}