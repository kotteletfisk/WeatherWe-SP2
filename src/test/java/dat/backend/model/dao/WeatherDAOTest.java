package dat.backend.model.dao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeatherDAOTest
{
    @Test
    void read()
    {
        WeatherDAO weatherDAO = WeatherDAO.getInstance();
        System.out.println(weatherDAO.read(1).getSkyText());
    }

    @Test
    void readAll()
    {
        WeatherDAO weatherDAO = WeatherDAO.getInstance();
        System.out.println(weatherDAO.readAll());
    }

    @Test
    void getTimeTempByCityId()
    {
        WeatherDAO weatherDAO = WeatherDAO.getInstance();
        System.out.println(weatherDAO.getTimeTempByCityId(1));
        System.out.println(weatherDAO.getTimeTempByCityId(2));
        System.out.println(weatherDAO.getTimeTempByCityId(5));
    }
}