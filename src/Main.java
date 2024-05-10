import java.util.Scanner;

class Main {
    public static String calc(String input) {
        String [] parts = input.split(" ");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Не верное количество аргументов!");
        }
        int arg1 = 0;
        int arg2 = 0;
        int result = 0;
        boolean isRoman = false;

        try {
            arg1 = Integer.parseInt(parts[0]);
            arg2 = Integer.parseInt(parts[2]);
        } catch (NumberFormatException err) {
            try {
                arg1 = RomanNumerals.valueOf(parts[0]).getValue();
                arg2 = RomanNumerals.valueOf(parts[2]).getValue();
                isRoman = true;
            } catch (IllegalArgumentException ex) {
                throw new IllegalArgumentException("Неверное число!");
            }
        }
        if (arg1 < 1 || arg1 > 10 || arg2 < 1 || arg2 > 10) {
            throw new IllegalArgumentException("Число должно быть в диапазоне от 1 до 10!");
        }
        result = switch (parts[1]) {
            case "+" -> arg1 + arg2;
            case "-" -> arg1 - arg2;
            case "*" -> arg1 * arg2;
            case "/" -> arg1 / arg2;
            default -> throw new IllegalArgumentException("Неверный математический оператор!");
        };

        if (isRoman) {
            if (result < 1) {
                throw new IllegalArgumentException("Результат выражения должен быть больше 0!");
            }
            return RomanNumerals.toRoman(result);
        } else {
            return String.valueOf(result);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите арефмитическое выражение через пробел (например: x + y):");
        String input = scanner.nextLine();

        try {
            System.out.println(calc(input));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        scanner.close();
    }
}
