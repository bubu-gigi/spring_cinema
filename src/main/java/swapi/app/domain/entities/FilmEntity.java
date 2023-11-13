package swapi.app.domain.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;


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

    @Column(columnDefinition = "integer default 0")

    private Integer pellicole;

    @Column(columnDefinition = "double default 0", name = "tot_gain")
    @JsonIgnore
    private Double totGain;


    @Column(columnDefinition = "double default 0", name = "daily_gain")
    @JsonIgnore
    private Double dailyGain;

    @Column(columnDefinition = "double default 0", name = "weekly_gain")
    @JsonIgnore
    private Double weeklyGain;


    @Column(columnDefinition = "double default 0", name = "monthly_gain")
    @JsonIgnore
    private Double monthlyGain;


    @Column(name = "release_date")
    private String releaseDate;

}
