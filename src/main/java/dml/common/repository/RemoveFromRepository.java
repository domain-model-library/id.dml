package dml.common.repository;

public interface RemoveFromRepository<E, ID> {
	public E removeFromRepository(ID id);
}
