import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Logger;


// Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

public class Task2 {
    public static void main(String[] args) throws IOException {
    
        Logger logger = Logger.getLogger(Task2.class.getName());
        FileHandler fileHandler = new FileHandler("HW-2-Java/test.log", true);
        logger.addHandler(fileHandler);
        
        int[] data = new int[20];
        for (int i = 0; i < data.length; i++) {
            Random rand = new Random();
            data[i] = rand.nextInt(100);
        }
        System.out.printf("Вывод массива: %s\n", Arrays.toString(data));
        
        int i = 0;
        boolean flag = true;
        while (i < data.length - 1) {
            flag = false;
            for (int j = 1; j < data.length - i; j++) {
                if (data[j - 1] > data[j]) {
                    int temp = data[j - 1];
                    data[j - 1] = data[j];
                    data[j] = temp;
                    logger.log(java.util.logging.Level.INFO, "Hello logging: {0}", temp);
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
            i++;
        }

        System.out.printf("Вывод отсортированного массива: %s\n", Arrays.toString(data));
    }
}