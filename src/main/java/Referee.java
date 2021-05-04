import java.util.*;

public class Referee {

    private CarList carList;
    private int laps;
    private List<String> winners;

    public Referee(CarList carList, int laps) {
        this.carList = carList;
        this.laps = laps;
    }

    public void judge() {
        Set<Integer> positionSet = new HashSet<>();
        for (Car car : carList.getCarList()) {
            positionSet.add(car.getPosition());
        }
        int maxPosition = Collections.max(positionSet);

        winners = new ArrayList<>();

        for (Car car : carList.getCarList()) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getCarName());
            }
        }
    }

    public List<String> getWinners() {
        return winners;
    }
}
