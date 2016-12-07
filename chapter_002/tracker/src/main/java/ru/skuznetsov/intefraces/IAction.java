package ru.skuznetsov.intefraces;

/**
 * Created by Sergey on 07.12.2016.
 */
public interface IAction {
    /**
     * Method launch operation.
     * */
    void action();
    /**
     * Method launch operation with name on args.
     * @param name - name of task
     * */
    void action(String name);
}

