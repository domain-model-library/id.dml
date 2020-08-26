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
	public E take(ID id) {
		return map.get(id);
	}

	@Override
	public E remove(ID id) {
		return map.remove(id);
	}

	@Override
	public void put(E entity) {
		map.put(getId(entity), entity);
	}

	@Override
	public E putIfAbsent(E entity) {
		map.put(getId(entity), entity);
		return entity;
	}

	@Override
	public E copy(ID id) {
		return map.get(id);
	}

	protected abstract ID getId(E entity);

}
