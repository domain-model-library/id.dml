package dml.id.entity;

import org.junit.Test;

public class SnowflakeIdGeneratorTest {

    @Test
    public void generateId() {
        SnowflakeIdGenerator snowflakeIdGenerator = new SnowflakeIdGenerator();
        long id1 = snowflakeIdGenerator.generateId();
        System.out.println(id1);
        long id2 = snowflakeIdGenerator.generateId();
        System.out.println(id2);
        assert id1 < id2;
    }
}
