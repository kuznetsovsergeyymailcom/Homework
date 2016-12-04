package ru.skuznetsov.interfaces;

/**
 * Created by Sergey on 30.11.2016.
 */
public interface ITaskManager {
    /**
     * Adding task to task array.
     * */
    void addTask();
    /**
     * Edit task.
     * */
    void editTask();
    /**
     * Removing task.
     * */
    void removeTask();
    /**
     * Method shows all tasks.
     * */
    void showAllTasks();
    /**
     * Show specified task.
     * */
    void showSpecifiedTask();
    /**
     * Adding comment to specified task.
     * */
    void addCommentToTask();

}
