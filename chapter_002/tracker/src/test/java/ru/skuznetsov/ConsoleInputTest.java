package ru.skuznetsov;

import org.junit.Assert;
import org.junit.Test;
import ru.skuznetsov.input.ConsoleInput;

/**
 * Created by Sergey on 06.12.2016.
 */
public class ConsoleInputTest {
    /**
     * Add task and equal result with expected.
     * */
    @Test
    public void ifAddTaskCountOfTasksIncrease() {
        final int expectedCount = 1;
        ConsoleInput input = new ConsoleInput("task1\ndescription1");
        input.addTask();
        Assert.assertEquals(expectedCount, input.getAllTasks().length);
    }
    /**
     *  Remove task ans check count of result with expected.
     * */
    @Test
    public void ifRemoveTaskThanCountChanges() {
        final int expected = 1;
        ConsoleInput tracker = new ConsoleInput("task1\ndescription1\ntask2\ndescription2\ntask1");
        tracker.addTask();
        tracker.addTask();
        tracker.removeTask();
        Assert.assertEquals(expected, tracker.getAllTasks().length);
    }

    /**
     * Add task and check result with expected.
     * */
    @Test
    public void ifAddTaskThenEqualsExpectedTasks() {
        ConsoleInput tracker = new ConsoleInput("task1\ndesc1\ntask2\ndesc2");

        tracker.addTask();
        tracker.addTask();
        Assert.assertArrayEquals(new Task[]{new Task("task1", "desc1"),
                        new Task("task2", "desc2")}, tracker.getAllTasks());
    }

    /**
     * Check count of comments after adding new comment.
     * */
    @Test
    public void thenAddCommentThanCountOfCommentsWillIncrease() {
        final int expected = 1;
        ConsoleInput tracker = new ConsoleInput("task1\ndesc1\ntask1\ncomment of task1");

        tracker.addTask();
        Task task = tracker.addCommentToTask();
        Comment[] comments = task.getComments();
        Assert.assertEquals(expected, comments.length);
    }
    /**
     * Add comment and compare result with expected.
     * */
    @Test
    public void thenAddCommentThanCompareExpectedResult() {
        ConsoleInput tracker = new ConsoleInput("task1\ndesc1\ntask1\ncomment of task1");
        tracker.addTask();
        Task task = tracker.addCommentToTask();
        String id = task.getId();
        Assert.assertEquals(new Task(id, "task1", "desc1", new Comment("comment of task1")),
                tracker.getTaskByName("task1"));
    }
    /**
     * Add comment and check description of it.
     * */
    @Test
    public void ifAddCommentCheckAddedComment() {
        ConsoleInput tracker = new ConsoleInput("task1\ndesc1\ntask1\ncomment of task1");
        tracker.addTask();
        tracker.addCommentToTask();

        Assert.assertEquals("comment of task1", tracker.getTaskByName("task1").getComments()[0].getDescription());
    }
    /**
     * Equal new comment with expected.
     * */
    @Test
    public void ifAddCommentCheckAddedCommentOnEquals() {
        ConsoleInput tracker = new ConsoleInput("task1\ndesc1\ntask1\ncomment of task1");
        tracker.addTask();
        String id = tracker.getTaskByName("task1").getId();
        tracker.addCommentToTask();
        Assert.assertEquals((new Task(id, "task1", "desc1",
                new Comment("comment of task1"))).getComments()[0],
                tracker.getTaskByName("task1").getComments()[0]);
    }

    /**
     * Add task, edit it and compare result with expected.
     * */
    @Test
    public void ifEditTaskByNameThenResultEqualsWithExpected() {
        ConsoleInput tracker = new ConsoleInput("task1\ndesc1\ntask1\ntask999\nnew description");
        tracker.addTask();
        String id = tracker.getTaskByName("task1").getId();
        tracker.editTaskByName();
        Assert.assertEquals(new Task(id, "task999", "new description"), tracker.getAllTasks()[0]);
    }
    /**
     * Add task to tracker, add comment and compare description of comment with expected.
     * */
    @Test
    public void ifAddTaskAndSetDescriptionCompareItWithExpected() {
        ConsoleInput tracker = new ConsoleInput("task1\ndesc1\ntask1\ncomment info");
        tracker.addTask();
        String id = tracker.getTaskByName("task1").getId();
        tracker.addCommentToTask();
        tracker.getAllTasks()[0].getComments()[0].setDescription("new comment");
        Assert.assertEquals("new comment", tracker.getAllTasks()[0].getComments()[0].getDescription());
    }
    /**
     * Add extra comment to task, check total counts of comments.
     * */
    @Test
    public void ifAddCommentToTaskWhereWasCommentThenCompareExpectedWithFactedCountOfComments() {
        ConsoleInput tracker = new ConsoleInput("task1\ndesc1\ntask1\ncomment info\ntask1\ncomment info");
        tracker.addTask();
        tracker.addCommentToTask();
        tracker.addCommentToTask();
        Assert.assertEquals(2, tracker.getAllTasks()[0].getComments().length);
    }
    /**
     * Add extra comment, compare description of new comment with expected.
     * */
    @Test
    public void ifAddCommentToTaskWhereWasCommentThenCompareExpectedWithFactedComment() {
        ConsoleInput tracker = new ConsoleInput("task1\ndesc1\ntask1\ncomment info\ntask1\ncomment info");
        tracker.addTask();
        tracker.addCommentToTask();
        tracker.addCommentToTask();
        Assert.assertEquals("comment info", tracker.getAllTasks()[0].getComments()[0].getDescription());
        Assert.assertEquals("comment info", tracker.getAllTasks()[0].getComments()[1].getDescription());
    }
}
