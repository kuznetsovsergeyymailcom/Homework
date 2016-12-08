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
     * Task for tests.
     * */
    private Task testTask = null;
    /**
     * Scanner user input.
     * */
    private Scanner scanner = null;
    /**
     * Default constructor.
     * */
    public ConsoleInput() {
        super();
        this.scanner = new Scanner(System.in);
    }
    /**
     * Constructor with user input simulated string.
     * @param userInput - user input string
     * */
    public ConsoleInput(final String userInput) {
        super();
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        this.scanner = new Scanner(System.in);
    }
    /**
     * Add new task with task name and description.
     * @return added task
     * */
    @Override
    public Task addTask() {
        while (true) {
            System.out.print("Enter name of task: ");
            String name = this.scanner.nextLine();
            if (!isTaskExists(name)) {
                System.out.print("Enter description of task: ");
                String desc = this.scanner.nextLine();

                Task[] temp = new Task[this.tasks.length + 1];
                System.arraycopy(this.tasks, 0, temp, 0, this.tasks.length);
                temp[this.tasks.length] = new Task(name, desc);
                this.setTestTask(temp[this.tasks.length]);
                this.tasks = temp;
                break;
            } else {
                System.out.println("Task already added enter over name of task");
            }
        }
        return this.tasks[this.tasks.length - 1];
    }
    /**
     * Add new comment to task.
     * @return task
     * */
    @Override
    public Task addCommentToTask() {
        Task task = null;
        while (true) {
            if (this.tasks.length != 0) {
                System.out.print("Enter name of task to add comment: ");
                String name = scanner.nextLine();
                if (isTaskExists(name)) {
                    System.out.print("Enter description of new comment: ");
                    String comment = scanner.nextLine();
                    for (int i = 0; i < this.tasks.length; ++i) {
                        task = this.tasks[i];
                        if (task.getName().equals(name)) {
                            task.addComment(new Comment(comment));
                            this.setTestTask(task);
                            break;
                        }
                    }
                    break;
                } else {
                    System.out.println("Unknown task, enter name of task from existed: ");
                    System.out.println(getNamesOfTasks().toString());
                }
            } else {
                System.out.println("No tasks found");
                break;
            }
        }
        return task;
    }
    /**
     * Randomly choose task and change name and description.
     * @return name of edited task
     * */
    @Override
    public Task editTaskByName() {
        Task task = null;
        while (true) {
            System.out.print("Enter name of task: ");
            String name = scanner.nextLine();
            if (isTaskExists(name)) {
                System.out.print("Enter new name of task: ");
                String newName = scanner.nextLine();
                System.out.print("Enter new description of task: ");
                String newDescription = scanner.nextLine();
                for (int i = 0; i < this.tasks.length; ++i) {
                    task = this.tasks[i];
                    if (task.getName().equals(name)) {
                        task.setName(newName);
                        task.setDescription(newDescription);
                        this.setTestTask(task);
                        break;
                    }
                }
                break;
            } else {
                System.out.println("Unknown task, enter name from existed: ");
                System.out.println(getNamesOfTasks().toString());
            }
        }

        return task;
    }
    /**
     * Randomly removing task.
     * */
    @Override
    public Task removeTask() {
        Task removedTask = null;
        while (true) {
            Task[] temp = new Task[this.tasks.length - 1];
            int j = 0;
            System.out.print("Enter name of task to remove it: ");
            String name = scanner.nextLine();
            if (isTaskExists(name)) {
                for (int i = 0; i < this.tasks.length; ++i) {
                    Task task = this.tasks[i];
                    if (!task.getName().equals(name)) {
                        temp[j++] = task;
                    } else {
                        removedTask = task;
                    }
                }
                this.tasks = temp;
                break;
            } else {
                System.out.println("Unknown task, enter name from existed: ");
                System.out.println(getNamesOfTasks().toString());
            }
        }
        return removedTask;
    }
    /**
     * Takes specific task.
     * @return task
     * */
    @Override
    public Task getTaskByName() {
        Task task = null;
        while (true) {
            System.out.print("Enter name of task to show it: ");
            String name = scanner.nextLine();
            if (isTaskExists(name)) {
                for (int i = 0; i < this.tasks.length; ++i) {
                    task = this.tasks[i];
                    if (task.getName().equals(name)) {
                        this.setTestTask(task);
                        break;
                    }
                }
                break;
            } else {
                System.out.println("Unknown task, enter name of task from existed: ");
                System.out.println(getNamesOfTasks().toString());
            }
        }
        return task;
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
     * Get task by name, method using  ONLY FOR TESTS.
     * @param name - name of task
     * @return task with specified name
     * */
    @Override
    public Task getTaskByName(final String name) {
        for (Task task : this.tasks) {
            if (task.getName().equals(name)) {
                this.setTestTask(task);
                return task;
            }
        }
        return null;
    }
    /**
     * Getter for test task.
     * @return test task
     * */
    public Task getTestTask() {
        return this.testTask;
    }
    /**
     * Setter for test task.
     * @param testTask - new or modified task
     * */
    public void setTestTask(final Task testTask) {
        this.testTask = testTask;
    }
    /**
     * Getter for scanner.
     * @return scanner instance
     * */
    public Scanner getScanner() {
        return this.scanner;
    }
    /**
     * Check if task already exists in storage, check by name.
     * @param name - name of task
     * @return true if exists
     * */
    private boolean isTaskExists(final String name) {
        boolean exists = false;
        for (Task task : this.tasks) {
            if (task.getName().equals(name)) {
                exists = true;
            }
        }
        return exists;
    }
    /**
     * Get names of tasks.
     * @return names of tasks
     * */
    private StringBuilder getNamesOfTasks() {
        StringBuilder builder = new StringBuilder();
        for (Task task : this.tasks) {
            builder.append(task.getName());
            builder.append(System.getProperty("line.separator"));
        }
        return builder;
    }
}
