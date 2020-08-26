package dml.common.repository;

public interface CopyFromRepository<E, ID> {
	public E copy(ID id);
}
