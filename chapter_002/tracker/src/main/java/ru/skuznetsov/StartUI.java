package ru.skuznetsov;

import ru.skuznetsov.input.ConsoleInput;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Sergey on 05.12.2016.
 */
public class StartUI {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        Tracker_polimorph tracker_polimorph = new Tracker_polimorph(
//                new StubInput(
//                        new Task[]{new Task("task1", "desc1"),
//                                new Task("task2", "desc2"),
//                                new Task("task3", "desc3")}));
        Tracker_polimorph tracker_polimorph = new Tracker_polimorph(new ConsoleInput());

        final int exitOperation = 7, add = 1, edit = 2, remove = 3, showAll = 4, showSpec = 5, addComment = 6;
        int userInput = 0;
        while ((userInput = mainMenu()) != exitOperation) {
            switch (userInput) {
                case add:
                    tracker_polimorph.addTask();
                    break;
                case edit:
                    tracker_polimorph.editTaskByName();
                    break;
                case remove:
                    try {
                        tracker_polimorph.removeTask();
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Unknown name of task");
                    } finally {
                        break;
                    }
                case showAll:
                    System.out.println(Arrays.toString(tracker_polimorph.getAllTasks()));
                    break;
                case showSpec:
                    System.out.println(tracker_polimorph.getTaskByName());
                    break;
                case addComment:
                    tracker_polimorph.addCommentToTask();
                    break;
                default:
                    System.out.println("Unknown operation");
            }
        }

    }
    public static int mainMenu() {
        String userInput = "";
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
        userInput = scanner.next();

        try {

            userOperationNumber = Integer.valueOf(userInput);
            if (userOperationNumber < firstNumberOfOperation || userOperationNumber > numberOfExitOperation) {
                mainMenu();
            }
        } catch (NumberFormatException e) {
            System.out.println("Enter number of operation from 1 to 7");
            mainMenu();
        }
        return userOperationNumber;
    }
}
