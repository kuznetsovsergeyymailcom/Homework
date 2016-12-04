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
            Task[] var4 = this.tasks;
            int var5 = var4.length;

            for (int var6 = 0; var6 < var5; ++var6) {
                Task task = var4[var6];
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
        Task[] var5 = this.tasks;
        int var6 = var5.length;

        for (int var7 = 0; var7 < var6; ++var7) {
            Task task = var5[var7];
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
        Task[] var2 = this.tasks;
        int var3 = var2.length;

        for (int var4 = 0; var4 < var3; ++var4) {
            Task task = var2[var4];
            if (task.getName().equals(name)) {
                return task;
            }
        }

        return null;
    }
    /**
     * Edit task by name.
     * @param name - name of task
     * @param newName - new name of task
     * @param newDescription - new description
     * */
    public void editTaskByName(String name, String newName, String newDescription) {
        Task[] var4 = this.tasks;
        int var5 = var4.length;

        for (int var6 = 0; var6 < var5; ++var6) {
            Task task = var4[var6];
            if (task.getName().equals(name)) {
                task.setName(newName);
                task.setDescription(newDescription);
            }
        }

    }
    /**
     * Add comment to task.
     * @param nameOfTask - name of task
     * @param comment - new comment
     * */
    public void addCommentsToTask(String nameOfTask, Comment comment) {
        if (this.isTaskExists(nameOfTask)) {
            Task[] var3 = this.tasks;
            int var4 = var3.length;

            for (int var5 = 0; var5 < var4; ++var5) {
                Task task = var3[var5];
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
        Task[] var3 = this.tasks;
        int var4 = var3.length;

        for (int var5 = 0; var5 < var4; ++var5) {
            Task task = var3[var5];
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
        Task[] var4 = this.tasks;
        int var5 = var4.length;

        for (int var6 = 0; var6 < var5; ++var6) {
            Task task = var4[var6];
            if ((from <= to ? from : to) <= Integer.valueOf(task.getId()).intValue()
                    && Integer.valueOf(task.getId()).intValue() <= (from >= to ? from : to)) {
                ++count;
            }
        }

        return count;
    }
    /**
     * Main method.
     * @param args - arguments of main method
     * */
    public static void main(String[] args) {

    }
}
