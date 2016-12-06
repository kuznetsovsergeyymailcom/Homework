package ru.skuznetsov.intefraces;

import ru.skuznetsov.Task;

/**
 * Created by Sergey on 05.12.2016.
 */
public interface ITaskManager {
    Task addTask();
    Task addCommentToTask();
    Task editTaskByName();
    void removeTask();
    Task getTaskByName();
    Task getTaskByName(String name);
    Task[] getAllTasks();

}
