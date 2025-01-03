package dml.id.entity;

import java.net.NetworkInterface;
import java.security.SecureRandom;
import java.time.Instant;
import java.util.Enumeration;

public class SnowflakeIdGenerator implements IdGenerator<Long> {

    private final int UNUSED_BITS = 1; // Sign bit, Unused (always set to 0)
    private final int EPOCH_BITS;
    private final int NODE_ID_BITS;
    private final int SEQUENCE_BITS;

    private final long maxNodeId;
    private final long maxSequence;

    // Epoch (January 1, 2015 Midnight UTC = 2015-01-01T00:00:00Z)
    private static final long EPOCH = 1420070400000L;

    private final long nodeId;

    private long lastTimestamp = -1L;
    private long sequence = 0L;

    // Create SnowflakeIdGenerator with configurable bits and a nodeId
    public SnowflakeIdGenerator(long nodeId, int epochBits, int nodeIdBits, int sequenceBits) {
        if (nodeId < 0 || nodeId > (1L << nodeIdBits) - 1) {
            throw new IllegalArgumentException(String.format("NodeId must be between %d and %d", 0, (1L << nodeIdBits) - 1));
        }
        if (epochBits + nodeIdBits + sequenceBits + UNUSED_BITS != 64) {
            throw new IllegalArgumentException("Epoch + NodeId + Sequence bits must be equal to 63");
        }
        this.nodeId = nodeId;
        this.EPOCH_BITS = epochBits;
        this.NODE_ID_BITS = nodeIdBits;
        this.SEQUENCE_BITS = sequenceBits;
        this.maxNodeId = (1L << NODE_ID_BITS) - 1;
        this.maxSequence = (1L << SEQUENCE_BITS) - 1;
    }

    // Let SnowflakeIdGenerator generate a nodeId with configurable bits
    public SnowflakeIdGenerator(int epochBits, int nodeIdBits, int sequenceBits) {
        this(createNodeId((1L << nodeIdBits) - 1), epochBits, nodeIdBits, sequenceBits);
    }

    public SnowflakeIdGenerator(long nodeId) {
        this(nodeId, 41, 10, 12);
    }

    public SnowflakeIdGenerator() {
        this(41, 10, 12);
    }

    private static long createNodeId(long maxNodeId) {
        long nodeId;
        try {
            StringBuilder sb = new StringBuilder();
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                byte[] mac = networkInterface.getHardwareAddress();
                if (mac != null) {
                    for (byte macPort : mac) {
                        sb.append(String.format("%02X", macPort));
                    }
                }
            }
            nodeId = sb.toString().hashCode();
        } catch (Exception ex) {
            nodeId = (new SecureRandom().nextInt());
        }
        nodeId = nodeId & maxNodeId;
        return nodeId;
    }

    @Override
    public Long generateId() {
        long currentTimestamp = timestamp();

        if (currentTimestamp < lastTimestamp) {
            throw new IllegalStateException("Invalid System Clock!");
        }

        if (currentTimestamp == lastTimestamp) {
            sequence = (sequence + 1) & maxSequence;
            if (sequence == 0) {
                // Sequence Exhausted, wait till next millisecond.
                currentTimestamp = waitNextMillis(currentTimestamp);
            }
        } else {
            // reset sequence to start with zero for the next millisecond
            sequence = 0;
        }

        lastTimestamp = currentTimestamp;

        long id = currentTimestamp << (NODE_ID_BITS + SEQUENCE_BITS)
                | (nodeId << SEQUENCE_BITS)
                | sequence;

        return id;
    }

    // Get current timestamp in milliseconds, adjust for the epoch.
    private long timestamp() {
        return Instant.now().toEpochMilli() - EPOCH;
    }

    // Block and wait till next millisecond
    private long waitNextMillis(long currentTimestamp) {
        while (currentTimestamp == lastTimestamp) {
            currentTimestamp = timestamp();
        }
        return currentTimestamp;
    }
}