package repositories;

import model.User;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserRepository {

    private static String FILE_PATH = "C:\\Users\\Admin\\IdeaProjects\\SmallToDoList\\tododata\\credentials.txt";

    public List<User> getUsers() {
        List<User> items = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream(FILE_PATH))) {
            long iteamsCount = scanner.nextLong();
            extractUserFromScanner(items, scanner, iteamsCount);
        } catch (FileNotFoundException exception) {
            System.out.println(exception);
        }
        return items;
    }

    private void extractUserFromScanner(List<User> items, Scanner scanner, long iteamsCount) {
        for (long iteamNumber = 0; iteamNumber < iteamsCount; iteamNumber++) {
            Long id = scanner.nextLong();
            scanner.nextLine();
            String login = scanner.nextLine();
            String password = scanner.nextLine();
            items.add(new User(id, login, password));
        }
    }

}
