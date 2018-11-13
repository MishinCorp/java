package nonblockingcache;

/**
 * Interface CacheInterface.
 * Declares methods for non-blocking cache.
 */
public interface CacheInterface {
    /**
     * Method adds a model.
     *
     * @param pModel Model.
     */
    void add(Base pModel);

    /**
     * Method updates a model.
     *
     * @param pModel Model.
     * @throws OptimisticException OptimisticException.
     */
    void update(Base pModel) throws OptimisticException;

    /**
     * Method deletes a model.
     *
     * @param model Model.
     */
//    void delete(Base pModel);
}
