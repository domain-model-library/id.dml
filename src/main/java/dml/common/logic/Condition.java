package dml.common.logic;

public interface Condition<P> {
	boolean toTry(P parameters);
}
