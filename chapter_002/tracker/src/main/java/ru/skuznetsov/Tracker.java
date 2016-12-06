package ru.skuznetsov;

/**
 * Tracker class created 4/12/16.
 * */
public class Tracker {
    /**
     * Initial length of storage.
     * */
    private final int firstLength = 5;
    /**
     * local storage.
     * */
    private Task[] tasks = new Task[firstLength];
    /**
     * Position of index.
     * */
    private int position = 0;
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
        final int chisl = 2, znam = 3;
        if (position == ((this.tasks.length * chisl) / znam)) {
            Task[] temp = new Task[this.tasks.length * chisl];
            System.arraycopy(this.tasks, 0, temp, 0, position);
            temp[position++] = task;
            this.tasks = temp;
        } else {
            this.tasks[position++] = task;
        }
    }
    /**
     * Method removes task crom storage by name.
     * @param name - name of task
     * */
    public void removeTask(String name) {
        Task[] temp = new Task[getAllTasks().length - 1];
        int j = 0;
        if (this.isTaskExists(name)) {
            for (int i = 0; i < getAllTasks().length; ++i) {
                Task task = this.tasks[i];
                if (!task.getName().equals(name)) {
                    temp[j++] = task;
                }
            }
            this.position--;
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
        Task[] tasks = new Task[position];
        for (int i = 0; i < position; i++) {
            tasks[i] = this.tasks[i];
        }
        return tasks;
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
        int start = from <= to ? from : to;
        int finish = from >= to ? from : to;

        for (int i = 0; i < getAllTasks().length; ++i) {
            Task task = this.tasks[i];
            int id = Integer.valueOf(task.getId()).intValue();
            if (start <= id && id <= finish) {
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
        for (int i = 0; i < getAllTasks().length; ++i) {
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

        for (int i = 0; i < getAllTasks().length; ++i) {
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

            for (int i = 0; i < getAllTasks().length; ++i) {
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

        for (int i = 0; i < getAllTasks().length; ++i) {
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
        int start = from <= to ? from : to, largest = from >= to ? from : to;

        for (int i = 0; i < getAllTasks().length; ++i) {
            Task task = this.tasks[i];
            int id = Integer.valueOf(task.getId()).intValue();
            if (start <= id && id <= largest) {
                ++count;
            }
        }

        return count;
    }
    /**
     * Getter for position.
     * @return position in tasks array
     * */
    public int getPosition() {
        return this.position;
    }

}
