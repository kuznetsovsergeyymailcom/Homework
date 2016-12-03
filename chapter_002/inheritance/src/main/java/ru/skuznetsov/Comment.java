package ru.skuznetsov;

/**
 * Created by Sergey on 30.11.2016.
 */
public class Comment {
    /**
     * Description of comment.
     * */
    private String desctiption;
    /**
     * Default constructor.
     * */
    public Comment() { }
    /**
     * Main constructor.
     * @param desctiption - description of comment
     * */
    public Comment(String desctiption) {
        this.desctiption = desctiption;
    }
    /**
     * String value of object.
     * @return string representation of object
     * */
    @Override
    public String toString() {
        return "Comment{"
                + "desctiption='" + desctiption + '\'' + '}';
    }
    /**
     * Getter of description.
     * @return description of comment
     * */
    public String getDesctiption() {
        return desctiption;
    }
    /**
     * Setter of description.
     * @param desctiption - description of comment
     * */
    public void setDesctiption(String desctiption) {
        this.desctiption = desctiption;
    }
}
