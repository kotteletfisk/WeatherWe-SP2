package dat.backend.control;

import com.google.gson.Gson;
import dat.backend.model.dao.WeatherDAO;
import dat.backend.model.dto.TempTimeDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "graphServlet", urlPatterns = {"/graphservlet"} )
public class GraphServlet extends HttpServlet
{

    @Override
    public void init() throws ServletException
    {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        WeatherDAO weatherDAO = new WeatherDAO();
        List<TempTimeDTO> dtos = weatherDAO.getTimeTempByCityId(1);

        request.setAttribute("dtos", dtos);
        request.getRequestDispatcher("/WEB-INF/graph.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        WeatherDAO weatherDAO = new WeatherDAO();
        List<TempTimeDTO> dtos = weatherDAO.getTimeTempByCityId(1);

        request.setAttribute("dtos", dtos);
        request.getRequestDispatcher("/WEB-INF/graph.jsp").forward(request, response);

    }

}