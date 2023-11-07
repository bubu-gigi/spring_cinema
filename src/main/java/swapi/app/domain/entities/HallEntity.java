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
@Table(name = "halls")

@Entity
public class HallEntity {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @Column(name = "base_seats")
    private Integer baseSeats;

    @Column(name = "sold_base_seats")
    @Value("${props.sold_base_seats: 0}")
    @JsonIgnore
    private Integer soldBaseSeats;

    @Column(name = "vip_seats")
    private Integer vipSeats;

    @Column(name = "sold_vip_seats")
    @Value("${props.sold_vip_seats: 0}")
    @JsonIgnore
    private Integer soldVipSeats;

    @Column(name = "film_id")
    private Integer filmId;

}
