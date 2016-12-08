package ru.skuznetsov.intefraces;

import ru.skuznetsov.Task;

import java.util.Scanner;

/**
 * Created by Sergey on 05.12.2016.
 */
public interface ITaskManager {
    /**
     * Add task.
     * @return added task
     * */
    Task addTask();
    /**
     * Add comment to task.
     * @return task with added comment
     * */
    Task addCommentToTask();
    /**
     * Edit task by name.
     * @return edited task
     * */
    Task editTaskByName();
    /**
     * Remove task.
     * @return removed task
     * */
    Task removeTask();
    /**
     * Get task by name.
     * @return task
     * */
    Task getTaskByName();
    /**
     * Get task by name.
     * @param name - name of task
     * @return task
     * */
    Task getTaskByName(final String name);
    /**
     * Get all task.
     * @return all tasks
     * */
    Task[] getAllTasks();

    /**
     * Getter for test task.
     * @return Task
     * */
    Task getTestTask();
    /**
     * Getter for scanner.
     * @return scanner instance
     * */
    Scanner getScanner();
}
