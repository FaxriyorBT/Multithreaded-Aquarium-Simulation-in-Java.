import java.util.Random;

public enum Gender {
    MALE,
    FEMALE;

    private static final Random random = new Random();

    public static Gender getRandomGender() {
        Gender[] values = values();
        return values[random.nextInt(values.length)];
    }
}
