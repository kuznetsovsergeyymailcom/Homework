package ru.skuznetsov.menu;

import ru.skuznetsov.exceptions.UnknownOperation;

/**
 * Created by Sergey on 02.12.2016.
 */
public class Menu {
    /**
     * Method outputs main menu and returns user choose of operation.
     * @return number of operation
     * */
    public static int mainMenu() {
        String userInput = "";
        final int firstNumberOfOperation = 1, numberOfExitOperation = 7;
        int userOperationNumber = 0;
        System.out.println("\n Choose action: \n");
        System.out.println("1. Add task");
        System.out.println("2. Edit task");
        System.out.println("3. Remove task");
        System.out.println("4. Show all tasks");
        System.out.println("5. Show tasks by name");
        System.out.println("6. Add comments to task");
        System.out.println("7. Exit");
        System.out.print("\nYour input: ");
        userInput = System.console().readLine();

        try {

            userOperationNumber = Integer.valueOf(userInput);
            System.out.println("User operation number: " + userOperationNumber);
            System.out.println("User input: " + userInput);
            if (userOperationNumber < firstNumberOfOperation || userOperationNumber > numberOfExitOperation) {
                throw new UnknownOperation("Number must be from 0 to 7 please input choose again");
            }
        } catch (NumberFormatException e) {
            System.out.println("Enter number of operation from 1 to 7");
            System.out.println("User operation number: " + userOperationNumber);
            System.out.println("User input: " + userInput);
            mainMenu();
        } catch (UnknownOperation e) {
            System.out.println(e.getMessage());
            System.out.println("User operation number: " + userOperationNumber);
            System.out.println("User input: " + userInput);
            mainMenu();
        }
        return userOperationNumber;
    }
}
