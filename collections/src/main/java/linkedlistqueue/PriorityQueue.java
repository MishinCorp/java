package linkedlistqueue;

import java.util.LinkedList;
import java.util.Optional;

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
     * @param pTask Task.
     */
    public final void put(final Task pTask) {
        if (this.tasks.isEmpty()) {
            this.tasks.add(pTask);
        } else {
            Optional<Task> targetTask = this.tasks.stream()
                    .filter(task -> pTask.getPriority() < task.getPriority())
                    .findFirst();
            if (targetTask.isPresent()) {
                this.tasks.add(this.tasks.indexOf(targetTask.get()), pTask);
            } else {
                this.tasks.add(pTask);
            }
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


