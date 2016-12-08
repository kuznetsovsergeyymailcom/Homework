package ru.skuznetsov.input;

import ru.skuznetsov.Comment;
import ru.skuznetsov.Task;
import ru.skuznetsov.intefraces.ITaskManager;

import java.util.Scanner;

/**
 * Created by Sergey on 05.12.2016.
 */
public class StubInput implements ITaskManager {
    /**
     * Internal storage.
     * */
    private Task[] tasks;
    /**
     * Task for test control.
     * */
    private Task testTask = null;
    /**
     * Constructor with array on param.
     * @param tasks - new array
     *
     * */
    public StubInput(Task[] tasks) {
        super();
        this.tasks = tasks;
    }

    /**
     * Add new task with name = "task", index + 1, description =  "desc", index + 1.
     * @return task
     * */
    @Override
    public Task addTask() {

        Task[] temp = new Task[this.tasks.length + 1];
        System.arraycopy(this.tasks, 0, temp, 0, this.tasks.length);
        temp[this.tasks.length] = new Task("task" + (this.tasks.length + 1), "desc" + (this.tasks.length + 1));
        this.setTestTask(temp[this.tasks.length]);
        this.tasks = temp;
        return this.tasks[this.tasks.length - 1];
    }
    /**
     * Add new comment to last task.
     * @return task
     * */
    @Override
    public Task addCommentToTask() {
        Task task = null;
        String comment = "";

        String nameOfTask = this.tasks[this.tasks.length - 1].getName();
        if (this.tasks[this.tasks.length - 1].getComments().length == 0) {
           comment = "comment1";
        } else {
            comment = this.tasks[this.tasks.length - 1].getComments()[
                    this.tasks[this.tasks.length - 1].getComments().length - 1].getDescription();
            int commentIndex = this.tasks.length + 1;
            comment += commentIndex;
        }

        for (int i = 0; i < this.tasks.length; i++) {
            task = this.tasks[i];
            if (task.getName().equals(nameOfTask)) {
                task.addComment(new Comment(comment));
                this.setTestTask(task);
                break;
            }
        }
        return task;
    }
    /**
     * Edit last task and change name and description.
     * @return name of edited task
     * */
    @Override
    public Task editTaskByName() {
        Task task = null;

        String name = this.tasks[this.tasks.length - 1].getName();
        String newName = String.format("%s%s", this.tasks[this.tasks.length - 1].getName(), " edited");
        String newDescription = String.format("%s%s", this.tasks[this.tasks.length - 1].getDescription(), " edited");

        for (int i = 0; i < this.tasks.length; ++i) {
            task = this.tasks[i];
            if (task.getName().equals(name)) {
                task.setName(newName);
                task.setDescription(newDescription);
                this.setTestTask(task);
                break;
            }
        }
        return task;
    }
    /**
     * Removing last task.
     * */
    @Override
    public Task removeTask() {
        Task removedTask = null;

        if (this.tasks.length < 1) {
            System.out.println("No tasks found");
        } else {
            Task[] temp = new Task[this.tasks.length - 1];
            int j = 0;

            String name = this.tasks[this.tasks.length - 1].getName();
            for (int i = 0; i < this.tasks.length - 1; ++i) {
                Task task = this.tasks[i];
                if (!task.getName().equals(name)) {
                    temp[j++] = task;
                } else {
                    removedTask = task;
                }
            }

            this.tasks = temp;
        }

        return removedTask;
    }
    /**
     * Takes last task.
     * @return task
     * */
    @Override
    public Task getTaskByName() {
        return this.tasks[this.tasks.length - 1];
    }
    /**
     * Getter returns array with tasks.
     * @return all tasks
     * */
    @Override
    public Task[] getAllTasks() {
        return this.tasks;
    }
    /**
     * Get task by name, using ONLY FOR TESTS.
     * @param name - name of task
     * @return task with specified name
     * */
    @Override
    public Task getTaskByName(final String name) {
        for (Task task : this.tasks) {
            if (task.getName().equals(name)) {
                this.setTestTask(task);
            } else {
                return null;
            }
        }
        return getTestTask();
    }
    /**
     * Getter for test task.
     * @return test task
     * */
    @Override
    public Task getTestTask() {
        return this.testTask;
    }
    /**
     * Setter for test task.
     * @param testTask - task for test control
     * */
    public void setTestTask(final Task testTask) {
        this.testTask = testTask;
    }
    /**
     * Cap.
     * @return new instance of scanner
     * */
    @Override
    public Scanner getScanner() {
        return new Scanner(System.in);
    }
}
