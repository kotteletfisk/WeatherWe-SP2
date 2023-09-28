package dat.backend.control;

import dat.backend.model.dao.WeatherDAO;
import dat.backend.model.entities.Weather;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CityServlet", urlPatterns = {"/cityservlet"} )
public class CityServlet extends HttpServlet
{

    @Override
    public void init() throws ServletException
    {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");


        int cityId = Integer.parseInt(request.getParameter("cityId"));
        String cityName = request.getParameter("city");

        WeatherDAO weatherDAO = WeatherDAO.getInstance();
        List<Weather> weatherList = weatherDAO.readAllByCityName(cityName);

        request.setAttribute("cityName", cityName);
        request.setAttribute("weatherList", weatherList);
        request.getRequestDispatcher("/WEB-INF/city.jsp").forward(request, response);
    }
}