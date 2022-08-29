import jdk.internal.org.objectweb.asm.tree.InnerClassNode;

import javax.swing.plaf.basic.BasicScrollPaneUI;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -08 -29
 * Time: 21:35
 */
public class TestDemo {
    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (set.contains(x)) {
                set.remove(x);
            } else {
                set.add(x);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            }
        }
        return -1;
    }

    public static int func3(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int x : array) {
            if (set.contains(x)) {
                return x;
            }
            set.add(x);
        }
        return -1;
    }

    public static Set<Integer> func2(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int x : array) {
            set.add(x);
        }
        return set;
    }

    //key是关键字，value是出现的次数
    public static Map<Integer, Integer> func1(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        //判断array中的元素  是否在map中，如果不存在就是1，如果存在就在原来的基础上加一
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) == null) {
                map.put(array[i], 1);
            } else {
                int val = map.get(array[i]);
                map.put(array[i], val+1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        int[] array = new int[1_00];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);
        }
        Map<Integer, Integer> map = func1(array);
        System.out.println(map);
        Set<Integer> set = func2(array);
        System.out.println(set);
        int ret = func3(array);
        System.out.println(ret);
    }

    public static void main2(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);
        System.out.println(set);

        Iterator<Integer> integerIterator = set.iterator();
        while (integerIterator.hasNext()) {
            System.out.println(integerIterator.next());
        }
        //LinkedHashSet<>
    }

    public static void main1(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("afr", 3);
        map.put("bat", 2);
        map.put("bat", 4);//存储元素的时候要注意，key如果相同，那么value值将会被覆盖
        map.put("hello", 4);
        map.put(null, null);
        System.out.println(map);

        //Map.Entry<String, Integer>
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }

        /*
        Set<String> set = map.keySet();//set这个集合当中 存储的元素都是不重复的
        System.out.println(set);
         */
        /*
        int ret = map.get("bat");//通过key获取对应的value值
        System.out.println(ret);
        System.out.println(map.getOrDefault("bat2", 98));//没获取到key值就给你一个默认值
        Integer ret2 = map.remove("bat");
        System.out.println(ret2);
        System.out.println(map);
         */
    }
}
