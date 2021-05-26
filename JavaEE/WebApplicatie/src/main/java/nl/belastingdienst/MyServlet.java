package nl.belastingdienst;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("DO GET CALLED!!!! ####################################");

        PrintWriter printer = response.getWriter();
        printer.println("<html><body>Hi</body></html>");
    }
}
