package dat.backend.control;

import dat.backend.model.dao.WeatherDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "RedirectIndexServlet", urlPatterns = {"/redirectindexservlet"} )
public class RedirectIndexServlet extends HttpServlet
{

    @Override
    public void init() throws ServletException
    {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        request.getRequestDispatcher("/index").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        WeatherDAO weatherDAO = new WeatherDAO();

        request.setAttribute("humid", weatherDAO.getAvgHumid());
        request.setAttribute("temp", weatherDAO.getAvgTemp());
        request.setAttribute("wind", weatherDAO.getAvgWind());
        request.setAttribute("precip", weatherDAO.getAvgPrecip());


        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

}