package ru.skuznetsov;

import ru.skuznetsov.intefraces.IAction;
import ru.skuznetsov.intefraces.ITaskManager;

/**
 * Tracker class created 4/12/16.
 * */
public class TrackerPolimorth {
    /**
     * Count of operations.
     * */
    private final int countOfOperations = 6;
    /**
     * Array of operations.
     * */
    private IAction[] abstractActions = new IAction[countOfOperations];

    /**
     * Instance of task manager,.
     * */
    private final ITaskManager taskManager;

    /**
     * Constructor with new task on param.
     * @param taskManager - instance inplemented task manager
     * */
    public TrackerPolimorth(ITaskManager taskManager) {
        this.taskManager = taskManager;
        initTaskCollection();
    }
    /**
     * Method init collection of actions.
     * */
    private void initTaskCollection() {
        final int index0 = 0, index1 = 1, index2 = 2, index3 = 3, index4 = 4, index5 = 5;
        abstractActions[index0] = new AddTask();
        abstractActions[index1] = new EditTask();
        abstractActions[index2] = new RemoveTask();
        abstractActions[index3] = new GetAllTasks();
        abstractActions[index4] = new GetTaskByName();
        abstractActions[index5] = new AddCommentToTask();
    }
    /**
     * Cover class have action method with launching add task operation on instance of task manager.
     * */
    public class AddTask implements IAction {

        /**
         * Action method with launching point of add task method on task manager instance.
         * */
        @Override
        public void action() {
            taskManager.addTask();
        }
        /**
         * Cap method.
         * @param name - name of task
         * */
        @Override
        public void action(String name) { }

    }
    /**
     * Cover class have action method with launching ADD task operation on instance of task manager.
     * */
    public class EditTask implements IAction {

        /**
         * Action method with launching point of EDIT task method on task manager instance.
         * */
        @Override
        public void action() {
            taskManager.editTaskByName();
        }
        /**
         * Action method with launching point of EDIT task method on task manager instance.
         * @param name - name of task
         * */
        @Override
        public void action(String name) { }

    }
    /**
     * Cover class have action method with launching ADD task operation on instance of task manager.
     * */
    public class RemoveTask implements IAction {
        /**
         * Action method with launching point of REMOVE task method on task manager instance.
         * */
        @Override
        public void action() {
            taskManager.removeTask();
        }
        /**
         * Cap method.
         * @param name - name of task
         * */
        @Override
        public void action(String name) { }

    }
    /**
     * Cover class have action method with launching GET TASK BY NAME task operation on instance of task manager.
     * */
    public class GetTaskByName implements IAction {

        /**
         * Action method with launching point of GET TASK BY NAME task method on task manager instance.
         * */
        @Override
        public void action() {
            taskManager.getTaskByName();
        }
        /**
         * Action with name of task on param.
         * @param name - name of task
         * */
        @Override
        public void action(String name) {
            taskManager.getTaskByName(name);
        }

    }
    /**
     * Cover class have action method with launching GET ALL task operation on instance of task manager.
     * */
    public class GetAllTasks implements IAction {

        /**
         * Action method with launching point of task method on task manager instance.
         * */
        @Override
        public void action() {
            taskManager.getAllTasks();
        }
        /**
         * Action method with launching point of task method on task manager instance.
         * @param name - name of task
         * */
        @Override
        public void action(String name) { }

    }
    /**
     * Cover class have action method with launching ADD COMMENT TO TASK task operation on instance of task manager.
     * */
    public class AddCommentToTask implements IAction {

        /**
         * Action method with launching point of task method on task manager instance.
         * @return modified task
         * */
        @Override
        public void action() {
            taskManager.addCommentToTask();
        }
        /**
         * Action method with launching point of task method on task manager instance.
         * @return modified task
         * */
        @Override
        public void action(String name) { }

    }

    /**
     * Getter of actions.
     * @return actions array
     * */
    public IAction[] getActions() {
        return abstractActions;
    }
    /**
     * Getter for task manager.
     * @return instance implemented ITaskManager interface
     * */
    public ITaskManager getTaskManager() {
        return taskManager;
    }
}
