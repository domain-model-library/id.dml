package dml.common.logic;

public class Conditions {

	public static Condition<?> createCondition(ConditionType conditionType,
			Object conditionData) {
		if (ConditionType.trueCondition.equals(conditionType)) {
			return new TrueCondition();
		} else if (ConditionType.lessThanCondition.equals(conditionType)) {
			return new LessThanCondition((String) conditionData);
		} else {
			return null;
		}
	}

}
