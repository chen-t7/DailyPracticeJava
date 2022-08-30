import jdk.internal.org.objectweb.asm.tree.InnerClassNode;

import javax.swing.plaf.basic.BasicScrollPaneUI;
import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -08 -29
 * Time: 21:35
 */
public class TestDemo {
    public static List<String> topKFrequent(String[] words, int k) {
        //1.统计每个单词出现的次数
        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            if (map.get(s) == null) {
                map.put(s, 1);
            } else {
                int val = map.get(s);
                map.put(s, val+1);
            }
        }
        //2.建立一个大小为k的小根堆
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue().compareTo(o2.getValue()) == 0) {
                    return o2.getKey().compareTo(o1.getKey());
                }
                return o1.getValue()-o2.getValue();
            }
        });
        //3.遍历map
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            } else {
                //已经放满了k个元素，需要和堆顶元素进行比较，比堆顶元素大的放进来
                Map.Entry<String, Integer> top = minHeap.peek();
                //判断频率是否相同，如果相同，比较单词的大小，单词小的入队
                if (top.getValue().compareTo(entry.getValue()) == 0) {
                    if (top.getKey().compareTo(entry.getKey()) < 0) {
                        minHeap.poll();
                        minHeap.offer(entry);
                    }
                } else {
                    if (top.getValue().compareTo(entry.getValue()) < 0) {
                        minHeap.poll();
                        minHeap.offer(entry);
                    }
                }
            }
        }
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            Map.Entry<String, Integer> top = minHeap.poll();
            ret.add(top.getKey());
        }
        Collections.reverse(ret);
        return ret;
    }

    public static void main(String[] args) {
        String[] worlds = {"i","love","leetcode","i","love","coding"};
        int k = 1;
        List<String> ret = topKFrequent(worlds, k);
        System.out.println(ret);
    }

    /**
     * 旧键盘上坏了几个键，于是在敲一段文字的时候，对应的字符就不会出现。现在给出应该输入的一段文字、以及实际被输入的文字，
     * 请你列出肯定坏掉的那些键。
     * @param strExce
     * @param strAcual
     */
    public static void func(String strExce, String strAcual) {
        HashSet<Character> set = new HashSet<>();
        for (char ch : strAcual.toUpperCase().toCharArray()) {
            set.add(ch);
        }
        HashSet<Character> setTmp = new HashSet<>();
        for (char ch : strExce.toUpperCase().toCharArray()) {
            if (!set.contains(ch) && !setTmp.contains(ch)) {
                set.add(ch);
                System.out.print(ch);
            }
        }
    }

    public static void main4(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            func(str1, str2);
        }
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        //1.第一次遍历链表，存储老节点和新节点之间的映射关系
        //2.第二次遍历链表，修改新节点的next和random
        //return map.get(head)
        if (head == null) {
            return null;
        }
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        while (cur != null) {
            Node tmp = new Node(cur.val);
            map.put(cur, tmp);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
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

    public static void main3(String[] args) {
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
