package ru.skuznetsov;

/**
 * Created by Sergey on 04.12.2016.
 */
public class Comment {
    /**
     * Descripiton of comment.
     * */
    private String description = "";
    /**
     * Default empty constructor.
     * */
    public Comment() { }
    /**
     * Constructor with description.
     * @param description - description of comment
     * */
    public Comment(String description) {
        this.description = description;
    }
    /**
     * Description of comment.
     * @return description
     * */
    public String getDescription() {
        return description;
    }
    /**
     * Setter of description.
     * @param description - new description of comment
     * */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Overrided to string method.
     * @return string representation of comment
     * */
    @Override
    public String toString() {
        return "Comment{" + "description='" + description + '\'' + '}';
    }
    /**
     * Equals method to compare objects.
     * @param o over comment
     * @return true if objects are equals
     * */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Comment comment = (Comment) o;

        return description != null ? description.equals(comment.description) : comment.description == null;
    }
    /**
     * Hash code of comment.
     * @return hash code
     * */
    @Override
    public int hashCode() {
        return description != null ? description.hashCode() : 0;
    }
}
