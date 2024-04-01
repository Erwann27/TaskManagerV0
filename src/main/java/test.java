import Director.XMLToDoListLoader;
import ToDoList.Task;
import ToDoList.ToDoList;
import ToDoList.ToDoListBuilder;
import ToDoList.ToDoListBuilderStd;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class test {

    public static void main(String[] args) {
        ToDoListBuilder builder = new ToDoListBuilderStd();
        try {
            File f = new File(".");
            XMLToDoListLoader.load(f.getAbsolutePath() + "/TaskManager/xml/toDoList.xml", builder);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
         ToDoList list = builder.createToDoList();
        for (Task task : list.getTasks()) {
            System.out.println(task.getDeadline());
            System.out.println(task.getDescription());
            System.out.println(task.getPriority());
            System.out.println(task.getEstimatedTimeInDays());
            System.out.println(task.getProgress());
        }
    }
}
