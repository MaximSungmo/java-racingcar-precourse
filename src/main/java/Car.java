public class Car {

    public static final int CAR_NAME_LENGTH_CONSTRAINT = 5;
    private String carName;
    private int position = 0;

    public Car(String carName) {
        setCarName(carName);
        this.position = 0;
    }

    public void move(int power) {
        if (power < GameRule.MINIMUM_POWER || power > GameRule.MAXIMUM_POWER) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MOVE_PARAMETER.getMessage());
        }

        if (power >= GameRule.MOVE_THRESHOLD) {
            position++;
        }
    }

    private boolean validateCarName(String carName) {
        if ("".equals(carName)) {
            return false;
        }

        if (carName.length() > CAR_NAME_LENGTH_CONSTRAINT) {
            return false;
        }

        return true;
    }

    public void setCarName(String carName) {
        if (!validateCarName(carName)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME.getMessage());
        }
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public String printPosition() {
        StringBuilder sb = new StringBuilder();
        sb.append("-");
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        return String.format("%s : %s", carName, sb.toString());
    }
}
