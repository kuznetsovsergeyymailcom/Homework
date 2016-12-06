package ru.skuznetsov.input;

import ru.skuznetsov.Comment;
import ru.skuznetsov.Task;
import ru.skuznetsov.intefraces.ITaskManager;

import java.util.Random;

/**
 * Created by Sergey on 05.12.2016.
 */
public class StubInput implements ITaskManager {
    private Task[] tasks;

    public StubInput(Task[] tasks) {
        this.tasks = tasks;
    }

    /**
     * Add new task with name = "task", index + 1, description =  "desc", index + 1.
     * */
    @Override
    public Task addTask() {
        int lenght = this.tasks.length;
        Task[] temp = new Task[this.tasks.length + 1];
        System.arraycopy(this.tasks, 0, temp, 0, this.tasks.length);
        temp[this.tasks.length] = new Task("task" + (lenght + 1), "desc" + (lenght + 1));
        this.tasks = temp;
        return this.tasks[this.tasks.length - 1];
    }

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
        int length = this.tasks.length;
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
     * */
    @Override
    public Task getTaskByName() {

        return this.tasks[this.tasks.length - 1];
    }

    @Override
    public Task[] getAllTasks() {
        return this.tasks;
    }

    @Override
    public Task getTaskByName(String name) {
        for (Task task : this.tasks) {
            if (task.getName().equals(name)) {
                return task;
            }
        }
        return null;
    }
}
