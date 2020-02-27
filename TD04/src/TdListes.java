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

        List<Integer> toSum = new ArrayList<>();
        toSum.add(10);
        toSum.add(10);
        toSum.add(30);
        System.out.println(sum(toSum));

        Nombres nombres = new Nombres();
        nombres.add(10);
        nombres.add(10);
        System.out.println(nombres.sum());
    }

    public static int sum(List<Integer> list) {
        int sum = 0;
        for (int number : list) {
            sum += number;
        }

        return sum;
    }
}
