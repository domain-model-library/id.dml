package dml.common.repository;

import java.util.HashMap;
import java.util.Map;

/**
 * 用于快速构建测试repo，不能用于生产
 * 
 * @author neo
 */
public abstract class SimpleRepository<E, ID> implements CopyFromRepository<E, ID>, PutIfAbsentToRepository<E>,
		PutToRepository<E>, RemoveFromRepository<ID, E>, TakeFromRepository<E, ID>

{
	protected Map<ID, E> map = new HashMap<>();

	@Override
	public E takeFromRepository(ID id) {
		return map.get(id);
	}

	@Override
	public E removeFromRepository(ID id) {
		return map.remove(id);
	}

	@Override
	public void putToRepository(E entity) {
		map.put(getId(entity), entity);
	}

	@Override
	public E putIfAbsentToRepository(E entity) {
		return map.putIfAbsent(getId(entity), entity);
	}

	@Override
	public E copyFromRepository(ID id) {
		return map.get(id);
	}

	protected abstract ID getId(E entity);

}
