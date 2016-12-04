package ru.skuznetsov;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * Created by Sergey on 04.12.2016.
 */
public class Task {
    /**
     * random id of task.
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
     * Date of description of task.
     * */
    private long dateOfCreation;
    /**
     * Storage of comments.
     * */
    private Comment[] comments = new Comment[0];
    /**
     * Random generator.
     * */
    private Random random = new Random();
    /**
     * Default empty constructor.
     * */
    public Task() { }
    /**
     * Constructor with two params: name and description.
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
     * Constructor with two params: id, name and description and new comment.
     * @param id - random generated id of task
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
     * Constructor with two params: id, name and description and new comment.
     * @param id - random generated id of task
     * @param name - name of task
     * @param description - description of task
     * @param comment - new comment of task
     * */
    public Task(String id, String name, String description, Comment comment) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.setDateOfCreation();
        addComment(comment);
    }
    /**
     * Getter of id.
     * @return id of task
     * */
    public String getId() {
        return id;
    }
    /**
     * Setter of id.
     * @param id - random id of task.
     * */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * Getter of task name.
     * @return name of task
     * */
    public String getName() {
        return name;
    }
    /**
     * Setter of task name.
     * @param name - naem of task
     * */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Getter of description.
     * @return description of task
     * */
    public String getDescription() {
        return description;
    }
    /**
     * Setter of descripiton.
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
        return comments;
    }
    /**
     * Method add new comment to comments storage.
     * @param comment - new comment for task
     * */
    public void addComment(Comment comment) {
        Comment[] temp = new Comment[this.comments.length + 1];
        System.arraycopy(this.comments, 0, temp, 0, this.comments.length);
        temp[this.comments.length] = comment;
        this.comments = temp;
    }
    /**
     * Setter of creation date.
     * @return date of creation
     * */
    public long getDateOfCreation() {
        return dateOfCreation;
    }
    /**
     * Getter of creation.
     * */
    public void setDateOfCreation() {
        this.dateOfCreation = new Date().getTime();
    }
    /**
     * Getter of creation.
     * @param newDate - new date of creation
     * */
    public void changeDateOfCreation(long newDate) {
        this.dateOfCreation = newDate;
    }
    /**
     * String representation of task.
     * @return string view of task
     * */
    @Override
    public String toString() {
        return "Task{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", description='" + description + '\''
                + ", dateOfCreation=" + new Date(dateOfCreation) + ", comments=" + Arrays.toString(comments) + '}';
    }
    /**
     * Method equals this task and argument object.
     * @param o - over object
     * @return true if objects equals
     * */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Task task = (Task) o;

        if (name != null ? !name.equals(task.name) : task.name != null) {
            return false;
        }
        if (description != null ? !description.equals(task.description) : task.description != null) {
            return false;
        }
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(comments, task.comments);
    }
    /**
     * Hash code of task.
     * @return hash code
     * */
    @Override
    public int hashCode() {
        final int genNum = 31;
        int result = name != null ? name.hashCode() : 0;
        result = genNum * result + (description != null ? description.hashCode() : 0);
        result = genNum * result + Arrays.hashCode(comments);
        return result;
    }
}
