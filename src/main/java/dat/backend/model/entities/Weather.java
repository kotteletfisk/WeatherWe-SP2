package dat.backend.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
public class Weather
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime time;
    private Integer temperature;
    private String wind;
    private String skyText;
    private Integer humid;
    private Integer precipitation;

    @ManyToOne(fetch = FetchType.EAGER)
    private City city;

    public Weather(int id, LocalDateTime time, Integer temperature, String wind, String skyText, Integer humid, Integer precipitation, City city)
    {
        this.id = id;
        this.time = time;
        this.temperature = temperature;
        this.wind = wind;
        this.skyText = skyText;
        this.humid = humid;
        this.precipitation = precipitation;
        this.city = city;
    }
}
