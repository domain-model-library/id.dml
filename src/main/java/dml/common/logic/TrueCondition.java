package dml.common.logic;

public class TrueCondition implements Condition<Boolean> {

	@Override
	public boolean toTry(Boolean parameters) {
		return parameters;
	}

}
