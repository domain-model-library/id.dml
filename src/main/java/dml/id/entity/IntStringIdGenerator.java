package dml.id.entity;

public class IntStringIdGenerator implements IdGenerator<String> {

    private IntIdGenerator intIdGenerator;

    /**
     * 最小字符串长度，不足时前面补0
     */
    private int minLength = 1;

    public IntStringIdGenerator() {
        intIdGenerator = new IntIdGenerator();
    }

    public IntStringIdGenerator(int minLength) {
        if (minLength <= 0) {
            throw new IllegalArgumentException("minLength must be greater than 0");
        }
        this.minLength = minLength;
        intIdGenerator = new IntIdGenerator();
    }

    @Override
    public String generateId() {
        return String.format("%0" + minLength + "d", intIdGenerator.generateId());
    }

    public IntIdGenerator getIntIdGenerator() {
        return intIdGenerator;
    }

    public void setIntIdGenerator(IntIdGenerator intIdGenerator) {
        this.intIdGenerator = intIdGenerator;
    }

    public int getMinLength() {
        return minLength;
    }

    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }
}
