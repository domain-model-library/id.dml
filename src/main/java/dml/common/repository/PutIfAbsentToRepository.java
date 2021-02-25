package dml.common.repository;

public interface PutIfAbsentToRepository<E> {
	/**
	 * @param entity
	 * @return 返回已存在的，如果之前不存在返回null
	 */
	public E putIfAbsentToRepository(E entity);
}
