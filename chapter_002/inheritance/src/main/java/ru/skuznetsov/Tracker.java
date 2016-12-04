package ru.skuznetsov;
/**
 * Created by Sergey on 30.11.2016.
 */
public class Tracker {
    /**
     * Tasks storage.
     * */
    private Task[] tasks = new Task[0];
    /**
     * Add task to storage.
     * @param task - new task
     * */
    public void addTask(Task task) {
        Task[] temp = new Task[this.tasks.length + 1];
        System.arraycopy(this.tasks, 0, temp, 0, this.tasks.length);
        temp[this.tasks.length] = task;
        this.tasks = temp;
    }
    /**
     * remove task by name.
     * @param name - name of task
     * */
    public void removeTask(String name) {
        Task[] temp = new Task[this.tasks.length - 1];
        int j = 0;

        if (isTaskExists(name)) {
            for (Task task : this.tasks) {
                if (!task.getName().equals(name)) {
                    temp[j++] = task;
                }
            }
        } else {
            throw new IllegalArgumentException("Unknown name of task");
        }
        this.tasks = temp;
    }
    /**
     * Get all tasks.
     * @return all tasks
     * */
    public Task[] getAllTasks() {
        return this.tasks;
    }
    /**
     * Get all tasks by range of id.
     * @param from - start number of range
     * @param to - last number of range
     * @return all tasks by range
     * */
    public Task[] getTasksByRangeOfId(int from, int to) {
        Task[] temp = new Task[countOfItemsInRangeOfId(from, to)];
        int index = 0;
        for (Task task : this.tasks) {
            if ((from <= to ? from : to) <= Integer.valueOf(task.getId())
                    && Integer.valueOf(task.getId()) <= (from >= to ? from : to)) {
                temp[index] = task;
                index++;
            }
        }
        return temp;
    }
    /**
     * Get task by name.
     * @param name - name of task
     * @return task by name
     * */
    public Task getTaskByName(String name) {
        for (Task task : this.tasks) {
            if (task.getName().equals(name)) {
                return task;
            }
        }
        return null;
    }
    /**
     * Change name, description of task by name.
     * @param name - name of task
     * @param newName - new name of task
     * @param newDescription - new description of task
     * */
    public void editTaskByName(String name, String newName, String newDescription) {
        for (Task task : this.tasks) {
            if (task.getName().equals(name)) {
                task.setName(newName);
                task.setDescription(newDescription);
            }
        }
    }
    /**
     * Add comment to task.
     * @param nameOfTask - name of task
     * @param comment - new comment of task
     * */
    public void addCommentsToTask(String nameOfTask, Comment comment) {
        if (isTaskExists(nameOfTask)) {
            for (Task task : this.tasks) {
                if (task.getName().equals(nameOfTask)) {
                    task.addComment(comment);
                }
            }
        } else {
            throw new IllegalArgumentException("Unknown name of task");
        }
    }
    /**
     * Check is task exists by name.
     * @param name - name of task
     * @return true if task exists
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
    /**
     * Calculate count of items by range of id.
     * @param from - start value of range
     * @param to - last value of range
     * @return count of items
     * */
    private int countOfItemsInRangeOfId(int from, int to) {
        int count = 0;
        for (Task task : this.tasks) {
            if ((from <= to ? from : to) <= Integer.valueOf(task.getId())
                    && Integer.valueOf(task.getId()) <= (from >= to ? from : to)) {
                count++;
            }
        }
        return count;
    }

}
