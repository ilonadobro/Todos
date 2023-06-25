import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchMatchesTest() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить яйца");
        SimpleTask simpleTask2 = new SimpleTask(6, "Купить Яйца");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(simpleTask2);
        todos.add(epic);
        todos.add(meeting);

        Task[] actual = todos.search("Яйца");
        Task[] actual2 = todos.search("Картофель");
        Task[] expected = {simpleTask2, epic};
        Assertions.assertArrayEquals(expected, actual);
        Assertions.assertArrayEquals(new Task[0], actual2);

        Task[] actual3 = todos.search("приложения");
        Task[] expected3 = {meeting};
        Assertions.assertArrayEquals(expected3, actual3);

        Task[] actual4 = todos.search("НетоБанка");
        Task[] expected4 = {meeting};
        Assertions.assertArrayEquals(expected4, actual4);

    }

    @Test
    public void simpleTaskGetTitleTest() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить яйца");

        String expected = "Купить яйца";
        String actual = simpleTask.getTitle();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void epicTaskGetSubtasksTest() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        String[] actual = epic.getSubtasks();
        Assertions.assertEquals(subtasks, actual);
    }

    @Test
    public void meetingTaskGetTopicTest() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        String expected = "Выкатка 3й версии приложения";
        String actual = meeting.getTopic();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void meetingTaskGetTopicProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        String expected = "Приложение НетоБанка";
        String actual = meeting.getProject();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void meetingTaskGetTopicStartTest() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        String expected = "Во вторник после обеда";
        String actual = meeting.getStart();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void taskGetIdTest() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить яйца");

        int expected = 5;
        int actual = simpleTask.getId();
        Assertions.assertEquals(expected, actual);
    }

}
