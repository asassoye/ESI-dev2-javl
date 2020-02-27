package g54327.dev2.td04;

import java.util.ArrayList;
import java.util.List;

public class TdListes {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(42);
        list.add(54);
        list.set(1, 44);
        list.add(1, 43);
        list.remove(list.size() - 1);
        list.remove(0);
        list.clear();
    }
}
