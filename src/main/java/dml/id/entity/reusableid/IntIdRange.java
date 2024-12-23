package dml.id.entity.reusableid;

public class IntIdRange {
    private int start;
    private int size;

    public IntIdRange() {
    }

    public IntIdRange(int start, int size) {
        this.start = start;
        this.size = size;
    }

    public int extend() {
        return size++ + start;
    }

    public boolean merge(IntIdRange rangeToMerge) {
        if (start + size == rangeToMerge.start) {
            size += rangeToMerge.size;
            return true;
        }
        return false;
    }

    public boolean contains(int id) {
        return id >= start && id < start + size;
    }

    public IntIdRange removeId(int id) {
        if (id == start) {
            start++;
            size--;
        } else if (id == start + size - 1) {
            size--;
        } else {
            //生成后半段Range
            IntIdRange newRange = new IntIdRange(id + 1, size - (id - start + 1));
            size = id - start;
            return newRange;
        }
        return null;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}


