package ru.skuznetsov.input;

import ru.skuznetsov.Comment;
import ru.skuznetsov.Task;
import ru.skuznetsov.intefraces.ITaskManager;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

/**
 * Created by Sergey on 05.12.2016.
 */
public class ConsoleInput implements ITaskManager {
    /**
     * Storage.
     * */
    private Task[] tasks = new Task[0];
    /**
     * Scanner user input.
     * */
    private Scanner scanner = null;
    /**
     * Default constructor.
     * */
    public ConsoleInput() { }
    /**
     * Constructor with user input simulated string.
     * @param userInput - user input string
     * */
    public ConsoleInput(String userInput) {
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        scanner = new Scanner(System.in);
    }
    /**
     * Add new task with task name and description.
     * @return task
     * */
    @Override
    public Task addTask() {
        System.out.print("Enter name of task: ");
        String name = scanner.nextLine();
        System.out.print("Enter description of task: ");
        String desc = scanner.nextLine();

        Task[] temp = new Task[this.tasks.length + 1];
        System.arraycopy(this.tasks, 0, temp, 0, this.tasks.length);
        temp[this.tasks.length] = new Task(name, desc);
        this.tasks = temp;
        return this.tasks[this.tasks.length - 1];
    }
    /**
     * Add new comment to task.
     * @return task
     * */
    @Override
    public Task addCommentToTask() {
        Task[] tempTasts = this.tasks;
        int length = tempTasts.length;

        System.out.print("Enter name of task: ");
        String name = scanner.nextLine();
        System.out.print("Enter description of new comment: ");
        String comment = scanner.nextLine();

        for (int i = 0; i < length; ++i) {
            Task task = tempTasts[i];
            if (task.getName().equals(name)) {
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

        System.out.print("Enter name of task: ");
        String name = scanner.nextLine();
        System.out.print("Enter new name of task: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new description of task: ");
        String newDescription = scanner.nextLine();

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
        Task[] temp = new Task[this.tasks.length - 1];
        int j = 0;
        System.out.print("Enter name of task to remove it: ");
        String name = scanner.nextLine();

        for (int i = 0; i < this.tasks.length; ++i) {
            Task task = this.tasks[i];
            if (!task.getName().equals(name)) {
                temp[j++] = task;
            }
        }
        this.tasks = temp;
    }
    /**
     * Takes specific task.
     * @return task
     * */
    @Override
    public Task getTaskByName() {
        Task[] tempTasks = this.tasks;
        int length = tempTasks.length;

        System.out.print("Enter name of task to show it: ");
        String name = scanner.nextLine();

        for (int i = 0; i < length; ++i) {
            Task task = tempTasks[i];
            if (task.getName().equals(name)) {
                return task;
            }
        }
        return null;
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
                return task;
            }
        }
        return null;
    }

}
