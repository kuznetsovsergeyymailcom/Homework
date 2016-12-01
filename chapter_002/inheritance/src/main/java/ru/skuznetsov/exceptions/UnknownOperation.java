package ru.skuznetsov.exceptions;

/**
 * Created by Sergey on 30.11.2016.
 */
public class UnknownOperation extends Exception {
    /**
     * Exception throws then user makes wrong input.
     * @param message - text of error
     * */
    public UnknownOperation(String message) {
        super(message);
    }
}
