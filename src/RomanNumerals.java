// Создаем перечисление для ассоциации римских и арабских чисел
enum RomanNumerals {
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

    // Создаем конструктор перечисления
    RomanNumerals(int value) {
        this.value = value;
    }

    // Получаем значение перечисления
    public int getValue() {
        return value;
    }

    // Метод для преоброзования арабского числа в римское
    public static String toRoman(int num) {
        // Проверка диапазона
        if (num < 1 || num > 10) {
            throw new IllegalArgumentException("Число должно быть в диапазоне от 1 до 10!");
        }

        // Перебираем значения перечисления для нахождения соответствия
        RomanNumerals [] values = RomanNumerals.values();
        for (int i = values.length - 1; i >= 0; i--) {
            if (num >= values[i].getValue()) {
                return values[i].toString();
            }
        }
        return null;
    }
}
