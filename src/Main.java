import java.util.Random;
import java.util.Arrays; // Добавлен импорт

//aaaaaaaaaaaaaaaaaaaaaaaaaa
class Tovar {
    private int id;
    private String name;
    private int price;
    private int quantity;
    private int expirationDate;
    private int category;

    public Tovar(int id, String name, int price, int quantity, int expirationDate, int category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
        this.category = category;
    }

    public int getId(){
        return id;
    }
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getExpirationDate() {
        return expirationDate;
    }

    public int getCategory() {
        return category;
    }

    // Метод для генерации случайного товара
    public static Tovar generateRandomTovar() {
        Random random = new Random();
        String[] categories = {"Еда", "Одежда", "Электроника", "Книги", "Бытовая техника"};
        int id = random.nextInt(1000) + 1;
        String name = "Товар " + id;
        int price = random.nextInt(1000) + 1;    // случайная цена от 1 до 1000
        int quantity = random.nextInt(1000) + 1;   // случайное количество от 1 до 1000
        int expirationDate = random.nextInt(365) + 1; // случайный срок годности от 1 до 365 дней
        int category = random.nextInt(categories.length);
        return new Tovar(id, name, price, quantity, expirationDate, category);
    }

    @Override
    public String toString() {
        return "Название: " + name + " | Цена: " + price + " | Количество: " + quantity +
                " | Срок годности (дней): " + expirationDate + " | Категория: " + category;
    }

    // Статические методы анализа для выбранного столбца параметров товаров
    //*********************************************************************
    public static int min(int[] numbers) {
        int min = numbers[0];
        for (int num : numbers) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    public static int max(int[] numbers) {
        int max_ = numbers[0];
        for (int num : numbers) {
            if (num > max_) {
                max_ = num;
            }
        }
        return max_;
    }

    public static double average(int[] numbers) {
        int sum = Arrays.stream(numbers).sum();
        return (double) sum / numbers.length;
    }

    public static double median(int[] numbers) {
        Arrays.sort(numbers);
        int middle = numbers.length / 2;
        if (numbers.length % 2 == 0) {
            return (double) (numbers[middle - 1] + numbers[middle]) / 2;
        } else {
            return numbers[middle];
        }
    }

    public static int mode(int[] numbers) {
        // Создаем массив для подсчета количества вхождений каждого числа
        int[] frequency = new int[1001]; // Предполагаем, что числа в массиве могут быть от 0 до 1000

        // Заполняем массив частот
        for (int number : numbers) {
            frequency[number]++;
        }

        // Находим моду (число с наибольшим количеством вхождений)
        int mode = 0;
        int maxFrequency = 0;
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > maxFrequency) {
                mode = i;
                maxFrequency = frequency[i];
            }
        }

        // Выводим результат
        System.out.print("мода массива: " + mode);
        return maxFrequency;
    }

    public static double standardDeviation(int[] numbers) {
        double mean = average(numbers);
        double sumOfSquaredDifferences = 0;
        for (int num : numbers) {
            sumOfSquaredDifferences += Math.pow(num - mean, 2);
        }
        return Math.sqrt(sumOfSquaredDifferences / numbers.length);
    }


    public static boolean isSymmetric(int[] numbers) {
        double median = median(numbers);
        double mean = average(numbers);
        double standardDeviation = standardDeviation(numbers);

        double difference = Math.abs(median - mean);

        // Проверяем, насколько разница между медианой и средним близка к стандартному отклонению
        return difference <= 3 * Math.sqrt(Math.pow(standardDeviation, 2) / numbers.length);
    }


    public static double calculateCorrelationCoefficient(int[] numbers1, double mean1, int[] numbers2, double mean2) {
        double numerator = 0;
        double denominator1 = 0;
        double denominator2 = 0;

        for (int i = 0; i < numbers1.length; i++)
        {
            numerator += (numbers1[i] - mean1) * (numbers2[i] - mean2);
            denominator1 += Math.pow(numbers1[i] - mean1, 2);
            denominator2 += Math.pow(numbers2[i] - mean2, 2);
        }

        return numerator / (Math.sqrt(denominator1) * Math.sqrt(denominator2));
    }
}

public class Main {
    public static void main(String[] args) {
        // Создаем 200 случайных товаров
        Tovar[] tovars = new Tovar[200];
        for (int i = 0; i < 200; i++)
        {
            tovars[i] = Tovar.generateRandomTovar();
        }

        // Выводим информацию о каждом товаре
        for (Tovar tovar : tovars)
        {
            System.out.println(tovar);
        }

        // Получаем массив цен товаров
        int[] prices = new int[tovars.length];
        for (int i = 0; i < tovars.length; i++) {
            prices[i] = tovars[i].getPrice();
        }

        // Получаем массив количества товаров
        int[] quantity = new int[tovars.length];
        for (int i = 0; i < tovars.length; i++) {
            quantity[i] = tovars[i].getQuantity();
        }

        // Получаем массив сроков годности товаров
        int[] expirationDate = new int[tovars.length];
        for (int i = 0; i < tovars.length; i++) {
            expirationDate[i] = tovars[i].getExpirationDate();
        }

        // Получаем массив категорий товаров
        int[] category = new int[tovars.length];
        for (int i = 0; i < tovars.length; i++) {
            category[i] = tovars[i].getCategory();
        }

        // Получаем массив id товаров
        int[] id = new int[tovars.length];
        for (int i = 0; i < tovars.length; i++) {
            id[i] = tovars[i].getId();
        }

        // Пример использования методов анализа
        System.out.println("Минимальная цена: " + Tovar.min(prices));
        System.out.println("Максимальная цена: " + Tovar.max(prices));
        System.out.println("Средняя цена: " + Tovar.average(prices));
        System.out.println("Медиана цены: " + Tovar.median(prices));
        System.out.println(" мода количества: " + Tovar.mode(quantity));
        System.out.println("Стандартное отклонение цены: " + Tovar.standardDeviation(prices));
        System.out.println("Симметричные выборки: " + Tovar.isSymmetric(prices));

// Находим среднее значение для каждого массива
        double prices_av = Tovar.average(prices);
        double quantity_av = Tovar.average(quantity);
        double expirationDate_av = Tovar.average(expirationDate);
        double category_av = Tovar.average(category);
        double id_av = Tovar.average(id);

        // Находим коэффициент корреляции между всеми парами характеристик
        System.out.println("Коэффициенты корреляции:");
        System.out.println("id - prices: " + Tovar.calculateCorrelationCoefficient(id, id_av, prices, prices_av));
        System.out.println("id - quantity: " + Tovar.calculateCorrelationCoefficient(id, id_av, quantity, quantity_av));
        System.out.println("id - expirationDate: " + Tovar.calculateCorrelationCoefficient(id, id_av, expirationDate, expirationDate_av));
        System.out.println("id - category: " + Tovar.calculateCorrelationCoefficient(id, id_av, category, category_av));
        System.out.println("prices - quantity: " + Tovar.calculateCorrelationCoefficient(prices, prices_av, quantity, quantity_av));
        System.out.println("prices - expirationDate: " + Tovar.calculateCorrelationCoefficient(prices, prices_av, expirationDate, expirationDate_av));
        System.out.println("prices - category: " + Tovar.calculateCorrelationCoefficient(prices, prices_av, category, category_av));
        System.out.println("quantity - expirationDate: " + Tovar.calculateCorrelationCoefficient(quantity, quantity_av, expirationDate, expirationDate_av));
        System.out.println("quantity - category: " + Tovar.calculateCorrelationCoefficient(quantity, quantity_av, category, category_av));
        System.out.println("expirationDate - category: " + Tovar.calculateCorrelationCoefficient(expirationDate, expirationDate_av, category, category_av));


    }
}
