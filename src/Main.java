import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String answer = "да";
        while (answer.equals("да")) {
            System.out.print("Введите колличество строк первого списка: ");
            int i = Integer.parseInt(reader.readLine());
            System.out.println("Введите строки: ");

            ArrayList<List> allArrays1 = new ArrayList<>();
            insertWords(allArrays1, i, reader);

            System.out.print("Введите колличество строк второго списка: ");
            int j = Integer.parseInt(reader.readLine());
            System.out.println("Введите строки: ");

            ArrayList<List> allArrays2 = new ArrayList<>();
            insertWords(allArrays2, j, reader);


            if (allArrays1.size() < allArrays2.size()) {
                List<String> list = splitString(allArrays2, allArrays1);
                for (String s : list) {
                    System.out.println(s);
                }
            } else {
                List<String> list = splitString(allArrays1, allArrays2);
                for (String s : list) {
                    System.out.println(s);
                }
            }


            do {
                System.out.print("Хотите продолжить? [да/нет]: ");
                answer = reader.readLine();
            } while (!answer.equals("да") && !answer.equals("нет"));
        }
    }

    public static List<String> splitString(ArrayList<List> list1, ArrayList<List> list2) {
        List<String> compareList = new ArrayList<>();
        for (int i = 0; i < list1.size(); ) {
            int j = 0;
            while (j < list2.size()) {
                if (compare(list1.get(i), list2.get(j))) {
                    compareList.add(list1.get(i) + ":" + list2.get(j));
                    list1.remove(list1.get(i));
                    list2.remove(list2.get(j));
                    j = 0;
                } else {
                    j++;
                }
            }
            if (j == list2.size() && !list1.isEmpty()) {
                compareList.add(list1.get(i) + ":?");
                list1.remove(list1.get(i));
            }
        }
        return compareList;
    }

    public static boolean compare(List<String> list1, List<String> list2) {
        boolean bool = false;
        for (int i = 0; i < list1.size(); i++) {
            for (String s : list2) {
                if (list1.get(i).equals(s)) {
                    bool = true;
                    i = list1.size();
                    break;
                }
            }
        }
        return bool;
    }

    public static void insertWords(ArrayList<List> allArrays, int i, BufferedReader reader) throws IOException {
        for (int q = 0; q < i; q++) {
            String word = reader.readLine();
            String[] list1 = word.split(" ");
            ArrayList<String> list = new ArrayList<>(Arrays.asList(list1));
            allArrays.add(list);
        }
    }
}
