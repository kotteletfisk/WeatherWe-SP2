package dat.backend.control;

import dat.backend.model.dao.WeatherDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DecimalFormat;

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

        WeatherDAO weatherDAO = WeatherDAO.getInstance();

        DecimalFormat df = new DecimalFormat("#.##");

        request.setAttribute("humid", df.format(weatherDAO.getAvgHumid()));
        request.setAttribute("temp", df.format(weatherDAO.getAvgTemp()));
        request.setAttribute("wind", df.format(weatherDAO.getAvgWind()));
        request.setAttribute("precip", df.format(weatherDAO.getAvgPrecip()));

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}