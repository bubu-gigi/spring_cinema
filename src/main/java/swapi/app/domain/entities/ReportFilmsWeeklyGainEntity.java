package swapi.app.domain.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "report_films_weekly_gain")
public class ReportFilmsWeeklyGainEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column(name = "film_id")
    Integer filmId;

    @Column(name = "weekly_gain")
    Double weeklyGain;
}