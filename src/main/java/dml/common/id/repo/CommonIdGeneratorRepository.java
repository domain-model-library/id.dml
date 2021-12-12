package dml.common.id.repo;

import dml.common.id.aggr.IdGenerator;
import dml.repository.TakeFromSingletonRepository;

public interface CommonIdGeneratorRepository<E extends IdGenerator<?>> extends
		TakeFromSingletonRepository<E> {

}
