package swapi.app.schedulers;


import org.springframework.scheduling.annotation.Scheduled;
import swapi.app.services.HallService;

public class HallScheduler {

    private final HallService hallService;

    public HallScheduler(HallService hallService) {
        this.hallService = hallService;
    }

    @Scheduled(cron = "0 0 4 * * ?")
    public void resetSoldSeats() {
        this.hallService.resetBaseSeats();
        this.hallService.resetVipSeats();
    }

}
