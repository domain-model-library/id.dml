package dml.id.entity;

import dml.id.entity.reusableid.ReusableIntIdGenerator;
import org.junit.Test;

public class ReusableIntIdGeneratorTest {
    @Test
    public void generateId() {
        ReusableIntIdGenerator reusableIntIdGenerator = new ReusableIntIdGenerator(1);
        //生成连续3个id
        int id1 = reusableIntIdGenerator.generateId();
        assert id1 == 1;
        int id2 = reusableIntIdGenerator.generateId();
        assert id2 == 2;
        int id3 = reusableIntIdGenerator.generateId();
        assert id3 == 3;

        //回收id2
        reusableIntIdGenerator.recycleId(id2);
        assert reusableIntIdGenerator.countIds() == 2;
        assert reusableIntIdGenerator.queryId(0) == id1;
        assert reusableIntIdGenerator.queryId(1) == id3;

        //再生成一个id
        id2 = reusableIntIdGenerator.generateId();
        assert id2 == 2;
        assert reusableIntIdGenerator.countIds() == 3;
        assert reusableIntIdGenerator.queryId(0) == id1;
        assert reusableIntIdGenerator.queryId(1) == id2;
        assert reusableIntIdGenerator.queryId(2) == id3;

        //回收id1
        reusableIntIdGenerator.recycleId(id1);
        assert reusableIntIdGenerator.countIds() == 2;
        assert reusableIntIdGenerator.queryId(0) == id2;
        assert reusableIntIdGenerator.queryId(1) == id3;

        //回收id3
        reusableIntIdGenerator.recycleId(id3);
        assert reusableIntIdGenerator.countIds() == 1;
        assert reusableIntIdGenerator.queryId(0) == id2;

        //再生成id1
        id1 = reusableIntIdGenerator.generateId();
        assert id1 == 1;

        //再生成id3
        id3 = reusableIntIdGenerator.generateId();
        assert id3 == 3;

    }
}
