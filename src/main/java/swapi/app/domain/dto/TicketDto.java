package swapi.app.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class TicketDto {
    private Integer id;
    private Double price;
    private Integer percentageIncrease;
    private Integer dailySold;
    private Integer weeklySold;
    private Integer monthlySold;
    private Integer totSold;
    private Integer filmId;
    private Integer hallId;
}
