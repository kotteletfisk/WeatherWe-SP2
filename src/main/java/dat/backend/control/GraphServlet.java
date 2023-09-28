package dat.backend.control;

import dat.backend.model.Weather;
import dat.backend.model.dao.WeatherDAO;
import dat.backend.model.dto.TempTimeDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "graphservlet", urlPatterns = {"/graphservlet"} )
public class GraphServlet extends HttpServlet
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

        WeatherDAO weatherDAO = WeatherDAO.getInstance();

        List<TempTimeDTO> dtoList = weatherDAO.getTimeTempByCityId(1);

        request.setAttribute("dtoList", dtoList);
        request.getRequestDispatcher("/WEB-INF/graph.jsp").forward(request, response);
    }
}