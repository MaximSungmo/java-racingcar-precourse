public enum Message {

    INVALID_CAR_NAME("자동차 이름은 " + Car.CAR_NAME_LENGTH_CONSTRAINT + "자 이하만 가능합니다."),
    INVALID_MOVE_PARAMETER(String.format("자동차 움직임에 필요한 동력은 %s ~ %s 입니다.", GameRule.MINIMUM_POWER, GameRule.MAXIMUM_POWER));

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
