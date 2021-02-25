package dml.common.logic;

public class Or implements Condition<Object> {

	private Condition<Object>[] conditions;

	public Or() {
	}

	public Or(Condition<?>... conditions) {
		this.conditions = (Condition<Object>[]) conditions;
	}

	@Override
	public boolean toTry(Object parameters) {
		if (conditions == null || conditions.length == 0) {
			return false;
		}
		for (Condition<Object> condition : conditions) {
			if (condition.toTry(parameters)) {
				return true;
			}
		}
		return false;
	}

}
