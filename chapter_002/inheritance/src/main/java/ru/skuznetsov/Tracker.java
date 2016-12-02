package ru.skuznetsov;

import ru.skuznetsov.menu.Menu;

/**
 * Created by Sergey on 30.11.2016.
 */
public abstract class Tracker {
    /**
     * Main method.
     * @param args - arguments of main method
     * */
    public static void main(String[] args) {
        final int exitOperation = 7, add = 1, edit = 2, remove = 3, showAll = 4, showSpec = 5, addComment = 6;
        TaskManager taskManager = TaskManager.getTaskManager();
        System.out.println("\nWelcome to task tracker");
        int userInput = 0;
        while ((userInput = Menu.mainMenu()) != exitOperation) {
                switch (userInput) {
                    case add: taskManager.addTask(); break;
                    case edit: taskManager.editTask(); break;
                    case remove: taskManager.removeTask(); break;
                    case showAll: taskManager.showAllTasks(); break;
                    case showSpec: taskManager.showSpecifiedTask(); break;
                    case addComment: taskManager.addCommentToTask(); break;
                    default:
                        System.out.println("Unknown operation");
                }
        }

    }
}
