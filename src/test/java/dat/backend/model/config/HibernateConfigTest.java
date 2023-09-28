package dat.backend.model.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.Test;
import dat.backend.model.entities.City;

import static org.junit.jupiter.api.Assertions.*;

class HibernateConfigTest
{
    @Test
    void testDBconnection()
    {
        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig("weather", "update");

        try (EntityManager em = emf.createEntityManager())
        {
            City c =  em.find(City.class, 1);
            System.out.println(c.getName());
        }
    }
}