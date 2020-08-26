package dml.common.repository;

public interface RemoveFromRepository<ID, E> {
	public E remove(ID id);
}
