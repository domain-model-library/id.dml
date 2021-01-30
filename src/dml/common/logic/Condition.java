package dml.common.logic;

import dml.common.structure.ConsumptiveList;

public interface Condition {
	boolean toTry(ConsumptiveList<Object> parameters);
}
