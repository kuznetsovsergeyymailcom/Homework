package ru.skuznetsov;

/**
 * Created by Sergey on 30.11.2016.
 */
public class Tracker {
    /**
     * Main method.
     * @param args - arguments of main method
     * @throws InterruptedException - method can throws interrupted exception
     * */
    public static void main(String[] args) throws InterruptedException {
        final int exitOperation = 7, sleep_time = 1000, add = 1, edit = 2, remove = 3, showAll = 4, showSpec = 5, addComment = 6;
        TaskManager taskManager = TaskManager.getTaskManager();
        System.out.println("\nWelcome to task tracker");
        int userInput = 0;
        while ((userInput = taskManager.mainMenu()) != exitOperation) {
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

            Thread.sleep(sleep_time);
        }

    }
}
