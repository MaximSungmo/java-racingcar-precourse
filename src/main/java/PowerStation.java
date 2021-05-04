public class PowerStation {
    public int getPower() {
        return (int) (Math.random() * (GameRule.MAXIMUM_POWER - GameRule.MINIMUM_POWER + 1) - 1);
    }
}
