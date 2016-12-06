package ru.skuznetsov;
/**
 * Tracker class created 4/12/16.
 * */
public class Tracker {
    /**
     * local storage.
     * */
    private Task[] tasks = new Task[0];
    /**
     * Default constructor without args.
     * */
    public Tracker() {
    }
    /**
     * Constructor with new task on param.
     * @param task - new task
     * */
    public void addTask(Task task) {
        Task[] temp = new Task[this.tasks.length + 1];
        System.arraycopy(this.tasks, 0, temp, 0, this.tasks.length);
        temp[this.tasks.length] = task;
        this.tasks = temp;
    }
    /**
     * Method removes task crom storage by name.
     * @param name - name of task
     * */
    public void removeTask(String name) {
        Task[] temp = new Task[this.tasks.length - 1];
        int j = 0;
        if (this.isTaskExists(name)) {

            for (int i = 0; i < this.tasks.length; ++i) {
                Task task = this.tasks[i];
                if (!task.getName().equals(name)) {
                    temp[j++] = task;
                }
            }

            this.tasks = temp;
        } else {
            throw new IllegalArgumentException("Unknown name of task");
        }
    }
    /**
     * Get array of task objects.
     * @return array task
     * */
    public Task[] getAllTasks() {
        return this.tasks;
    }
    /**
     * Get task by range of id.
     * @param from - start index
     * @param to -last index
     * @return array of tasks
     * */
    public Task[] getTasksByRangeOfId(int from, int to) {
        Task[] temp = new Task[this.countOfItemsInRangeOfId(from, to)];
        int index = 0;

        for (int i = 0; i < this.tasks.length; ++i) {
            Task task = this.tasks[i];
            if ((from <= to ? from : to) <= Integer.valueOf(task.getId()).intValue()
                        && Integer.valueOf(task.getId()).intValue() <= (from >= to ? from : to)) {
                temp[index] = task;
                ++index;
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
        for (int i = 0; i < this.tasks.length; ++i) {
            Task task = this.tasks[i];
            if (task.getName().equals(name)) {
                return task;
            }
        }

        return null;
    }
    /**
     * Edit task by name.
     * @param name - name of task
     * @param task - new task
     * */
    public void editTaskByName(String name, Task task) {

        for (int i = 0; i < this.tasks.length; ++i) {
            Task tempTask = this.tasks[i];
            if (tempTask.getName().equals(name)) {
                tempTask.setName(task.getName());
                tempTask.setDescription(task.getDescription());
            }
        }
    }
    /**
     * Add comment to task.
     * @param nameOfTask - name of task
     * @param comment - new comment
     * */
    public void addCommentToTask(String nameOfTask, Comment comment) {
        if (this.isTaskExists(nameOfTask)) {

            for (int i = 0; i < this.tasks.length; ++i) {
                Task task = this.tasks[i];
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

        for (int i = 0; i < this.tasks.length; ++i) {
            Task task = this.tasks[i];
            if (task.getName().equals(name)) {
                exists = true;
            }
        }

        return exists;
    }
    /**
     * Count of items in range.
     * @param from - start index
     * @param to - last index
     * @return count
     * */
    private int countOfItemsInRangeOfId(int from, int to) {
        int count = 0;

        for (int i = 0; i < this.tasks.length; ++i) {
            Task task = this.tasks[i];
            if ((from <= to ? from : to) <= Integer.valueOf(task.getId()).intValue()
                    && Integer.valueOf(task.getId()).intValue() <= (from >= to ? from : to)) {
                ++count;
            }
        }

        return count;
    }

}
