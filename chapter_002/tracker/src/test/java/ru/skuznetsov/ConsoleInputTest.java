package ru.skuznetsov;

import org.hamcrest.Matchers;
import org.junit.Test;
import ru.skuznetsov.input.ConsoleInput;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

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
        assertThat(expectedCount, equalTo(input.getAllTasks().length));
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
        assertThat(expected, equalTo(tracker.getAllTasks().length));
    }

    /**
     * Add task and check result with expected.
     * */
    @Test
    public void ifAddTaskThenEqualsExpectedTasks() {
        ConsoleInput tracker = new ConsoleInput("task1\ndesc1\ntask2\ndesc2");

        tracker.addTask();
        tracker.addTask();
        assertThat(tracker.getAllTasks(), arrayContaining(new Task[]{new Task("task1", "desc1"),
                new Task("task2", "desc2")}));
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
        assertThat(expected, is(equalTo(comments.length)));
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
        assertThat(new Task(id, "task1", "desc1", new Comment("comment of task1")),
                is(tracker.getTaskByName("task1")));
    }
    /**
     * Add comment and check description of it.
     * */
    @Test
    public void ifAddCommentCheckAddedComment() {
        ConsoleInput tracker = new ConsoleInput("task1\ndesc1\ntask1\ncomment of task1");
        tracker.addTask();
        tracker.addCommentToTask();
        assertThat("comment of task1", is(equalTo(tracker.getTaskByName("task1").getComments()[0].getDescription())));
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
        assertThat(tracker.getTaskByName("task1").getComments()[0],
                is(equalTo(new Task(id, "task1", "desc1", new Comment("comment of task1")).getComments()[0])));
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
        assertThat(tracker.getAllTasks()[0], is(equalTo(new Task(id, "task999", "new description"))));
    }
    /**
     * Add task to tracker, add comment and compare description of comment with expected.
     * */
    @Test
    public void ifAddTaskAndSetDescriptionCompareItWithExpected() {
        ConsoleInput tracker = new ConsoleInput("task1\ndesc1\ntask1\ncomment info");
        tracker.addTask();
        tracker.addCommentToTask();
        tracker.getAllTasks()[0].getComments()[0].setDescription("new comment");
        assertThat(tracker.getAllTasks()[0].getComments()[0].getDescription(), is(equalTo("new comment")));
    }
    /**
     * Add extra comment to task, check total counts of comments.
     * */
    @Test
    public void ifAddCommentToTaskWhereWasCommentThenCompareExpectedWithFactedCountOfComments() {
        final int expected = 2;
        ConsoleInput tracker = new ConsoleInput("task1\ndesc1\ntask1\ncomment info\ntask1\ncomment info");
        tracker.addTask();
        tracker.addCommentToTask();
        tracker.addCommentToTask();
        assertThat(Arrays.asList(tracker.getAllTasks()[0].getComments()), Matchers.hasSize(expected));
    }
    /**
     * Add extra comment, compare description of new comment with expected.
     * */
    @Test
    public void ifAddCommentToTaskWhereWasCommentThenCompareExpectedWithFactedComment() {
        ConsoleInput tracker = new ConsoleInput("task1\ndesc1\ntask1\ncomment info\ntask1\ncomment info1");
        tracker.addTask();
        tracker.addCommentToTask();
        tracker.addCommentToTask();
        assertThat(tracker.getAllTasks()[0].getComments()[0].getDescription(), is(equalTo("comment info")));
        assertThat(tracker.getAllTasks()[0].getComments()[1].getDescription(), is(equalTo("comment info1")));
    }
}
