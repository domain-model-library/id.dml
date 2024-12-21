package dml.id.entity;

import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class IntStringIdGeneratorTest {

    @Test
    public void generateId() {
        IntStringIdGenerator intStringIdGenerator = new IntStringIdGenerator(10);
        String id1 = intStringIdGenerator.generateId();
        System.out.println(id1);
        String id2 = intStringIdGenerator.generateId();
        System.out.println(id2);
        assertNotEquals(id1, id2);
    }
}
