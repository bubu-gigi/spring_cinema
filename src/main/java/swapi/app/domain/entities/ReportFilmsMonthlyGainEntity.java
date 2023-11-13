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
@Table(name = "report_films_mothly_gain")
public class ReportFilmsMonthlyGainEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column(name = "film_id")
    Integer filmId;

    @Column(name = "monthly_gain")
    Double monthlyGain;
}