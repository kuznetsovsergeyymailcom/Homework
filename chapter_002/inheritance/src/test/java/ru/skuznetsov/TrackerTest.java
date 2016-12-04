package ru.skuznetsov;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by Sergey on 04.12.2016.
 */
public class TrackerTest {
    /**
     * Test add task method.
     * */
    @Test
    public void ifAddTaskCountOfTasksIncrease() {
        final int expectedCount = 3;
        Tracker tracker = new Tracker();
        tracker.addTask(new Task("task1", "some desc"));
        tracker.addTask(new Task("task2", "some desc"));
        tracker.addTask(new Task("task3", "some desc"));
        Assert.assertEquals(expectedCount, tracker.getAllTasks().length);
    }
    /**
     *Test remove task method.
     * */
    @Test
    public void ifRemoveTaskThanCountChanges() {
        Tracker tracker = new Tracker();
        tracker.addTask(new Task("task1", "some desc"));
        tracker.addTask(new Task("task2", "some desc"));
        tracker.addTask(new Task("task3", "some desc"));
        tracker.removeTask("task2");
        Assert.assertEquals(2, tracker.getAllTasks().length);
    }
    /**
     * Test remove method to throws exception then try to remove not exists item.
     * */
    @Test(expected = IllegalArgumentException.class)
    public void ifRemoveNotExistsTaskThanThrowsException() {
        Tracker tracker = new Tracker();
        tracker.addTask(new Task("task1", "some desc"));
        tracker.removeTask("task5");
    }
    /**
     * Compare internal storage of tasks.
     * Equals by random id was switched of.
     * */
    @Test
    public void ifAddTaskThenEqualsExpectedTasks() {
        Tracker tracker = new Tracker();
        tracker.addTask(new Task("task1", "some desc"));

        Assert.assertArrayEquals(new Task[]{new Task("task1", "some desc")}, tracker.getAllTasks());
    }
    /**
     * Test get tasks by range.
     * Equals by random id was switched of.
     * */
    @Test
    public void ifGetArrayByRangeOfIdCompareResult() {
        Tracker tracker = new Tracker();
        tracker.addTask(new Task("task1", "some desc"));
        tracker.addTask(new Task("task2", "some desc"));

        String rand1 = tracker.getTaskByName("task1").getId();
        String rand2 = tracker.getTaskByName("task2").getId();

        Task[] choosenTasks = tracker.getTasksByRangeOfId(Integer.valueOf(rand1), Integer.valueOf(rand2));

        Assert.assertArrayEquals(new Task[]{
                new Task("task1", "some desc"),
                new Task("task2", "some desc")},
                choosenTasks);
    }
    /**
     * Test add comment to task, check count.
     * */
    @Test
    public void thenAddCommentThanCountOfCommentsWillIncrease() {
        Tracker tracker = new Tracker();
        tracker.addTask(new Task("task1", "some desc"));
        tracker.addCommentsToTask("task1",  new Comment("Comment of task1"));
        Comment[] comments = tracker.getTaskByName("task1").getComments();

        Assert.assertEquals(1, comments.length);
    }
    /**
     * Test add comment to task, compare task with comment.
     * */
    @Test
    public void thenAddCommentThanCompareExpectedResult() {
        Tracker tracker = new Tracker();
        tracker.addTask(new Task("task1", "some desc"));
        tracker.addCommentsToTask("task1", new Comment("Comment of task1"));
        String id = tracker.getTaskByName("task1").getId();

        Task task = tracker.getTaskByName("task1");

        Assert.assertEquals(new Task(id, "task1", "some desc", new Comment("Comment of task1")), task);
    }
    /**
     * Add comment and check result of operation.
     * */
    @Test
    public void ifAddCommentCheckAddedComment() {
        Tracker tracker = new Tracker();
        tracker.addTask(new Task("task1", "some desc"));
        tracker.addCommentsToTask("task1", new Comment("Comment of task1"));
        Assert.assertEquals("Comment of task1", tracker.getTaskByName("task1").getComments()[0].getDescription());
    }

    /**
     * Add comment and check result of operation.
     * */
    @Test
    public void ifAddCommentCheckAddedCommentOnEquals() {
        Tracker tracker = new Tracker();
        tracker.addTask(new Task("task1", "some desc"));
        String id = tracker.getTaskByName("task1").getId();

        tracker.addCommentsToTask("task1", new Comment("Comment of task1"));
        Assert.assertEquals(
                new Task(id, "task1", "some desc",
                new Comment("Comment of task1")).getComments()[0],
                tracker.getTaskByName("task1").getComments()[0]);
    }
    /**
     * Add task and check result with expected.
     * */
    @Test
    public void compareCreatedTaskWithExpected() {
        Task task = new Task();
        Assert.assertEquals("", task.getDescription());
    }
    /**
     * Add task and check result with expected.
     * */
    @Test
    public void compareCreatedTaskWithExpectedIdOfTask() {
        Task task = new Task();
        task.setId("1");
        Assert.assertEquals("1", task.getId());
    }
    /**
     * Edit task and equal result.
     * */
    @Test
    public void ifEditTaskByNameThenResultEqualsWithExpected() {
        Tracker tracker = new Tracker();
        tracker.addTask(new Task("task1", "some desc"));
        String id = tracker.getTaskByName("task1").getId();

        tracker.editTaskByName("task1", "task123", "new description");
        Assert.assertEquals(new Task(id, "task123", "new description"), tracker.getAllTasks()[0]);
    }
    /**
     * Add task, add comment and set description compare result.
     * */
    @Test
    public void ifAddTaskAndSetDescriptionCompareItWithExpected() {
        Tracker tracker = new Tracker();
        tracker.addTask(new Task("task1", "some desc"));
        String id = tracker.getTaskByName("task1").getId();
        tracker.addCommentsToTask("task1", new Comment("description"));
        tracker.getAllTasks()[0].getComments()[0].setDescription("new description");

        Assert.assertEquals("new description",
                tracker.getAllTasks()[0].getComments()[0].getDescription());
    }
    /**
     * Create comment and compare it with expected.
     * */
    @Test
    public void ifCreateCommentThenCompareResultWithExpected() {
        Comment comment = new Comment();
        Assert.assertEquals("", comment.getDescription());
    }

    /**
     * Create task and verify date of creation.
     * */
    @Test
    public void ifCreateTaskThenDateOfCreationWillEqualExpected() {
        long dateTime = new Date().getTime();
        Task task = new Task();
        task.changeDateOfCreation(dateTime);
        Assert.assertEquals(dateTime, task.getDateOfCreation());
    }
    /**
     * Check result of comparing with null.
     * */
    @Test
    public void ifCompareTaskWithNullThenFalse() {
        Task task = new Task();
        boolean equal = task.equals(null);
        Assert.assertFalse(equal);
    }
    /**
     * Copare strign view of Comment with expected.
     * */
    @Test
    public void ifCreateCommentThenCheckStringRpresentation() {
        Comment comment = new Comment("description");
        Assert.assertEquals("Comment{description='description'}", comment.toString());
    }
    /**
     * Compare class of comment with expected.
     * */
    @Test
    public void ifCreateCommentThenEqualItWithOverObject() {
        Comment comment = new Comment("description");
        Assert.assertEquals(Comment.class, comment.getClass());
    }
    /**
     * Compare hash code with expected.
     * */
    @Test
    public void ifCreateCommentCompareHashCodeWithExpected() {
        Comment comment = new Comment("description");
        Assert.assertEquals("description".hashCode(), comment.hashCode());
    }

    /**
     * Copare strign view of Comment with expected.
     * */
    @Test
    public void ifCreateCommentThenCheckStringRpresentationWithNullOnArgs() {
        Comment comment = new Comment(null);
        Assert.assertEquals("Comment{description='null'}", comment.toString());
    }
    /**
     * Compare hash code with expected.
     * */
    @Test
    public void ifCreateCommentCompareHashCodeWithExpectedWithNullOnArgs() {
        Comment comment = new Comment(null);
        Assert.assertEquals(0, comment.hashCode());
    }
    /**
     * Compare task string view with expected.
     * */
    @Test
    public void ifCreateTaskCompareStringViewWithExpected() {
        Task task = new Task("task1", "desc");
        String id = task.getId();
        long date = task.getDateOfCreation();
        Assert.assertEquals("Task{id='" + id + "', name='task1', description='desc', dateOfCreation="
                + new Date(date) + ", comments=" + Arrays.toString(task.getComments()) + '}', task.toString());
    }
    /**
     * Compare task hash code view with expected.
     * */
    @Test
    public void ifCreateTaskCompareHashCodeWithExpected() {
        Task task = new Task("task1", "desc");
        final int genNum = 31;
        int result = genNum * task.getName().hashCode() + task.getDescription().hashCode();
        result = genNum * result + Arrays.hashCode(task.getComments());

        Assert.assertEquals(result, task.hashCode());
    }


    /**
     * Compare task string view with expected.
     * */
    @Test
    public void ifCreateTaskCompareStringViewWithNullWithArgs() {
        Task task = new Task(null, null);

        Assert.assertEquals("Task{id='" + task.getId() + "', name='null', description='null', dateOfCreation="
                + new Date(task.getDateOfCreation()) + ", comments=" + Arrays.toString(task.getComments()) + '}', task.toString());
    }
    /**
     * Compare task hash code view with expected.
     * */
    @Test
    public void ifCreateTaskCompareHashCodeWithNullOnArgs() {
        Task task = new Task(null, null);

        Assert.assertEquals(1, task.hashCode());
    }

}
