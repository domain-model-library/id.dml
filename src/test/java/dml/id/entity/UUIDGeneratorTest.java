package dml.id.entity;

import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class UUIDGeneratorTest {

    @Test
    public void generateId() {
        UUIDGenerator uuidGenerator = new UUIDGenerator();
        String uuid1 = uuidGenerator.generateId();
        String uuid2 = uuidGenerator.generateId();
        assertNotEquals(uuid1, uuid2);
    }
}