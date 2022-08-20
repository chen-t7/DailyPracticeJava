import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -08 -18
 * Time: 21:18
 */

/*
//这种比较方式对类的侵入性太强了
class Card implements Comparable<Card>{
    public int rank; // 数值
    public String suit; // 花色
    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }


    @Override
    public int compareTo(Card o) {
        //return o.rank - this.rank;//大堆
        return this.rank - o.rank;//小堆
    }

    @Override
    public String toString() {
        return "Card{" +
                "rank=" + rank +
                ", suit='" + suit + '\'' +
                '}';
    }
}

 */

class Card {
    public int rank; // 数值
    public String suit; // 花色
    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "Card{" +
                "rank=" + rank +
                ", suit='" + suit + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        //getClass() != o.getClass()比较的是：是否为同一类型
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return rank == card.rank &&
                Objects.equals(suit, card.suit);
    }


    @Override
    public int hashCode() {
        return Objects.hash(rank, suit);
    }
}

/*
class RankCompartor implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        return o2.rank - o1.rank;
    }
}
 */

public class TestDemo {
    public static void main(String[] args) {
        Card card1 = new Card(2, "♦");
        Card card2 = new Card(2, "♦");
        System.out.println(card1.equals(card2));
    }

    public static void main5(String[] args) {
        Card card1 = new Card(2, "♦");
        Card card2 = new Card(1, "♣");
        //匿名内部类
        /*
        PriorityQueue<Card> priorityQueue = new PriorityQueue<>(new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                return o1.rank - o2.rank;
            }
        });
         */
        //lambda表达式，可读性非常差
        PriorityQueue<Card> priorityQueue = new PriorityQueue<>((x,y)->{return y.rank-x.rank;});
        priorityQueue.offer(card1);
        priorityQueue.offer(card2);
        System.out.println(priorityQueue);
    }

    /*
    public static void main4(String[] args) {
        Card card1 = new Card(2, "♦");
        Card card2 = new Card(1, "♣");
        RankCompartor rankCompartor = new RankCompartor();
        PriorityQueue<Card> priorityQueue = new PriorityQueue<>(rankCompartor);
        priorityQueue.offer(card1);
        priorityQueue.offer(card2);
        System.out.println(priorityQueue);
    }

     */

    public static void main3(String[] args) {
        Card card1 = new Card(2, "♦");
        Card card2 = new Card(1, "♣");
        //默认是一个小根堆
        PriorityQueue<Card> priorityQueue = new PriorityQueue<>();
        /*
        priorityQueue.offer(card1);
        priorityQueue.offer(card2);
        //priorityQueue.offer(null);
        System.out.println(priorityQueue);
         */
        //System.out.println(card1.compareTo(card2));
        /*
        RankCompartor rankCompartor = new RankCompartor();
        int ret = rankCompartor.compare(card1, card2);
        System.out.println(ret);

         */
    }

    public static void main1(String[] args) {
        //默认是小根堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        //offer每放一个元素都得保证当前的堆是大堆 或者小堆
        priorityQueue.offer(12);
        priorityQueue.offer(3);
        priorityQueue.offer(15);

        System.out.println(priorityQueue.peek());
        //poll每弹出一个元素仍得保证当前的堆是大堆 或者小堆
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
    }

    public static void main2(String[] args) {
        int[] array = { 27,15,19,18,28,34,65,49,25,37 };
        TestHeap testHeap = new TestHeap();
        testHeap.createBigHead(array);
        testHeap.offer(80);
        testHeap.heapSort();
        System.out.println("=============");

        System.out.println(testHeap.poll());
        System.out.println(testHeap.poll());
    }

}
