package dml.common.repository;

public interface RemoveFromRepository<ID, E> {
	public E removeFromRepository(ID id);
}
