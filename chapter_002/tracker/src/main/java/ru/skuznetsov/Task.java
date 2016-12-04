package ru.skuznetsov;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * Class task created 04.12.16.
 * */
public class Task {
    /**
     * Random generated id of task.
     * */
    private String id;
    /**
     * Name of task.
     * */
    private String name;
    /**
     * Description of task.
     * */
    private String description = "";
    /**
     * Date of creation.
     * */
    private long dateOfCreation;
    /**
     * Storage of comments.
     * */
    private Comment[] comments = new Comment[0];
    /**
     * Generator of random number.
     * */
    private Random random = new Random();
    /**
     * Default constructor without args.
     * */
    public Task() {
    }
    /**
     * Constructor with args.
     * @param name - name of task
     * @param description - description of task
     * */
    public Task(String name, String description) {
        final int bound = 100;
        this.name = name;
        this.description = description;
        this.id = String.valueOf(this.random.nextInt(bound));
        this.setDateOfCreation();
    }
    /**
     * Constructor with args.
     * @param id - id of task
     * @param name - name of task
     * @param description - description of task
     * */
    public Task(String id, String name, String description) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.setDateOfCreation();
    }
    /**
     * Constructor with args.
     * @param id - id of task
     * @param name - name of task
     * @param description - description of task
     * @param comment - new comment of task
     * */
    public Task(String id, String name, String description, Comment comment) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.setDateOfCreation();
        this.addComment(comment);
    }
    /**
     * Getter of id.
     * @return id
     * */
    public String getId() {
        return this.id;
    }
    /**
     * Setter of id.
     * @param id - id of task
     * */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * Getter of name.
     * @return name
     * */
    public String getName() {
        return this.name;
    }
    /**
     * Setter of name.
     * @param name - name of task
     * */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Description of task.
     * @return description
     * */
    public String getDescription() {
        return this.description;
    }
    /**
     * Setter of description.
     * @param description - description of task
     * */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Getter of comments.
     * @return array of comments
     * */
    public Comment[] getComments() {
        return this.comments;
    }
    /**
     * Add comment to storage.
     * @param comment - new comment
     * */
    public void addComment(Comment comment) {
        Comment[] temp = new Comment[this.comments.length + 1];
        System.arraycopy(this.comments, 0, temp, 0, this.comments.length);
        temp[this.comments.length] = comment;
        this.comments = temp;
    }
    /**
     * Getter of creation date.
     * @return date in long type
     * */
    public long getDateOfCreation() {
        return this.dateOfCreation;
    }
    /**
     * Setter of creation date.
     * */
    public void setDateOfCreation() {
        this.dateOfCreation = (new Date()).getTime();
    }
    /**
     * Method to change creation date.
     * Made for testing.
     * @param newDate - new date of creation
     * */
    public void changeDateOfCreation(long newDate) {
        this.dateOfCreation = newDate;
    }
    /**
     * Overriden string version of task.
     * @return string representation of object
     * */
    @Override
    public String toString() {
        return "Task{id=\'" + this.id + '\'' + ", name=\'" + this.name + '\'' + ", description=\'" + this.description + '\'' + ", dateOfCreation=" + new Date(this.dateOfCreation) + ", comments=" + Arrays.toString(this.comments) + '}';
    }
    /**
     * Task equals over task.
     * @param o - over task
     * @return true if tsaks equals
     * */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Task task = (Task) o;
            if (this.name != null) {
                if (!this.name.equals(task.name)) {
                    return false;
                }
            } else if (task.name != null) {
                return false;
            }

            if (this.description != null) {
                if (this.description.equals(task.description)) {
                    return Arrays.equals(this.comments, task.comments);
                }
            } else if (task.description == null) {
                return Arrays.equals(this.comments, task.comments);
            }

            return false;
        } else {
            return false;
        }
    }
    /**
     * Hsh code of task.
     * @return hash code
     * */
    @Override
    public int hashCode() {
        final int genNum = 31;
        int result = this.name != null ? this.name.hashCode() : 0;
        result = genNum * result + (this.description != null ? this.description.hashCode() : 0);
        result = genNum * result + Arrays.hashCode(this.comments);
        return result;
    }
}
