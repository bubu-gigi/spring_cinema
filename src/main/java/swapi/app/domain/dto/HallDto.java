package swapi.app.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HallDto {
    private Integer id;
    private String name;
    private Integer baseSeats;
    private Integer soldBaseSeats;
    private Integer vipSeats;
    private Integer soldVipSeats;
    private Integer filmId;
}
