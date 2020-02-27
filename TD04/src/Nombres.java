package g54327.dev2.td04;

import java.util.ArrayList;
import java.util.List;

public class Nombres {

    List<Integer> list;

    public Nombres() {
        this.list = new ArrayList<>();
    }

    public void add(Integer val) {
        this.list.add(val);
    }

    public void remove(Integer val) {
        this.list.remove(val);
    }

    public Integer sum() {
        return TdListes.sum(this.list);
    }
}
