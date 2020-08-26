package dml.common.repository;

public interface TakeFromRepository<E, ID> {
	public E take(ID id);
}
