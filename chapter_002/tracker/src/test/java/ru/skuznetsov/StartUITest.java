package ru.skuznetsov;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

/**
 * Created by Sergey on 06.12.2016.
 */
public class StartUITest {

    /**
     * Create start ui instance, create task and equal result of creation task with expected.
     * */
    @Test
    public void mainMethodTestAddTask() {
        StartUI startUI = new StartUI("1\n7");
        startUI.main(new String[]{"task1\ndesc1"});
        Task task = StartUI.getTestTask();
        String id = task.getId();
        assertThat(new Task(id, "task1", "desc1"), equalTo(task));
    }
    /**
     * Create start ui instance, create task, edit task and equal result of editing task with expected.
     * */
    @Test
    public void mainMethodTestEditTask() {
        StartUI startUI = new StartUI("1\n2\n7");
        startUI.main(new String[]{"task1\ndesc1\ntask1\ntask123\nnew description"});
        Task task = StartUI.getTracker().getTaskManager().getTestTask();
        String id = task.getId();
        assertThat(new Task(id, "task123", "new description"), is(task));
    }
    /**
     * Create start ui instance, create 2 task, remove task, equal final array with expected.
     *
     * */
    @Test
    public void mainMethodTestRemovingTask() {
        StartUI startUI = new StartUI("1\n1\n3\n7");
        startUI.main(new String[]{"task1\ndesc1\ntask2\ndesc2\ntask1"});
        Task[] tasks = StartUI.getTracker().getTaskManager().getAllTasks();

        assertThat(new Task[]{new Task("task2", "desc2")}, equalTo(tasks));
    }
    /**
     * Create start ui instance, create 2 task, enter name of task to get details.
     * */
    @Test
    public void mainMethodTestGetTaskByName() {
        StartUI startUI = new StartUI("1\n1\n5\n7");
        startUI.main(new String[]{"task1\ndesc1\ntask2\ndesc2\ntask2"});
        Task task = StartUI.getTestTask();

        assertThat(new Task("task2", "desc2"), is(task));
    }
    /**
     * Create start ui instance, create 2 task, add comment to task and check added comment with expected.
     * */
    @Test
    public void mainMethodTestAddCommentToTask() {
        StartUI startUI = new StartUI("1\n1\n4\n6\n7");
        startUI.main(new String[]{"task1\ndesc1\ntask2\ndesc2\ntask2\ncomment of task2"});
        Comment comment = StartUI.getTestTask().getComments()[0];

        assertThat(new Comment("comment of task2"), equalTo(comment));
    }

}
