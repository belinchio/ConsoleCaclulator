public enum RomanNumerals {
    I   (1),
    II  (2),
    III (3),
    IV  (4),
    V   (5),
    VI  (6),
    VII (7),
    VIII(8),
    IX  (9),
    X   (10);

    private final int value;

    RomanNumerals(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static String toRoman(int num) {
        if (num < 1 || num > 10) {
            throw new IllegalArgumentException("Число должно быть в диапазоне от 1 до 10!");
        }

        RomanNumerals [] values = RomanNumerals.values();
        for (int i = values.length - 1; i >= 0; i--) {
            if (num >= values[i].getValue()) {
                return values[i].toString();
            }
        }
        return null;
    }
}
