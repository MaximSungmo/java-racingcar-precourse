import java.util.ArrayList;
import java.util.List;

public class CarList {

    private List<Car> carList = new ArrayList<>();

    public void setCarList(String carStringList) {
        if (!validationCarList(carStringList)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_LIST_STRING.getMessage());
        }
        String[] cars = carStringList.split(",");
        for (String car : cars) {
            carList.add(new Car(car));
        }
    }

    private boolean validationCarList(String carList) {
        return carList.contains(",");
    }

    public List<Car> getCarList() {
        return carList;
    }
}
