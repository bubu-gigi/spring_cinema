package swapi.app.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilmDto {
    private Integer id;
    private String status;
    private String title;
    private Integer pellicole;
    private String releaseDate;
    private Double dailyGain;
    private Double weeklyGain;
    private Double monthlyGain;
    private Double totGain;
}
