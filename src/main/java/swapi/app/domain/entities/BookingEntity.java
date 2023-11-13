package swapi.app.domain.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "bookings")
@Entity
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Integer id;

    @Column(name = "film_id")
    private Integer filmId;

    @Column(name = "hall_id")
    private Integer hallId;

    @Column(name = "is_vip")
    private Boolean isVip;
}
