package nonblockingcache;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Class Cache.
 * Implements entity Cache.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 29.10.2018
 */
public class Cache implements CacheInterface {
    /**
     * Storage.
     */
    private ConcurrentHashMap<Integer, Base> map = new ConcurrentHashMap<>();

    @Override
    public final void add(final Base pModel) {
        map.put(pModel.getId(), pModel);
    }

    @Override
    public final void update(final Base pModel) throws OptimisticException {
        int oldVersion = map.entrySet().stream()
                .filter(entry -> entry.getKey() == pModel.getId())
                .findFirst()
                .get()
                .getValue()
                .getVersion();

        map.computeIfPresent(pModel.getId(), (integer, base) -> {
            if (!(oldVersion == base.getVersion())) {
                throw new OptimisticException("Throw Exception in Thread");
            }
            base.setName(pModel.getName());
            base.setVersion(base.getVersion() + 1);
            return map.put(integer, base);
        });
    }
}
