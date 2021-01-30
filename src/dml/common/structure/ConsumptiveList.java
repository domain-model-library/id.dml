package dml.common.structure;

import java.util.List;

public class ConsumptiveList<E> {

	private List<E> list;

	public ConsumptiveList(List<E> list) {
		this.list = list;
	}

	public E get() {
		if (list.isEmpty()) {
			return null;
		}
		return list.remove(0);
	}

}
