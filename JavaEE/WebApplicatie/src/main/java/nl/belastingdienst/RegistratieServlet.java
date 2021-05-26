package nl.belastingdienst;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registratie")
public class RegistratieServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Contact contact = new Contact(
                request.getParameter("Voornaam"),
                request.getParameter("Achternaam"),
                request.getParameter("Email")
        );

        request.setAttribute("contact", contact);
        request.getRequestDispatcher("/response").forward(request, response);
    }
}
