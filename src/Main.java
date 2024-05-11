import java.util.Scanner;

class Main {
    public static String calc(String input) {
        // Разбиваем строку на части: первый аргумент, оператор, второй аргумент
        String [] parts = input.split(" ");
        // Проверяем корректность формата ввода
        if (parts.length != 3) {
            throw new IllegalArgumentException("Не верное количество аргументов!");
        }

        int arg1 = 0;
        int arg2 = 0;
        int result = 0;
        boolean isRoman = false; // Флаг для определения типа чисел

        // Пробуем преобразовать строки в арабские числа
        try {
            arg1 = Integer.parseInt(parts[0]);
            arg2 = Integer.parseInt(parts[2]);
        } catch (NumberFormatException err) {
            //Если преобразование не удалось, пробуем преобразовать в римские числа
            try {
                arg1 = RomanNumerals.valueOf(parts[0]).getValue();
                arg2 = RomanNumerals.valueOf(parts[2]).getValue();
                isRoman = true;
            } catch (IllegalArgumentException ex) {
                // Если не удалось выбрасываем исключение
                throw new IllegalArgumentException("Неверное число!");
            }
        }
        // Проверяем диапазон чисел
        if (arg1 < 1 || arg1 > 10 || arg2 < 1 || arg2 > 10) {
            throw new IllegalArgumentException("Число должно быть в диапазоне от 1 до 10!");
        }
        // Выполнение арифмитической операции в зависимости от оператора
        result = switch (parts[1]) {
            case "+" -> arg1 + arg2;
            case "-" -> arg1 - arg2;
            case "*" -> arg1 * arg2;
            case "/" -> arg1 / arg2;
            // Если оператор не распознан, выбрасываем исключение
            default -> throw new IllegalArgumentException("Неверный математический оператор!");
        };

        // Возвращаем результат в соответствии с форматом
        if (isRoman) {
            // Для римских чисел результат должен быть только положительным
            if (result < 1) {
                throw new IllegalArgumentException("Результат выражения должен быть больше 0!");
            }
            return RomanNumerals.toRoman(result);
        } else { // Для арабских чисел просто преобразуем в строку
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
