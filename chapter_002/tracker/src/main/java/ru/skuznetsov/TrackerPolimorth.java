package ru.skuznetsov;

import ru.skuznetsov.intefraces.ITaskManager;

/**
 * Tracker class created 4/12/16.
 * */
public class TrackerPolimorth implements ITaskManager {
    /**
     * Instance of task manager,.
     * */
    private final ITaskManager taskManager;

    /**
     * Constructor with new task on param.
     * @param taskManager - instance inplemented task manager
     * */
    public TrackerPolimorth(ITaskManager taskManager) {
        this.taskManager = taskManager;
    }
   /**
    * Method add task to local storage.
    * */
   @Override
    public Task addTask() {
       return this.taskManager.addTask();
    }
    /**
     * Method removes task from storage by name.
     * */
    @Override
    public void removeTask() {
        this.taskManager.removeTask();
    }
    /**
     * Get array of task objects.
     * @return array task
     * */
    @Override
    public Task[] getAllTasks() {
        return this.taskManager.getAllTasks();
    }

    /**
     * Get task by name.
     * @return task by name
     * */
    @Override
    public Task getTaskByName() {
        return this.taskManager.getTaskByName();
    }
    /**
     * Edit task by name.
     * */
    @Override
    public Task editTaskByName() {
        return this.taskManager.editTaskByName();
    }
    /**
     * Add comment to task.
     * */
    @Override
    public Task addCommentToTask() {
        return this.taskManager.addCommentToTask();
    }
    /**
     * Get task by name for tests.
     *
     * */
    @Override
    public Task getTaskByName(String name) {
        return taskManager.getTaskByName(name);
    }
}
