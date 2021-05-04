import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class GameWinner {

    private String winner;

    public void judgeWinners(CarList carList) {
        List<Car> winnerList = new ArrayList<>();
        AtomicInteger maxPosition = new AtomicInteger();
        carList.getCarList().forEach(car -> {
            int currentPosition = car.getPosition();
            if (maxPosition.get() < currentPosition) {
                winnerList.clear();
                winnerList.add(car);
                maxPosition.set(currentPosition);
            }
        });

    }
}
