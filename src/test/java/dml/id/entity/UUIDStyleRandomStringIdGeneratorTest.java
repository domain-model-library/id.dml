package dml.id.entity;

import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class UUIDStyleRandomStringIdGeneratorTest {

    @Test
    public void generateId() {
        UUIDStyleRandomStringIdGenerator idGenerator = new UUIDStyleRandomStringIdGenerator() {
        };
        String uuid1 = idGenerator.generateId();
        String uuid2 = idGenerator.generateId();
        assertNotEquals(uuid1, uuid2);
    }
}