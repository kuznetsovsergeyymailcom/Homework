package ru.skuznetsov;

import org.junit.Assert;
import org.junit.Test;
import ru.skuznetsov.input.StubInput;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by Sergey on 06.12.2016.
 */
public class StubInputTest {
    /**
     * Add task and equal result with expected.
     * */
    @Test
    public void ifAddTaskCountOfTasksIncrease() {
        final int expectedCount = 6;
        Tracker_polimorph tracker = new Tracker_polimorph(new StubInput(
                new Task[]{new Task("task1", "desc1"),
                                new Task("task2", "desc2"),
                                new Task("task3", "desc3")}));
        tracker.addTask();
        tracker.addTask();
        tracker.addTask();
        Assert.assertEquals(expectedCount, tracker.getAllTasks().length);
    }
    /**
     *  Remove task ans check count of result with expected.
     * */
    @Test
    public void ifRemoveTaskThanCountChanges() {
        final int expected = 3;
        Tracker_polimorph tracker = new Tracker_polimorph(new StubInput(
                new Task[]{new Task("task1", "desc1"),
                        new Task("task2", "desc2"),
                        new Task("task3", "desc3")}));
        tracker.addTask();
        tracker.removeTask();
        Assert.assertEquals(expected, tracker.getAllTasks().length);
    }

    /**
     * Add task and check result with expected.
     * */
    @Test
    public void ifAddTaskThenEqualsExpectedTasks() {
        Tracker_polimorph tracker = new Tracker_polimorph(new StubInput(
                new Task[]{new Task("task1", "desc1"),
                        new Task("task2", "desc2"),
                        new Task("task3", "desc3")}));
        tracker.addTask();
        Assert.assertArrayEquals(new Task[]{new Task("task1", "desc1"),
                        new Task("task2", "desc2"),
                        new Task("task3", "desc3"),
                        new Task("task4", "desc4")},
                tracker.getAllTasks());
    }

    /**
     * Check count of comments after adding new comment.
     * */
    @Test
    public void thenAddCommentThanCountOfCommentsWillIncrease() {
        final int expected = 1;
        Tracker_polimorph tracker = new Tracker_polimorph(new StubInput(
                new Task[]{new Task("task1", "desc1"),
                        new Task("task2", "desc2"),
                        new Task("task3", "desc3")}));
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
        Tracker_polimorph tracker = new Tracker_polimorph(new StubInput(
                new Task[]{
                        new Task("task1", "desc1")}));
        Task task = tracker.addCommentToTask();
        String id = task.getId();
        Assert.assertEquals(new Task(id, "task1", "desc1", new Comment("comment1")), task);
    }
    /**
     * Add comment and check description of it.
     * */
    @Test
    public void ifAddCommentCheckAddedComment() {
        Tracker_polimorph tracker = new Tracker_polimorph(new StubInput(
                new Task[]{
                        new Task("task1", "desc1")}));
        tracker.addCommentToTask();

        Assert.assertEquals("comment1", tracker.getTaskByName("task1").getComments()[0].getDescription());
    }
    /**
     * Equal new comment with expected.
     * */
    @Test
    public void ifAddCommentCheckAddedCommentOnEquals() {
        Tracker_polimorph tracker = new Tracker_polimorph(new StubInput(
                new Task[]{
                        new Task("task1", "desc1")}));
        String id = tracker.getTaskByName("task1").getId();
        tracker.addCommentToTask();
        Assert.assertEquals((new Task(id, "task1", "some desc", new Comment("comment1"))).getComments()[0], tracker.getTaskByName("task1").getComments()[0]);
    }

    /**
     * Add task, edit it and compare result with expected.
     * */
    @Test
    public void ifEditTaskByNameThenResultEqualsWithExpected() {
        Tracker_polimorph tracker = new Tracker_polimorph(new StubInput(
                new Task[]{
                        new Task("task1", "desc1")}));
        String id = tracker.getTaskByName("task1").getId();
        tracker.editTaskByName();
        Assert.assertEquals(new Task(id, "task1 edited", "desc1 edited"), tracker.getAllTasks()[0]);
    }
    /**
     * Add task to tracker, add comment and compare description of comment with expected.
     * */
    @Test
    public void ifAddTaskAndSetDescriptionCompareItWithExpected() {
        Tracker_polimorph tracker = new Tracker_polimorph(new StubInput(
                new Task[]{
                        new Task("task1", "desc1")}));
        String id = tracker.getTaskByName("task1").getId();
        tracker.addCommentToTask();
        tracker.getAllTasks()[0].getComments()[0].setDescription("description");
        Assert.assertEquals("description", tracker.getAllTasks()[0].getComments()[0].getDescription());
    }
    /**
     * Add extra comment to task, check total counts of comments.
     * */
    @Test
    public void ifAddCommentToTaskWhereWasCommentThenCompareExpectedWithFactedCountOfComments() {
        Tracker_polimorph tracker = new Tracker_polimorph(new StubInput(
                new Task[]{
                        new Task("task1", "desc1")}));
        tracker.addCommentToTask();
        tracker.addCommentToTask();
        Assert.assertEquals(2, tracker.getAllTasks()[0].getComments().length);
    }
    /**
     * Add extra comment, compare description of new comment with expected.
     * */
    @Test
    public void ifAddCommentToTaskWhereWasCommentThenCompareExpectedWithFactedComment() {
        Tracker_polimorph tracker = new Tracker_polimorph(new StubInput(
                new Task[]{
                        new Task("task1", "desc1")}));
        tracker.addCommentToTask();
        tracker.addCommentToTask();
        Assert.assertEquals("comment12", tracker.getAllTasks()[0].getComments()[1].getDescription());
    }

}
