package dml.common.repository;

import java.util.HashMap;
import java.util.Map;

/**
 * 用于快速构建测试repo，不能用于生产
 * 
 * @author neo
 */
public abstract class SimpleRepository<E, I> implements
		CopyFromRepository<E, I>, PutIfAbsentToRepository<E>,
		PutToRepository<E>, RemoveFromRepository<E, I>,
		TakeFromRepository<E, I>

{
	protected Map<I, E> map = new HashMap<>();

	@Override
	public E takeFromRepository(I id) {
		return map.get(id);
	}

	@Override
	public E removeFromRepository(I id) {
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
	public E copyFromRepository(I id) {
		return map.get(id);
	}

	protected abstract I getId(E entity);

}
