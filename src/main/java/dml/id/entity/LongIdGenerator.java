package dml.id.entity;

public class LongIdGenerator implements IdGenerator<Long> {

    private long idValue;

    public LongIdGenerator() {
    }

    public LongIdGenerator(long minIdValue) {
        idValue = minIdValue;
    }

    @Override
    public Long generateId() {
        return idValue++;
    }

    public long getIdValue() {
        return idValue;
    }

    public void setIdValue(long idValue) {
        this.idValue = idValue;
    }
}
