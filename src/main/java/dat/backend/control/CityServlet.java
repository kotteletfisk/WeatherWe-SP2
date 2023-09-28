package dat.backend.control;

import dat.backend.model.Weather;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "initServlet", urlPatterns = {"/cityservlet"} )
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


        String cityName = request.getParameter("city");
        List<Weather> weatherList = null;
        switch (cityName)
        {
            case "København":

                break;
            case "Odense":

                break;
            case "Esbjerg":

                break;
            case "Rønne":

                break;
            case "Skagen":

                break;
            case "Gedser":

                break;
            case "Gilleleje":

                break;
        }

        request.setAttribute("cityName", cityName);
        request.setAttribute("weatherList", weatherList);
        request.getRequestDispatcher("/WEB-INF/city.jsp").forward(request, response);
    }

}