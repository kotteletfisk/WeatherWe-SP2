package dat.backend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Getter
public class TempTimeDTO
{
    private final Integer cityId;
    private final Integer temp;
    private final LocalDateTime time;

    @Override
    public String toString()
    {
        return "TempTimeDTO{" +
                "cityId=" + cityId +
                ", temp=" + temp +
                ", time=" + time +
                '}';
    }
}
