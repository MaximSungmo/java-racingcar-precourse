import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    private final int START_POSITION = 0;
    private final int MOVE = START_POSITION + 1;
    private final int STOP = START_POSITION;

    @DisplayName("자동차 생성 - 성공 테스트")
    @ValueSource(strings = {"1", "12345", "a", "abcde", "가", "가나다라마"})
    @ParameterizedTest
    void createCar_successTest(String carName) {
        Car car = new Car(carName);

        assertEquals(carName, car.getCarName());
        assertEquals(car.getPosition(), START_POSITION);
    }

    @DisplayName("자동차 생성 - 실패 테스트(자동차 이름 5자 초과)")
    @ValueSource(strings = {"123456", "abcdefg", "가나다라마바"})
    @ParameterizedTest
    void createCar_failedByNameConstraintTest(String carName) {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            Car car = new Car(carName);
        });

        assertEquals(exception.getMessage(), ErrorMessage.INVALID_CAR_NAME.getMessage());
    }

    @DisplayName("자동차 전진 - 성공 테스트")
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    @ParameterizedTest
    void moveCar_successTest(int power) {
        Car car = new Car("테스트차량");
        car.move(power);
        int currentPostion = car.getPosition();
        if (power < GameRule.MOVE_THRESHOLD) {
            assertEquals(currentPostion, STOP);
            return;
        }
        assertEquals(car.getPosition(), MOVE);
    }

    @DisplayName("자동차 전진 - 실패 테스트(예기치 않은 파라미터)")
    @ValueSource(ints = {GameRule.MINIMUM_POWER - 1, GameRule.MAXIMUM_POWER + 1})
    @ParameterizedTest
    void moveCar_failedByUnexpectedParameterTest(int power) {
        Car car = new Car("테스트차량");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> car.move(power));

        assertEquals(exception.getMessage(), ErrorMessage.INVALID_MOVE_PARAMETER.getMessage());
    }
}
