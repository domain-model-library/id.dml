package dml.common.repository;

import java.util.HashMap;
import java.util.Map;

/**
 * 用于快速构建测试repo，不能用于生产
 * 
 * @author neo
 */
public abstract class SimpleAggregateRootEntityRepository<E, ID> implements AggregateRootEntityRepository<E, ID> {
	protected Map<ID, E> map = new HashMap<>();

	@Override
	public E putEntity(E entity) {
		ID id = getId(entity);
		return map.put(id, entity);
	}

	protected abstract ID getId(E entity);

	@Override
	public E getEntity(ID id) {
		return map.get(id);
	}

}
