package ru.skuznetsov;

import ru.skuznetsov.input.ConsoleInput;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

/**
 * Created by Sergey on 05.12.2016.
 */
public class StartUI {
    /**
     * Task, here will be saved result of operations for tests.
     * */
    private static Task testTask = null;
    /**
     * Collection of tasks for tests.
     * */
    private static Task[] tasks = null;
    /**
     * Tracker instance with storage.
     * */
    private static Tracker tracker = null;
    /**
     * Scanner.
     * */
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Default constructor with operation number  as string.
     * @param operationNumber - operation from 1 - 7
     * */
    public StartUI(final String operationNumber) {
        super();
        System.setIn(new ByteArrayInputStream(operationNumber.getBytes()));
        scanner = new Scanner(System.in);
    }
    /**
     * Main method.
     * При тестировании StartUI, в аргумент класса ConsoleInput вставить args[0].
     * @param args - arguments
     * */
    public static void main(final String[] args) {
        if (args.length == 0) {
            tracker = new Tracker(new ConsoleInput());
        } else {
            tracker = new Tracker(new ConsoleInput(args[0]));
        }

        final int exitOperation = 7;
        int userInput = 0;
        do {
            userInput = mainMenu();
                if (userInput > 0 && userInput < exitOperation) {
                    tracker.getActions()[Integer.valueOf(userInput) - 1].action();
                    testTask = tracker.getTaskManager().getTestTask();
                }
        } while (userInput != exitOperation);
    }
    /**
     * Main menu.
     * @return user input - choosen operation
     * */
    public static int mainMenu() {
        final int firstNumberOfOperation = 1, numberOfExitOperation = 7;
        int userOperationNumber = 0;
        System.out.println("\n Choose action: \n");
        System.out.println("1. Add task");
        System.out.println("2. Edit task");
        System.out.println("3. Remove task");
        System.out.println("4. Show all tasks");
        System.out.println("5. Show task by name");
        System.out.println("6. Add comment to task");
        System.out.println("7. Exit");
        System.out.print("\nYour input: ");
        String userInput = scanner.nextLine();

            try {
                 userOperationNumber = Integer.valueOf(userInput);

                if (userOperationNumber < firstNumberOfOperation || userOperationNumber > numberOfExitOperation) {
                    userOperationNumber = -1;
                }
            }  catch (Exception e) {
                e.printStackTrace();
                System.out.println("Enter number of operation from 1 to 7");
                userOperationNumber = -1;
            }

        return userOperationNumber;
    }
    /**
     * Getter of task manager.
     * @return instance of task manager
     * */
    public static Tracker getTracker() {
        return tracker;
    }
    /**
     * Getter of created or modified task.
     * @return task
     * */
    public static Task getTestTask() {
        return testTask;
    }

    /**
     * Getter of tasks returned after operations.
     * @return array with tasks
     * */
    public static Task[] getTasks() {
        return tasks;
    }
}
