package ru.skuznetsov.intefraces;

import ru.skuznetsov.Task;

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
     * */
    void removeTask();
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
    Task getTaskByName(String name);
    /**
     * Get all task.
     * @return all tasks
     * */
    Task[] getAllTasks();

}
