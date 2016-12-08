package ru.skuznetsov;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.hamcrest.Matchers.hasProperty;

import org.junit.Test;
import ru.skuznetsov.input.StubInput;

import java.util.Arrays;

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
        Tracker tracker = new Tracker(new StubInput(
                new Task[]{new Task("task1", "desc1"),
                                new Task("task2", "desc2"),
                                new Task("task3", "desc3")}));
        tracker.new AddTask().action();
        tracker.new AddTask().action();
        tracker.new AddTask().action();
        assertThat(Arrays.asList(tracker.getTaskManager().getAllTasks()), hasSize(expectedCount));
    }
    /**
     *  Remove task ans check count of result with expected.
     * */
    @Test
    public void ifRemoveTaskThanCountChanges() {
        final int expected = 2;
        Tracker tracker = new Tracker(new StubInput(
                new Task[]{new Task("task1", "desc1"),
                        new Task("task2", "desc2"),
                        new Task("task3", "desc3")}));
        tracker.new RemoveTask().action();
        assertThat(Arrays.asList(tracker.getTaskManager().getAllTasks()), hasSize(expected));
    }

    /**
     * Add task and check result with expected.
     * */
    @Test
    public void ifAddTaskThenEqualsExpectedTasks() {
        Tracker tracker = new Tracker(new StubInput(
                new Task[]{new Task("task1", "desc1"),
                        new Task("task2", "desc2"),
                        new Task("task3", "desc3")}));
        tracker.new AddTask().action();
        assertThat(tracker.getTaskManager().getAllTasks(),
                arrayContaining(new Task[]{new Task("task1", "desc1"),
                new Task("task2", "desc2"),
                new Task("task3", "desc3"),
                new Task("task4", "desc4")}));
    }

    /**
     * Check count of comments after adding new comment.
     * */
    @Test
    public void thenAddCommentThanCountOfCommentsWillIncrease() {
        final int expected = 1;
        Tracker tracker = new Tracker(new StubInput(
                new Task[]{new Task("task1", "desc1")}));
        tracker.new AddCommentToTask().action();

        Comment[] comments = tracker.getTaskManager().getAllTasks()[0].getComments();
        assertThat(comments.length, is(equalTo(expected)));
    }
    /**
     * Add comment and compare result with expected.
     * */
    @Test
    public void thenAddCommentThanCompareExpectedResult() {
        Tracker tracker = new Tracker(new StubInput(
                new Task[]{
                        new Task("task1", "desc1")}));
        tracker.new AddCommentToTask().action();
        Task task = tracker.getTaskManager().getAllTasks()[0];
        String id = task.getId();
        assertThat(new Task(id, "task1", "desc1",
                new Comment("comment1")), samePropertyValuesAs(task));
    }
    /**
     * Add comment and check description of it.
     * */
    @Test
    public void ifAddCommentCheckAddedComment() {
        Tracker tracker = new Tracker(new StubInput(
                new Task[]{new Task("task1", "desc1")}));
        tracker.new AddCommentToTask().action();

        assertThat("comment1",
                equalTo(tracker.getTaskManager().getTaskByName("task1").getComments()[0].getDescription()));
    }
    /**
     * Equal new comment with expected.
     * */
    @Test
    public void ifAddCommentCheckAddedCommentOnEquals() {
        Tracker tracker = new Tracker(new StubInput(
                new Task[]{
                        new Task("task1", "desc1")}));
        String id = tracker.getTaskManager().getTaskByName("task1").getId();
        tracker.new AddCommentToTask().action();
        assertThat((new Task(id, "task1", "some desc",
                new Comment("comment1"))).getComments()[0],
                samePropertyValuesAs(tracker.getTaskManager().getTaskByName("task1").getComments()[0]));
    }

    /**
     * Add task, edit it and compare result with expected.
     * */
    @Test
    public void ifEditTaskByNameThenResultEqualsWithExpected() {
        Tracker tracker = new Tracker(new StubInput(
                new Task[]{
                        new Task("task1", "desc1")}));
        String id = tracker.getTaskManager().getTaskByName("task1").getId();
        tracker.new EditTask().action();
        assertThat(new Task(id, "task1 edited",
                "desc1 edited"), is(equalTo(tracker.getTaskManager().getAllTasks()[0])));
    }
    /**
     * Add task to tracker, add comment and compare description of comment with expected.
     * */
    @Test
    public void ifAddTaskAndSetDescriptionCompareItWithExpected() {
        Tracker tracker = new Tracker(new StubInput(
                new Task[]{
                        new Task("task1", "desc1")}));
        tracker.new AddCommentToTask().action();
        tracker.getTaskManager().getAllTasks()[0].getComments()[0].setDescription("description");
        assertThat(tracker.getTaskManager().getAllTasks()[0].getComments()[0],
                hasProperty("description", equalTo("description")));
    }
    /**
     * Add extra comment to task, check total counts of comments.
     * */
    @Test
    public void ifAddCommentToTaskWhereWasCommentThenCompareExpectedWithFactedCountOfComments() {
        final int expected = 2;
        Tracker tracker = new Tracker(new StubInput(
                new Task[]{
                        new Task("task1", "desc1")}));
        tracker.new AddCommentToTask().action();
        tracker.new AddCommentToTask().action();
        assertThat(Arrays.asList(tracker.getTaskManager().getAllTasks()[0].getComments()), hasSize(expected));
    }
    /**
     * Add extra comment, compare description of new comment with expected.
     * */
    @Test
    public void ifAddCommentToTaskWhereWasCommentThenCompareExpectedWithFactedComment() {
        Tracker tracker = new Tracker(new StubInput(
                new Task[]{
                        new Task("task1", "desc1")}));
        tracker.new AddCommentToTask().action();
        tracker.new AddCommentToTask().action();
        assertThat("comment12", equalTo(tracker.getTaskManager().getAllTasks()[0].getComments()[1].getDescription()));
        assertThat("comment1", equalTo(tracker.getTaskManager().getAllTasks()[0].getComments()[0].getDescription()));
    }

}
