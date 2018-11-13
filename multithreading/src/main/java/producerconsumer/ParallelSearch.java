package producerconsumer;

/**
 * Class ParallelSearch.
 * Implements entity ParallelSearch.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 28.10.2018
 */
public final class ParallelSearch {
    /**
     * Count.
     */
    public static final int COUNT = 3;
    /**
     * Sleep.
     */
    public static final int SLEEP = 500;

    /**
     * Constructor.
     */
    private ParallelSearch() {
    }

    /**
     * Main method.
     *
     * @param args Args.
     */
    public static void main(final String[] args) {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<Integer>();

        final Thread consumer = new Thread(
                () -> {
                    while (true) {
                        try {
                            Integer result = queue.poll();
                            if (result == -1) {
                                return;
                            }
                            System.out.println(result);
                        } catch (Exception e) {
                            e.printStackTrace();
                            Thread.currentThread().interrupt();
                        }
                    }
                }
        );
        consumer.start();

        new Thread(
                () -> {
                    for (int index = 0; index != COUNT; index++) {
                        queue.offer(index);
                        try {
                            Thread.sleep(SLEEP);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.offer(-1);
                }
        ).start();
    }
}
