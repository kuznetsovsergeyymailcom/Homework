package ru.skuznetsov;

/**
 * Created by Sergey on 27.11.2016.
 */
public class Paint {
    /**
     * pyramid container.
     * */
    private StringBuilder builder = new StringBuilder();
    /**
     * symbol of pyramid.
     * */
    private final char symbol = '^';
/**
 * Method creates pyramid.
 * @param height - height of pyramid
 * */
    public void initPiramida(final int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Piramida cannot have height less or equal to 0");
        }
        for (int i = 1; i <= height; i++) {
            for (int j = height; j > i; j--) {
                builder.append(" ");
            }
            for (int k = 1; k <= i; k++) {
                builder.append(symbol);
                builder.append(" ");
            }
            builder.append("\n");
        }
    }
    /**
     * Overrided to string method.
     * @return final pyramid
     * */
    @Override
    public String toString() {
        return builder.toString();
    }
}
