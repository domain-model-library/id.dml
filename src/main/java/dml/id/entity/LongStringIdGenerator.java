package dml.id.entity;

public class LongStringIdGenerator implements IdGenerator<String> {

    private LongIdGenerator longIdGenerator;

    /**
     * 最小字符串长度，不足时前面补0
     */
    private int minLength = 1;

    public LongStringIdGenerator() {
        longIdGenerator = new LongIdGenerator();
    }

    public LongStringIdGenerator(int minLength) {
        if (minLength <= 0) {
            throw new IllegalArgumentException("minLength must be greater than 0");
        }
        this.minLength = minLength;
        longIdGenerator = new LongIdGenerator();
    }

    @Override
    public String generateId() {
        return String.format("%0" + minLength + "d", longIdGenerator.generateId());
    }

    public LongIdGenerator getLongIdGenerator() {
        return longIdGenerator;
    }

    public void setLongIdGenerator(LongIdGenerator longIdGenerator) {
        this.longIdGenerator = longIdGenerator;
    }

    public int getMinLength() {
        return minLength;
    }

    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }
}
