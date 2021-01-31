package dml.common.logic;

import java.math.BigDecimal;

public class LessThanCondition implements Condition<String> {

	private String toStrNum;

	public LessThanCondition() {
	}

	public LessThanCondition(String toStrNum) {
		this.toStrNum = toStrNum;
	}

	@Override
	public boolean toTry(String strNum) {
		BigDecimal bd = new BigDecimal(strNum);
		BigDecimal toBd = new BigDecimal(toStrNum);
		return bd.subtract(toBd).signum() == -1;
	}

}
