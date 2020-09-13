package dml.common.repository;

public interface PutIfAbsentToRepository<E> {
	public E putIfAbsentToRepository(E entity);
}
