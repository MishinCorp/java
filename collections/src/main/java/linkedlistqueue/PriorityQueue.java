package linkedlistqueue;

import java.util.LinkedList;

/**
 * Class PriorityQueue.
 * Implements PriorityQueue entity.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 29.09.2018
 */
public class PriorityQueue {
    /**
     * Storage.
     */
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Method adds an entry in a specific position.
     *
     * @param aTask Task.
     */
    public final void put(final Task aTask) {
        boolean flag = true;

        if (this.tasks.isEmpty()) {
            this.tasks.add(aTask);
            flag = false;

        } else {
            for (int i = 0; i < this.tasks.size(); i++) {
                Task currentItem = this.tasks.get(i);
                if (aTask.getPriority() < currentItem.getPriority()) {
                    this.tasks.add(i, aTask);
                    flag = false;
                    break;
                }
            }
        }
        if (flag) {
            this.tasks.add(aTask);
        }

    }

    /**
     * Method retrieves and removes the first element.
     *
     * @return Task.
     */
    public final Task pollFirst() {
        return this.tasks.pollFirst();
    }

    /**
     * Method retrieves and removes the last element.
     *
     * @return Task.
     */
    public final Task pollLast() {
        return this.tasks.pollLast();
    }
}


