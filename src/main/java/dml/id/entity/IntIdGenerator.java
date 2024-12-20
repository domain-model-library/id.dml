package dml.id.entity;

public class IntIdGenerator implements IdGenerator<Integer> {

    private int idValue;

    public IntIdGenerator() {
    }

    public IntIdGenerator(int minIdValue) {
        idValue = minIdValue;
    }

    @Override
    public Integer generateId() {
        return idValue++;
    }

    public int getIdValue() {
        return idValue;
    }

    public void setIdValue(int idValue) {
        this.idValue = idValue;
    }
}
