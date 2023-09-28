package dat.backend.control;

import dat.backend.model.dao.WeatherDAO;
import dat.backend.model.dto.TempTimeDTO;
import dat.backend.model.entities.Weather;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
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

        int cityId = Integer.parseInt(request.getParameter("cityId"));

        WeatherDAO weatherDAO = new WeatherDAO();
        List<TempTimeDTO> dtos = weatherDAO.getTimeTempByCityId(cityId);

        request.setAttribute("dtos", dtos);

        request.setAttribute("cityId", cityId);
        request.getRequestDispatcher("/WEB-INF/graph.jsp").forward(request, response);
    }
}