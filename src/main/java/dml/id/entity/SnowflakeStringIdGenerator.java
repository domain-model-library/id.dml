package dml.id.entity;

public class SnowflakeStringIdGenerator implements IdGenerator<String> {

    private SnowflakeIdGenerator snowflakeIdGenerator;

    // Create SnowflakeIdGenerator with a nodeId
    public SnowflakeStringIdGenerator(long nodeId) {
        this.snowflakeIdGenerator = new SnowflakeIdGenerator(nodeId);
    }

    // Let SnowflakeIdGenerator generate a nodeId
    public SnowflakeStringIdGenerator() {
        this.snowflakeIdGenerator = new SnowflakeIdGenerator();
    }

    @Override
    public String generateId() {
        return String.valueOf(snowflakeIdGenerator.generateId());
    }


}
