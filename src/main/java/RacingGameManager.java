import java.util.*;

public class RacingGameManager {

    private static final Scanner scanner = new Scanner(System.in);

    private int laps = 0;
    private String rawCarNameList;

    public void start() {
        // 경기 등록
        userInit();
        // 선수 입장
        CarList carList = new CarList(rawCarNameList);
        // 게임 시작
        repeatLaps(carList);
        // 결과 판독
        Referee referee = new Referee(carList, laps);
        referee.judge();
        List<String> winners = referee.getWinners();
        // 결과 출력
        String winnerString = StringUtils.join(winners, ",");
        System.out.println(String.format("%s 가 최종 우승했습니다.", winnerString));
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

    private void repeatLaps(CarList carList) {
        for (int i = 0; i < laps; i++) {
            racing(carList);
            System.out.println("");
        }
    }
}
