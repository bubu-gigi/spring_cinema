package swapi.app.domain.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tickets")

@Entity
public class TicketEntity {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Double price;

    @Column(name = "percentage_increase")
    private Integer percentageIncrease;

    @Column(columnDefinition = "integer default 0", name = "daily_sold")
    @JsonIgnore
    private Integer dailySold;

    @Column(columnDefinition = "integer default 0", name = "weekly_sold")
    @JsonIgnore
    private Integer weeklySold;

    @Column(columnDefinition = "integer default 0", name = "monthly_sold")
    @JsonIgnore
    private Integer monthlySold;

    @Column(columnDefinition = "integer default 0", name = "tot_sold")
    @JsonIgnore
    private Integer totSold;

    @Column(name = "film_id")
    private Integer filmId;

    @Column(name = "hall_id")
    private Integer hallId;
}
