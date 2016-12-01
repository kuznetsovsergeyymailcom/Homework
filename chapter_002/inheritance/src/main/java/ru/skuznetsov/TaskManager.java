package ru.skuznetsov;

import ru.skuznetsov.exceptions.UnknownOperation;
import ru.skuznetsov.interfaces.ITaskManager;

/**
 * Created by Sergey on 30.11.2016.
 */
public class TaskManager implements ITaskManager {
    /**
     * Instance of task manager.
     * */
    private static TaskManager taskManager = null;
    /**
     * Array of tasks.
     * */
    private Task[] tasks = new Task[0];
    /**
     * default private constructor.
     * */
    private TaskManager() { }
    /**
     * Method returns current instance of task manager.
     * @return task manager
     * */
    public static TaskManager getTaskManager() {
        if (TaskManager.taskManager == null) {
            taskManager = new TaskManager();
        }
        return taskManager;
    }
    /**
     * Adding task to task array.
     * */
    @Override
    public void addTask() {
        String name;
        String description;
        System.out.print("\tPlease enter name of task: ");
        name = System.console().readLine();
        System.out.print("\tPlease input description: ");
        description = System.console().readLine();

        Task task = new Task(name, description);

        int lenght = this.tasks.length;
        // выделяем массив размером на 1 больше старого
        Task[] tasks = new Task[lenght + 1];

        // Переносим комментарии из старого массива в новый
        if (lenght > 0) {
            for (int i = 0; i < lenght; i++) {
                tasks[i] = this.tasks[i];
            }
        }
        // Вставляем новое значение в конец
        tasks[lenght] = task;
        // Копируем массив
        this.tasks = tasks;
        if (tasks.length > lenght) {
            System.out.println("New task: ");
            System.out.println(task);
        } else {
            System.out.println("Task was not added");
        }
    }
    /**
     * Edit some task.
     * */
    @Override
    public void editTask() {
        showAllTasks();

        System.out.print("Enter name of task to edit it: ");
        String userInput = System.console().readLine();
        if (isTaskExists(userInput)) {
            for (Task task : this.tasks) {
                if (task.getName().equals(userInput)) {
                    boolean repeate = false;
                    do {
                        System.out.print("Enter property to edit it (name, description or exit to quit): ");
                        String userInputProperty = System.console().readLine();
                            switch (userInputProperty) {
                                case "name":
                                    System.out.print("Name of choosen task: " + task.getName() + ", enter new name: ");
                                    String name = System.console().readLine();
                                    task.setName(name);
                                    repeate = false;
                                    System.out.println("\nTask after update");
                                    System.out.println(task);
                                    break;
                                case "description":
                                    System.out.print("Description of choosen task: " + task.getDescription() + ", enter new description: ");
                                    String desc = System.console().readLine();
                                    task.setDescription(desc);
                                    repeate = false;
                                    System.out.println("\nTask after update");
                                    System.out.println(task);
                                    break;
                                case "exit":
                                    repeate = false;
                                break;
                                default:
                                    System.out.println("Invalid property of task");
                                    repeate = true;
                            }
                    } while (repeate);

                }
            }
        } else {
            System.out.println("Task with name " + userInput + " not found");
        }
    }
    /**
     * Removing task by name.
     * */
    @Override
    public void removeTask() {
        int j = 0;
        showAllTasks();

        System.out.print("Enter number of task to remove it: ");
        String userInput = System.console().readLine();
        int index = Integer.valueOf(userInput) - 1;

        Task[] tasks = new Task[this.tasks.length - 1];

        if (index < 0 || index >= this.tasks.length) {
            throw new ArrayIndexOutOfBoundsException("Out of bounds");
        }
        for (int i = 0; i < this.tasks.length; i++) {
            if (i != index) {
                tasks[j++] = this.tasks[i];
            }
        }
        this.tasks = tasks;

        showAllTasks();
    }

    /**
     * Method shows all tasks.
     * */
    @Override
    public void showAllTasks() {
        int i = 0;
        System.out.println("---------------------------------------------------------------\n");
        if (tasks.length == 0) {
            System.out.println("Task not found");
        }
        for (Task task : tasks) {
            i++;
            System.out.println(i + ") " + task);
        }
        System.out.println("---------------------------------------------------------------\n");
    }

    /**
     * Method shows tasks by period of creation.
     * */
    @Override
    public void showSpecifiedTask() {
        System.out.print("Enter name of task to show details of it: ");
        System.out.println("Available names of tasks: ");
        for (Task task : this.tasks) {
            System.out.println(" - " + task.getName());
        }
        System.out.println();
        System.out.print("Name of task: ");
        String userInput = System.console().readLine();
        if (isTaskExists(userInput)) {
            for (Task task : tasks) {
                if (task.getName().equals(userInput)) {
                    System.out.println(task);
                }
            }
        } else {
            System.out.println("Task was not found");
        }
    }
    /**
     * Adding comment to specified task.
     * */
    @Override
    public void addCommentToTask() {
        System.out.println("Enter name of task, in wich one you want to add comment or exit to quit: ");
        showAllTasks();
        System.out.print("Name of task: ");
        String userInput = System.console().readLine();
        if (isTaskExists(userInput)) {
            for (Task task : this.tasks) {
                if (task.getName().equals(userInput)) {
                    System.out.println("Count of comments of choosen task: " + task.getComments().length);
                    System.out.print("Enter new comment: ");
                    String comment = System.console().readLine();
                    task.addComment(new Comment(comment));
                    System.out.println("\nUpdated task:");
                    System.out.println(task);
                }
            }
        } else {
            if (!userInput.equals("exit")) {
                addCommentToTask();
            }
        }
    }

    /**
     * Method outputs main menu and returns user choose of operation.
     * @return number of operation
     * */
    public int mainMenu() {
        final int firstNumberOfOperation = 0, numberOfExitOperation = 7;
        int userOperationNumber = 0;
        System.out.println("\n Choose action: \n");
        System.out.println("1. Add task");
        System.out.println("2. Edit task");
        System.out.println("3. Remove task");
        System.out.println("4. Show all tasks");
        System.out.println("5. Show tasks by name");
        System.out.println("6. Add comments to task");
        System.out.println("7. Exit");
        System.out.print("\nYour input: ");
        String userInput = System.console().readLine();
        try {

            userOperationNumber = Integer.valueOf(userInput);
            if (userOperationNumber < firstNumberOfOperation || userOperationNumber > numberOfExitOperation) {
                throw new UnknownOperation("Number must be from 0 to 7 please input choose again");
            }
        } catch (NumberFormatException e) {
            System.out.println("Enter nmber of operation from 1 to 7");
            mainMenu();
        } catch (UnknownOperation e) {
            System.out.println(e.getMessage());
            mainMenu();
        }

        return userOperationNumber;
    }
    /**
     * Takes user input from console.
     * @return user input
     * */
    private int takeUserInput() {
        String userInput = System.console().readLine();
        int index = Integer.valueOf(userInput) - 1;
        return index;
    }
    /**
     * Check is tasks contains task with spec name.
     * @param name - name of task
     * @return is tasks ontains task with spec name
     * */
    private boolean isTaskExists(String name) {
        boolean exists = false;
        for (Task task : this.tasks) {
           if (task.getName().equals(name)) {
               exists = true;
           }
        }
        return exists;
    }

}
