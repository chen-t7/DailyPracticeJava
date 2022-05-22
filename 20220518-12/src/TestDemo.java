import javax.swing.*;
import java.util.*;
import java.util.concurrent.Callable;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -05 -18
 * Time: 15:49
 */
public class TestDemo {
    public static void main(String[] args) {
        Map<String, String> map2 = new TreeMap<>();
        map2.put("聪明的", "喜羊羊");
        map2.put("美丽的", "美羊羊");
        System.out.println(map2);

        Map<String, String> map = new HashMap<>();
        map.put("聪明的", "喜羊羊");
        map.put("美丽的", "美羊羊");
        System.out.println(map);
    }

    public static void main4(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("聪明的", "喜羊羊");
        map.put("美丽的", "美羊羊");
        System.out.println(map);
        System.out.println("============");
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            System.out.println("key:" + entry.getKey() + "  value:" + entry.getValue());
        }


    }

    public static void main3(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("聪明的", "喜羊羊");
        map.put("美丽的", "美羊羊");

        String ret =  map.get("聪明的");
        String ret1 =  map.get("美丽的");
        System.out.println(ret);
        System.out.println(ret1);

        String ret2 = map.getOrDefault("懒懒的", "懒羊羊");
        System.out.println(ret2);

        boolean flg =  map.containsKey("懒懒的");
        System.out.println(flg);

        System.out.println(map);

        Map<String, String> map1 = new TreeMap<>();
    }

    public static void main2(String[] args) {
        Collection<String> collection = new ArrayList<String>();
        collection.add("hello");
        collection.add("hello2");
        System.out.println(collection);
        System.out.println("============================");
        /*
        collection.clear();
        System.out.println(collection);
        System.out.println(collection.isEmpty());
         */
        Object[] objects  =  collection.toArray();
        System.out.println(Arrays.toString(objects));

        String[] strings = (String[])collection.toArray();
        System.out.println(Arrays.toString(strings));


    }

    public static void main1(String[] args) {
        Collection<String> collection = new ArrayList<String>();
        collection.add("hello");
        collection.add("hello2");

        //<>中只能放置类类型，不能放简单类型
        Collection<Integer> collection1 = new ArrayList<Integer>();
        collection1.add(1);
        collection1.add(2);
        collection1.add(3);
    }
}
