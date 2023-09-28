package dat.backend.model.dao;

import dat.backend.model.config.HibernateConfig;
import dat.backend.model.dto.TempTimeDTO;
import dat.backend.model.entities.Weather;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.sql.Time;
import java.util.List;

public class WeatherDAO implements IDAO<Weather>
{
    EntityManagerFactory emf;

    private static WeatherDAO weatherDAO;

    private WeatherDAO()
    {
        this.emf = HibernateConfig.getEntityManagerFactoryConfig("weather", "update");
    }

    public static WeatherDAO getInstance()
    {
        if (weatherDAO == null)
        {
            weatherDAO = new WeatherDAO();
        }
        return weatherDAO;
    }

    @Override
    public Weather read(int id)
    {
        try (EntityManager em = emf.createEntityManager())
        {
            return em.find(Weather.class, id);
        }
    }

    @Override
    public List<Weather> readAll()
    {
        try (EntityManager em = emf.createEntityManager())
        {
            return em.createQuery("SELECT w FROM Weather w", Weather.class).getResultList();
        }
    }

    public List<TempTimeDTO> getTimeTempByCityId(Integer id)
    {
        try (EntityManager em = emf.createEntityManager())
        {
            List<TempTimeDTO> list = em.createQuery("SELECT new dat.backend.model.dto.TempTimeDTO(w.city.id, w.temperature, w.time)" +
                    " FROM Weather w WHERE w.city.id = :id", TempTimeDTO.class)
                    .setParameter("id", id)
                    .getResultList();
            return list;
        }
    }

}
