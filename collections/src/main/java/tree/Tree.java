package tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Class Tree.
 * Implements TreeInterface.
 *
 * @param <E> Element.
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 24.10.2018
 */
public class Tree<E extends Comparable<E>> implements TreeInterface<E> {
    /**
     * THREE.
     */
    private static final int THREE = 3;
    /**
     * The root.
     */
    private Node<E> root;
    /**
     * Size.
     */
    private int size = 0;

    /**
     * Constructor.
     *
     * @param pRootData Root.
     */
    public Tree(final E pRootData) {
        this.root = new Node<>(pRootData);
        this.size++;
    }

    @Override
    public final boolean add(final E pParent, final E pChild) {
        boolean result = false;
        Optional<Node<E>> parentNode = findBy(pParent);
        Optional<Node<E>> childNode = findBy(pChild);
        if (parentNode.isPresent() && !childNode.isPresent()) {
            parentNode.get().add(new Node<>(pChild));
            this.size++;
            result = true;
        }
        return result;
    }

    @Override
    public final Optional<Node<E>> findBy(final E pValue) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(pValue)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.leaves());
        }
        return rsl;
    }

    @Override
    public final Iterator<E> iterator() {
        return new Iterator<E>() {
            private Queue<Node<E>> list = new LinkedList<>(Arrays.asList(root));

            @Override
            public boolean hasNext() {
                return !list.isEmpty();
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<E> node = list.poll();
                list.addAll(node.leaves());
                return node.getValue();
            }
        };
    }

    /**
     * Method checks if the tree is binary.
     *
     * @return boolean.
     */
    public final boolean isBinary() {
        boolean result = true;
        Queue<Node<E>> list = new LinkedList<>();
        list.offer(this.root);
        while (!list.isEmpty()) {
            Node<E> node = list.poll();
            int nodeLength = node.leaves().size();
            if (nodeLength >= THREE) {
                result = false;
                break;
            }
            list.addAll(node.leaves());
        }
        return result;
    }
}
