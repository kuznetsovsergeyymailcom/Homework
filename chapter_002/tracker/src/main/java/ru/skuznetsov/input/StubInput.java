package ru.skuznetsov.input;

import ru.skuznetsov.Comment;
import ru.skuznetsov.Task;
import ru.skuznetsov.intefraces.ITaskManager;

import java.util.Random;

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
        this.tasks = tasks;
    }

    /**
     * Add new task with name = "task", index + 1, description =  "desc", index + 1.
     * @return task
     * */
    @Override
    public Task addTask() {

        int lenght = this.tasks.length;
        Task[] temp = new Task[this.tasks.length + 1];
        System.arraycopy(this.tasks, 0, temp, 0, this.tasks.length);
        temp[this.tasks.length] = new Task("task" + (lenght + 1), "desc" + (lenght + 1));
        setTestTask(temp[this.tasks.length]);
        this.tasks = temp;
        return this.tasks[this.tasks.length - 1];
    }
    /**
     * Add new comment to task.
     * @return task
     * */
    @Override
    public Task addCommentToTask() {
        Random random = new Random();
        int length = this.tasks.length;
        String comment = "";

        int taskNumber = random.nextInt(length);

        String nameOfTask = this.tasks[taskNumber].getName();
        if (this.tasks[taskNumber].getComments().length == 0) {
           comment = "comment1";
        } else {
            comment = this.tasks[taskNumber].getComments()[
                    this.tasks[taskNumber].getComments().length - 1].getDescription();
            int commentIndex = length + 1;
            comment += commentIndex;

        }

        for (int i = 0; i < length; ++i) {
            Task task = this.tasks[i];
            if (task.getName().equals(nameOfTask)) {
                task.addComment(new Comment(comment));
                setTestTask(task);
                return task;
            }
        }
        return null;
    }
    /**
     * Randomly choose task and change name and description.
     * @return name of edited task
     * */
    @Override
    public Task editTaskByName() {
        int length = this.tasks.length;

        Random random = new Random();
        int taskNumber = random.nextInt(length);

        String name = this.tasks[taskNumber].getName();
        String newName = this.tasks[taskNumber].getName() + " edited";
        String newDescription = this.tasks[taskNumber].getDescription() + " edited";

        for (int i = 0; i < length; ++i) {
            Task task = this.tasks[i];
            if (task.getName().equals(name)) {
                task.setName(newName);
                task.setDescription(newDescription);
                setTestTask(task);
                return task;
            }
        }
        return null;
    }
    /**
     * Randomly removing task.
     * */
    @Override
    public void removeTask() {
        Random random = new Random();
        Task[] temp = new Task[this.tasks.length - 1];
        int length = temp.length;
        int taskNumber = random.nextInt(length);
        int j = 0;

        String name = this.tasks[taskNumber].getName();
        for (int i = 0; i < this.tasks.length - 1; ++i) {
            Task task = this.tasks[i];
            if (!task.getName().equals(name)) {
                temp[j++] = task;
            }
        }

        this.tasks = temp;
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
     * Get task by name.
     * @param name - name of task
     * @return task with specified name
     * */
    @Override
    public Task getTaskByName(String name) {
        for (Task task : this.tasks) {
            if (task.getName().equals(name)) {
                setTestTask(task);
                return task;
            }
        }
        return null;
    }
    /**
     * Getter for test task.
     * @return test task
     * */
    @Override
    public Task getTestTask() {
        return testTask;
    }
    /**
     * Setter for test task.
     * @param testTask - task for test control
     * */
    public void setTestTask(Task testTask) {
        this.testTask = testTask;
    }
}
