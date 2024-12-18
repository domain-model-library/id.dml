package dml.id.entity;

public class SnowflakeStringIdGenerator implements IdGenerator<String> {

    private SnowflakeIdGenerator snowflakeIdGenerator;

    // Create SnowflakeIdGenerator with a nodeId
    public SnowflakeStringIdGenerator(long nodeId) {
        this.snowflakeIdGenerator = new SnowflakeIdGenerator(nodeId);
    }

    public SnowflakeStringIdGenerator(long nodeId, int epochBits, int nodeIdBits, int sequenceBits) {
        this.snowflakeIdGenerator = new SnowflakeIdGenerator(nodeId, epochBits, nodeIdBits, sequenceBits);
    }

    // Let SnowflakeIdGenerator generate a nodeId
    public SnowflakeStringIdGenerator() {
        this.snowflakeIdGenerator = new SnowflakeIdGenerator();
    }

    public SnowflakeStringIdGenerator(int epochBits, int nodeIdBits, int sequenceBits) {
        this.snowflakeIdGenerator = new SnowflakeIdGenerator(epochBits, nodeIdBits, sequenceBits);
    }

    @Override
    public String generateId() {
        return String.valueOf(snowflakeIdGenerator.generateId());
    }


}
