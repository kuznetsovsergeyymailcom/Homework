package ru.skuznetsov;

import java.util.Arrays;
import java.util.Date;
import org.junit.Assert;
import org.junit.Test;
/**
 * Tascker class created 04.12.16.
 * */
public class TrackerTest {

    /**
     * Add task and equal result with expected.
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
     *  Remove task ans check count of result with expected.
     * */
    @Test
    public void ifRemoveTaskThanCountChanges() {
        final int expected = 2;
        Tracker tracker = new Tracker();
        tracker.addTask(new Task("task1", "some desc"));
        tracker.addTask(new Task("task2", "some desc"));
        tracker.addTask(new Task("task3", "some desc"));
        tracker.removeTask("task2");
        Assert.assertEquals(expected, tracker.getAllTasks().length);
    }
    /**
     * Remove not existed task, expect exception.
     * */
    @Test(expected = IllegalArgumentException.class)
    public void ifRemoveNotExistsTaskThanThrowsException() {
        Tracker tracker = new Tracker();
        tracker.addTask(new Task("task1", "some desc"));
        tracker.removeTask("task5");
    }
    /**
     * Add task and check result with expected.
     * */
    @Test
    public void ifAddTaskThenEqualsExpectedTasks() {
        Tracker tracker = new Tracker();
        tracker.addTask(new Task("task1", "some desc"));
        Assert.assertArrayEquals(new Task[]{new Task("task1", "some desc")}, tracker.getAllTasks());
    }
    /**
     * Get array of tasks by range of id.
     * */
    @Test
    public void ifGetArrayByRangeOfIdCompareResult() {
        Tracker tracker = new Tracker();
        tracker.addTask(new Task("task1", "some desc"));
        tracker.addTask(new Task("task2", "some desc"));
        String rand1 = tracker.getTaskByName("task1").getId();
        String rand2 = tracker.getTaskByName("task2").getId();
        Task[] choosenTasks = tracker.getTasksByRangeOfId(Integer.valueOf(rand1).intValue(), Integer.valueOf(rand2).intValue());
        Assert.assertArrayEquals(new Task[]{new Task("task1", "some desc"), new Task("task2", "some desc")}, choosenTasks);
    }
    /**
     * Check coutn of comments after adding new comment.
     * */
    @Test
    public void thenAddCommentThanCountOfCommentsWillIncrease() {
        final int expected = 1;
        Tracker tracker = new Tracker();
        tracker.addTask(new Task("task1", "some desc"));
        tracker.addCommentToTask("task1", new Comment("Comment of task1"));
        Comment[] comments = tracker.getTaskByName("task1").getComments();
        Assert.assertEquals(expected, comments.length);
    }
    /**
     * Add comment and compare result with expected.
     * */
    @Test
    public void thenAddCommentThanCompareExpectedResult() {
        Tracker tracker = new Tracker();
        tracker.addTask(new Task("task1", "some desc"));
        tracker.addCommentToTask("task1", new Comment("Comment of task1"));
        String id = tracker.getTaskByName("task1").getId();
        Task task = tracker.getTaskByName("task1");
        Assert.assertEquals(new Task(id, "task1", "some desc", new Comment("Comment of task1")), task);
    }
    /**
     * Add comment and check description of it.
     * */
    @Test
    public void ifAddCommentCheckAddedComment() {
        Tracker tracker = new Tracker();
        tracker.addTask(new Task("task1", "some desc"));
        tracker.addCommentToTask("task1", new Comment("Comment of task1"));
        Assert.assertEquals("Comment of task1", tracker.getTaskByName("task1").getComments()[0].getDescription());
    }
    /**
     * Equal new comment with expected.
     * */
    @Test
    public void ifAddCommentCheckAddedCommentOnEquals() {
        Tracker tracker = new Tracker();
        tracker.addTask(new Task("task1", "some desc"));
        String id = tracker.getTaskByName("task1").getId();
        tracker.addCommentToTask("task1", new Comment("Comment of task1"));
        Assert.assertEquals((new Task(id, "task1", "some desc", new Comment("Comment of task1"))).getComments()[0], tracker.getTaskByName("task1").getComments()[0]);
    }
    /**
     * Create task with empty constructor and compare description of it with expected description.
     * */
    @Test
    public void compareCreatedTaskWithExpected() {
        Task task = new Task();
        Assert.assertEquals("", task.getDescription());
    }
    /**
     * Craete task, set id and compare result with expected.
     * */
    @Test
    public void compareCreatedTaskWithExpectedIdOfTask() {
        Task task = new Task();
        task.setId("1");
        Assert.assertEquals("1", task.getId());
    }
    /**
     * Add task, edit it and compare result with expected.
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
     * Add task to tracker, add comment and compare description of comment with expected.
     * */
    @Test
    public void ifAddTaskAndSetDescriptionCompareItWithExpected() {
        Tracker tracker = new Tracker();
        tracker.addTask(new Task("task1", "some desc"));
        String id = tracker.getTaskByName("task1").getId();
        tracker.addCommentToTask("task1", new Comment("description"));
        tracker.getAllTasks()[0].getComments()[0].setDescription("new description");
        Assert.assertEquals("new description", tracker.getAllTasks()[0].getComments()[0].getDescription());
    }
    /**
     * Create comment with empty constructor and equal description of it with expected descriptio.
     * */
    @Test
    public void ifCreateCommentThenCompareResultWithExpected() {
        Comment comment = new Comment();
        Assert.assertEquals("", comment.getDescription());
    }
    /**
     * Create task, change date of creation and equal it with expected.
     * */
    @Test
    public void ifCreateTaskThenDateOfCreationWillEqualExpected() {
        long dateTime = (new Date()).getTime();
        Task task = new Task();
        task.changeDateOfCreation(dateTime);
        Assert.assertEquals(dateTime, task.getDateOfCreation());
    }
    /**
     * Equal task with zero, expected false.
     * */
    @Test
    public void ifCompareTaskWithNullThenFalse() {
        Task task = new Task();
        boolean equal = task.equals(null);
        Assert.assertFalse(equal);
    }
    /**
     * Compare string representation of comment.
     * */
    @Test
    public void ifCreateCommentThenCheckStringRpresentation() {
        Comment comment = new Comment("description");
        Assert.assertEquals("Comment{description=\'description\'}", comment.toString());
    }
    /**
     * Create class comment, compare it with expected class.
     * */
    @Test
    public void ifCreateCommentThenEqualItWithOverObject() {
        Comment comment = new Comment("description");
        Assert.assertEquals(Comment.class, comment.getClass());
    }
    /**
     * Create comment and compare his hash code with expected.
     * */
    @Test
    public void ifCreateCommentCompareHashCodeWithExpected() {
        Comment comment = new Comment("description");
        Assert.assertEquals("description".hashCode(), comment.hashCode());
    }
    /**
     * Create comment with null on argument and equal strign representation with expected.
     * */
    @Test
    public void ifCreateCommentThenCheckStringRpresentationWithNullOnArgs() {
        Comment comment = new Comment(null);
        Assert.assertEquals("Comment{description=\'null\'}", comment.toString());
    }
    /**
     * Create comment with null on argument and equal hash code with expected.
     * */
    @Test
    public void ifCreateCommentCompareHashCodeWithExpectedWithNullOnArgs() {
        Comment comment = new Comment(null);
        Assert.assertEquals(0L, comment.hashCode());
    }
    /**
     * Create task and compare string representation with expected.
     * */
    @Test
    public void ifCreateTaskCompareStringViewWithExpected() {
        Task task = new Task("task1", "desc");
        String id = task.getId();
        long date = task.getDateOfCreation();
        Assert.assertEquals("Task{id=\'" + id + "\', name=\'task1\', description=\'desc\', dateOfCreation=" + new Date(date) + ", comments=" + Arrays.toString(task.getComments()) + '}', task.toString());
    }
    /**
     * Create task, equal his hash code with expected.
     * */
    @Test
    public void ifCreateTaskCompareHashCodeWithExpected() {
        final int addon = 31;
        Task task = new Task("task1", "desc");
        boolean genNum = true;
        int result = addon * task.getName().hashCode() + task.getDescription().hashCode();
        result = addon * result + Arrays.hashCode(task.getComments());
        Assert.assertEquals(result, task.hashCode());
    }
    /**
     * Create task with null on args and compare result of string representation with expected.
     * */
    @Test
    public void ifCreateTaskCompareStringViewWithNullWithArgs() {
        Task task = new Task(null, null);
        Assert.assertEquals("Task{id=\'" + task.getId() + "\', name=\'null\', description=\'null\', dateOfCreation=" + new Date(task.getDateOfCreation()) + ", comments=" + Arrays.toString(task.getComments()) + '}', task.toString());
    }
    /**
     * Create task with null on args and compare hash code with expected.
     * */
    @Test
    public void ifCreateTaskCompareHashCodeWithNullOnArgs() {
        Task task = new Task(null, null);
        Assert.assertEquals(1, task.hashCode());
    }
}
