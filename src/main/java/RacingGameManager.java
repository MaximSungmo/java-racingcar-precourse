import java.util.*;

public class RacingGameManager {

    private static final Scanner scanner = new Scanner(System.in);

    private int laps = 0;
    private String rawCarNameList;
    private CarList carList = new CarList();

    public void start() {
        userInit();
        setRacingCars();
        repeatLaps();
        judge();
    }

    private void judge() {
        Set<Integer> positionSet = new HashSet<>();
        for (Car car : carList.getCarList()) {
            positionSet.add(car.getPosition());
        }
        int maxPosition = Collections.max(positionSet);

        CarList winner = new CarList();

        for (Car car : carList.getCarList()) {
            if (car.getPosition() == maxPosition) {
                winner.getCarList().add(car);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Car winnerCar : winner.getCarList()) {
            sb.append(winnerCar.getCarName());
            sb.append(",");
        }

        System.out.println(String.format("%s가 최종 우승했습니다.", sb.toString()));
    }

    private void setRacingCars() {
        carList.setCarList(rawCarNameList);
    }

    private void userInit() {
        System.out.println(GameMessage.INSERT_CAR_NAME_BY_USER.getMessage());
        rawCarNameList = scanner.nextLine();
        System.out.println(GameMessage.INSERT_LAPS.getMessage());
        laps = scanner.nextInt();
    }

    private void racing(CarList carList) {
        PowerStation powerStation = new PowerStation();
        for (Car car : carList.getCarList()) {
            car.move(powerStation.getPower());
            car.printPosition();
        }
    }

    private void repeatLaps() {
        for (int i = 0; i < laps; i++) {
            racing(carList);
            System.out.println("");
        }
    }
}
