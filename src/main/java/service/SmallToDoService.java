package service;

import model.SmallToDo;
import repositories.SmallToDoListRepository;
import java.util.Collection;

public class SmallToDoService {

    private SmallToDoListRepository toDoListRepository = new SmallToDoListRepository();

    public Collection<SmallToDo> getUsersToDoList(String username) {
        return toDoListRepository.getToDoes(username);

    }
}
