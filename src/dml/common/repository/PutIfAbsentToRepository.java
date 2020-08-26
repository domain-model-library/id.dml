package dml.common.repository;

public interface PutIfAbsentToRepository<E> {
	public E putIfAbsent(E entity);
}
