package repositories;

import model.SmallToDo;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SmallToDoListRepository {
    private static final String FILE_POSTFIX = "todo.txt";
    private static String FILE_PATH = "C:\\Users\\Admin\\IdeaProjects\\SmallToDoList\\tododata\\";

    public List<SmallToDo> getToDoes(String username) {
        List<SmallToDo> items = new ArrayList<>();
        String filePath = getToDoFilePathByUserName(username);
        try (Scanner scanner = new Scanner(new FileInputStream(filePath))) {
            long iteamsCount = scanner.nextLong();
            extractToDoFromScanner(items, scanner, iteamsCount);
        } catch (FileNotFoundException exception) {
            System.out.println(exception);
        }
        return items;
    }

    private void extractToDoFromScanner(List<SmallToDo> items, Scanner scanner, long iteamsCount) {
        for (long iteamNumber = 0; iteamNumber < iteamsCount; iteamNumber++) {
            Long id = scanner.nextLong();
            scanner.nextLine();
            String comment = scanner.nextLine();
            String isDone = scanner.nextLine();
            items.add(new SmallToDo(id, Boolean.valueOf(isDone), comment));
        }
    }

    private static String getToDoFilePathByUserName(String username) {
        return FILE_PATH + username + FILE_POSTFIX;

    }
}
