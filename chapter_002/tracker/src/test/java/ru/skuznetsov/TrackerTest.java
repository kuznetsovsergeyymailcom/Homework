package ru.skuznetsov;

import java.util.Arrays;
import java.util.Date;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import ru.skuznetsov.input.ConsoleInput;
import ru.skuznetsov.input.StubInput;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;

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
        Tracker tracker = new Tracker(new StubInput(new Task[]{
                new Task("task1", "some desc"),
                new Task("task2", "some desc"),
                new Task("task3", "some desc")
        }));
        assertThat(expectedCount, is(tracker.getTaskManager().getAllTasks().length));
    }
    /**
     *  Remove task ans check count of result with expected.
     * */
    @Test
    public void ifRemoveTaskThanCountChanges() {
        final int expected = 2;
        Tracker tracker = new Tracker(new StubInput(new Task[]{
                new Task("task1", "some desc"),
                new Task("task2", "some desc"),
                new Task("task3", "some desc")
        }));

        tracker.new RemoveTask().action();
        assertThat(expected, is(tracker.getTaskManager().getAllTasks().length));
    }
    /**
     * Remove not existed task, expect count will be decreased.
     * */
    @Test
    public void ifRemoveNotExistsTaskThanThrowsException() {
        final int expected = 1;
        Tracker tracker = new Tracker(new StubInput(new Task[]{
                new Task("task1", "some desc")}));
        tracker.new AddTask().action();
        tracker.new RemoveTask().action();
        assertThat(Arrays.asList(tracker.getTaskManager().getAllTasks()), Matchers.hasSize(expected));
    }
    /**
     * Add task and check result with expected.
     * */
    @Test
    public void ifAddTaskThenEqualsExpectedTasks() {
        Tracker tracker = new Tracker(new StubInput(new Task[]{
                new Task("task1", "some desc")}));
        tracker.new AddTask().action();
        assertThat(tracker.getTaskManager().getAllTasks(),
                arrayContainingInAnyOrder(new Task[]{
                        new Task("task1", "some desc"),
                        new Task("task2", "desc2"), }));
    }

    /**
     * Check coutn of comments after adding new comment.
     * */
    @Test
    public void thenAddCommentThanCountOfCommentsWillIncrease() {
        final int expected = 1;
        Tracker tracker = new Tracker(new ConsoleInput("task1\ndesc1\ntask1\nComment of task1"));
        tracker.new AddTask().action();
        tracker.new AddCommentToTask().action();
        Comment[] comments = tracker.getTaskManager().getTaskByName("task1").getComments();
        assertThat(Arrays.asList(comments), Matchers.hasSize(expected));
    }
    /**
     * Add comment and compare result with expected.
     * */
    @Test
    public void thenAddCommentThanCompareExpectedResult() {
        Tracker tracker = new Tracker(new ConsoleInput("task1\nsome desc\ntask1\nComment of task1\ntask1"));
        tracker.new AddTask().action();
        tracker.new AddCommentToTask().action();
        tracker.new GetTaskByName().action();
        Task task = tracker.getTaskManager().getTestTask();

        assertThat(new Task(task.getId(), "task1", "some desc",
                new Comment("Comment of task1")), is(equalTo(task)));
    }
    /**
     * Add comment and check description of it.
     * */
    @Test
    public void ifAddCommentCheckAddedComment() {
        Tracker tracker = new Tracker(new ConsoleInput("task1\nsome desc\ntask1\nComment of task1"));
        tracker.new AddTask().action();
        tracker.new AddCommentToTask().action();
        assertThat(tracker.getTaskManager().getTaskByName("task1").getComments()[0].getDescription(),
                        is(equalTo("Comment of task1")));
    }
    /**
     * Equal new comment with expected.
     * */
    @Test
    public void ifAddCommentCheckAddedCommentOnEquals() {
        Tracker tracker = new Tracker(new ConsoleInput("task1\nsome desc\ntask1\nComment of task1"));
        tracker.new AddTask().action();
        String id = tracker.getTaskManager().getTaskByName("task1").getId();
        tracker.new AddCommentToTask().action();
        assertThat(tracker.getTaskManager().getTaskByName("task1").getComments()[0],
                is(equalTo(new Comment("Comment of task1"))));
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
        Tracker tracker = new Tracker(new ConsoleInput("task1\nsome desc\ntask1\ntask123\nnew description"));
        tracker.new AddTask().action();
        String id = tracker.getTaskManager().getTaskByName("task1").getId();
        tracker.new EditTask().action();
        assertThat(tracker.getTaskManager().getTaskByName("task123"),
                is(equalTo(new Task(id, "task123", "new description"))));
    }
    /**
     * Add task to tracker, add comment and compare description of comment with expected.
     * */
    @Test
    public void ifAddTaskAndSetDescriptionCompareItWithExpected() {
        Tracker tracker = new Tracker(new ConsoleInput("task1\nsome desc\ntask1\ndescription"));
        tracker.new AddTask().action();
        tracker.new AddCommentToTask().action();
        tracker.getTaskManager().getAllTasks()[0].getComments()[0].setDescription("new description");
        assertThat("new description",
                is(equalTo(tracker.getTaskManager().getAllTasks()[0].getComments()[0].getDescription())));
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
