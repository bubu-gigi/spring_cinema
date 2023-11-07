package swapi.app.domain.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "films")
public class FilmEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Integer id;
    private String status;
    private String title;
    private String description;
    private Integer pellicole;
    @Column(name = "tot_gain")
    @Value("${props.tot_gain: 0}")
    @JsonIgnore
    private Double totGain;
    
    @Column(name = "daily_gain")
    @Value("${props.daily_gain: 0}")
    @JsonIgnore
    private Double dailyGain;

    @Column(name = "release_date")
    private String releaseDate;

}
