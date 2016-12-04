package ru.skuznetsov;
/**
 * Comment class created 04.12.16.
 * */
public class Comment {
    /**
     * Description of comment.
     **/
    private String description = "";
    /**
     * Default constructor without args.
     * */
    public Comment() {
    }
    /**
     * Constructor with arg description.
     * @param description - description of task
     * */
    public Comment(String description) {
        this.description = description;
    }

    /**
     * Getter of description.
     * @return description of comment
     * */
    public String getDescription() {
        return this.description;
    }
    /**
     * Setter of description.
     * @param description - descriptiokn of comment
     * */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * String representation of comment.
     * @return string view of comment
     * */
    @Override
    public String toString() {
        return "Comment{description=\'" + this.description + '\'' + '}';
    }
    /**
     * Equals method.
     * @param o - over comment
     * @return true if task equals over task
     * */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Comment comment = (Comment) o;
            return this.description != null
                        ? this.description.equals(comment.description)
                        : comment.description == null;
        } else {
            return false;
        }
    }
    /**
     * Hash code of comment.
     * @return hash code
     * */
    @Override
    public int hashCode() {
        return this.description != null ? this.description.hashCode() : 0;
    }
}
