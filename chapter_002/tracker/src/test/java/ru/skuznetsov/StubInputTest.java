package ru.skuznetsov;

import org.junit.Assert;
import org.junit.Test;
import ru.skuznetsov.input.StubInput;

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
        TrackerPolimorth tracker = new TrackerPolimorth(new StubInput(
                new Task[]{new Task("task1", "desc1"),
                                new Task("task2", "desc2"),
                                new Task("task3", "desc3")}));
        tracker.new AddTask().action();
        tracker.new AddTask().action();
        tracker.new AddTask().action();
        Assert.assertEquals(expectedCount, tracker.getTaskManager().getAllTasks().length);
    }
    /**
     *  Remove task ans check count of result with expected.
     * */
    @Test
    public void ifRemoveTaskThanCountChanges() {
        final int expected = 1;
        TrackerPolimorth tracker = new TrackerPolimorth(new StubInput(
                new Task[]{new Task("task1", "desc1"),
                        new Task("task2", "desc2"),
                        new Task("task3", "desc3")}));
        tracker.new RemoveTask().action();
        tracker.new RemoveTask().action();
        Assert.assertEquals(expected, tracker.getTaskManager().getAllTasks().length);
    }

    /**
     * Add task and check result with expected.
     * */
    @Test
    public void ifAddTaskThenEqualsExpectedTasks() {
        TrackerPolimorth tracker = new TrackerPolimorth(new StubInput(
                new Task[]{new Task("task1", "desc1"),
                        new Task("task2", "desc2"),
                        new Task("task3", "desc3")}));
        tracker.new AddTask().action();
        Assert.assertArrayEquals(new Task[]{new Task("task1", "desc1"),
                        new Task("task2", "desc2"),
                        new Task("task3", "desc3"),
                        new Task("task4", "desc4")},
                tracker.getTaskManager().getAllTasks());
    }

    /**
     * Check count of comments after adding new comment.
     * */
    @Test
    public void thenAddCommentThanCountOfCommentsWillIncrease() {
        final int expected = 1;
        TrackerPolimorth tracker = new TrackerPolimorth(new StubInput(
                new Task[]{new Task("task1", "desc1")}));
        tracker.new AddCommentToTask().action();

        Comment[] comments = tracker.getTaskManager().getAllTasks()[0].getComments();
        Assert.assertEquals(expected, comments.length);
    }
    /**
     * Add comment and compare result with expected.
     * */
    @Test
    public void thenAddCommentThanCompareExpectedResult() {
        TrackerPolimorth tracker = new TrackerPolimorth(new StubInput(
                new Task[]{
                        new Task("task1", "desc1")}));
        tracker.new AddCommentToTask().action();
        Task task = tracker.getTaskManager().getAllTasks()[0];
        String id = task.getId();
        Assert.assertEquals(new Task(id, "task1", "desc1",
                new Comment("comment1")), task);
    }
    /**
     * Add comment and check description of it.
     * */
    @Test
    public void ifAddCommentCheckAddedComment() {
        TrackerPolimorth tracker = new TrackerPolimorth(new StubInput(
                new Task[]{new Task("task1", "desc1")}));
        tracker.new AddCommentToTask().action();

        Assert.assertEquals("comment1", tracker.getTaskManager().getTaskByName("task1").getComments()[0].getDescription());
    }
    /**
     * Equal new comment with expected.
     * */
    @Test
    public void ifAddCommentCheckAddedCommentOnEquals() {
        TrackerPolimorth tracker = new TrackerPolimorth(new StubInput(
                new Task[]{
                        new Task("task1", "desc1")}));
        String id = tracker.getTaskManager().getTaskByName("task1").getId();
        tracker.new AddCommentToTask().action();
        Assert.assertEquals((new Task(id, "task1", "some desc",
                new Comment("comment1"))).getComments()[0],
                tracker.getTaskManager().getTaskByName("task1").getComments()[0]);
    }

    /**
     * Add task, edit it and compare result with expected.
     * */
    @Test
    public void ifEditTaskByNameThenResultEqualsWithExpected() {
        TrackerPolimorth tracker = new TrackerPolimorth(new StubInput(
                new Task[]{
                        new Task("task1", "desc1")}));
        String id = tracker.getTaskManager().getTaskByName("task1").getId();
        tracker.new EditTask().action();
        Assert.assertEquals(new Task(id, "task1 edited", "desc1 edited"), tracker.getTaskManager().getAllTasks()[0]);
    }
    /**
     * Add task to tracker, add comment and compare description of comment with expected.
     * */
    @Test
    public void ifAddTaskAndSetDescriptionCompareItWithExpected() {
        TrackerPolimorth tracker = new TrackerPolimorth(new StubInput(
                new Task[]{
                        new Task("task1", "desc1")}));
        String id = tracker.getTaskManager().getTaskByName("task1").getId();
        tracker.new AddCommentToTask().action();
        tracker.getTaskManager().getAllTasks()[0].getComments()[0].setDescription("description");
        Assert.assertEquals("description", tracker.getTaskManager().getAllTasks()[0].getComments()[0].getDescription());
    }
    /**
     * Add extra comment to task, check total counts of comments.
     * */
    @Test
    public void ifAddCommentToTaskWhereWasCommentThenCompareExpectedWithFactedCountOfComments() {
        TrackerPolimorth tracker = new TrackerPolimorth(new StubInput(
                new Task[]{
                        new Task("task1", "desc1")}));
        tracker.new AddCommentToTask().action();
        tracker.new AddCommentToTask().action();
        Assert.assertEquals(2, tracker.getTaskManager().getAllTasks()[0].getComments().length);
    }
    /**
     * Add extra comment, compare description of new comment with expected.
     * */
    @Test
    public void ifAddCommentToTaskWhereWasCommentThenCompareExpectedWithFactedComment() {
        TrackerPolimorth tracker = new TrackerPolimorth(new StubInput(
                new Task[]{
                        new Task("task1", "desc1")}));
        tracker.new AddCommentToTask().action();
        tracker.new AddCommentToTask().action();
        Assert.assertEquals("comment12", tracker.getTaskManager().getAllTasks()[0].getComments()[1].getDescription());
        Assert.assertEquals("comment1", tracker.getTaskManager().getAllTasks()[0].getComments()[0].getDescription());
    }

}
