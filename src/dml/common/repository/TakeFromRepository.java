package dml.common.repository;

public interface TakeFromRepository<E, ID> {
	public E takeFromRepository(ID id);
}
