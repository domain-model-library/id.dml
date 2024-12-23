package dml.id.entity.reusableid;

import dml.id.entity.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class ReusableIntIdGenerator implements IdGenerator<Integer> {

    private List<IntIdRange> idRangeList;

    public ReusableIntIdGenerator() {
        this(0);
    }

    public ReusableIntIdGenerator(int minIdValue) {
        idRangeList = new ArrayList<>();
        idRangeList.add(new IntIdRange(minIdValue, 0));
    }

    @Override
    public Integer generateId() {
        //检查区间之间的缝隙，如果有缝隙则返回缝隙的最小值，并将缝隙合并一个值到前一个区间。如果有可能（也就是之前的缝隙长度只有一个值），还需要合并区间。
        IntIdRange idRange0 = idRangeList.get(0);
        int id = idRange0.extend();
        if (idRangeList.size() == 1) {
            return id;
        }
        IntIdRange idRange1 = idRangeList.get(1);
        if (idRange0.merge(idRange1)) {
            idRangeList.remove(1);
        }
        return id;
    }

    public int countIds() {
        int count = 0;
        for (IntIdRange idRange : idRangeList) {
            count += idRange.getSize();
        }
        return count;
    }

    /**
     * 查询第几个id
     *
     * @return
     */
    public int queryId(int index) {
        int count = 0;
        for (IntIdRange idRange : idRangeList) {
            int size = idRange.getSize();
            if (index < count + size) {
                return idRange.getStart() + index - count;
            }
            count += size;
        }
        return -1;
    }

    /**
     * 回收id
     *
     * @param id
     */
    public void recycleId(int id) {
        //对首个idRange特殊处理
        IntIdRange idRange0 = idRangeList.get(0);
        if (idRange0.contains(id)) {
            if (idRange0.getStart() == id) {
                IntIdRange newIdRange0 = new IntIdRange(idRange0.getStart(), 0);
                idRange0.removeId(id);
                List<IntIdRange> newIdRangeList = new ArrayList<>();
                newIdRangeList.add(newIdRange0);
                newIdRangeList.addAll(idRangeList);
                idRangeList = newIdRangeList;
                return;
            }
        }
        for (int i = 0; i < idRangeList.size(); i++) {
            IntIdRange idRange = idRangeList.get(i);
            if (idRange.contains(id)) {
                IntIdRange splitRange = idRange.removeId(id);
                if (idRange.isEmpty()) {
                    idRangeList.remove(i);
                    return;
                }
                if (splitRange == null) {
                    return;
                }
                List<IntIdRange> newIdRangeList = new ArrayList<>();
                for (int j = 0; j < i; j++) {
                    newIdRangeList.add(idRangeList.get(j));
                }
                newIdRangeList.add(idRange);
                newIdRangeList.add(splitRange);
                for (int j = i + 1; j < idRangeList.size(); j++) {
                    newIdRangeList.add(idRangeList.get(j));
                }
                idRangeList = newIdRangeList;
                return;
            }
        }
    }


    public List<IntIdRange> getIdRangeList() {
        return idRangeList;
    }

    public void setIdRangeList(List<IntIdRange> idRangeList) {
        this.idRangeList = idRangeList;
    }


}
