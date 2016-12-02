package ru.skuznetsov;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * Created by Sergey on 30.11.2016.
 */
public class Task {
    /**
     * Name of task.
     * */
    private String name;
    /**
     * Description of task.
     * */
    private String description;
    /**
     * Date of creation.
     * */
    private LocalDateTime dateOfCreation;
    /**
     * Array of comments.
     * */
    private Comment[] comments = new Comment[0];
    /**
     * Default constructor.
     * */
    public Task() { }
    /**
     * Task constructor without comments.
     * @param name - name of task
     * @param description - description of task
     * */
    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        this.setDateOfCreation();
    }
    /**
     * Adding comments to task.
     * @param comment - new comment
     * */
    public void addComment(Comment comment) {
        int lenght = this.comments.length;
        // выделяем массив размером на 1 больше старого
        Comment[] newComments = new Comment[lenght + 1];
        // Переносим комментарии из старого массива в новый
        if (lenght > 0) {
            for (int i = 0; i < lenght; i++) {
                newComments[i] = this.comments[i];
            }
        }
        // Вставляем новое значение в конец
        newComments[lenght] = comment;
        // Копируем массив
        this.comments = newComments;
    }
    /**
     * Method returns name of task.
     * @return name of task
     * */
    public String getName() {
        return name;
    }
    /**
     * Setter of task name.
     * @param name - new name of task
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
     * Setter of description.
     * @param description - description of task
     * */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Getter of comments array.
     * @return method return array of comments
     * */
    public Comment[] getComments() {
        return comments;
    }
    /**
     * Setter of creation date.
     * @return date of creation
     * */
    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }
    /**
     * Getter of creation.
     * */
    private void setDateOfCreation() {
        this.dateOfCreation = LocalDateTime.now();
    }

    /**
     * Setter of comments.
     * @param comments - new comment
     * */
    public void setComments(Comment[] comments) {
        this.comments = comments;
    }
    /**
     * String representation of task.
     * @return string view of object
     * */
    @Override
    public String toString() {
        return "Task {"
                + "name = '" + name + '\'' + ", description = '" + description + '\''
                + ", dateOfCreation = " + dateOfCreation + ", comments = " + Arrays.toString(comments) + '}' + "\n";
    }
}
