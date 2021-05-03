import java.util.Scanner;

public class RacingGameManager {

    private static final Scanner scanner = new Scanner(System.in);

    private int laps = 0;
    private String rawCarNameList;

    public void start() {
        userInit();
    }

    private void userInit() {
        System.out.println(GameMessage.INSERT_CAR_NAME_BY_USER.getMessage());
        rawCarNameList = scanner.nextLine();
        System.out.println(GameMessage.INSERT_LAPS.getMessage());
        laps = scanner.nextInt();
    }
}
