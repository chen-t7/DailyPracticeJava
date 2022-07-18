import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -07 -18
 * Time: 20:41
 */
class Card {
    private int rank;//数字
    private String suit;//花色

    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "[" + this.suit + ":" + this.rank + "]";
    }
}

public class TestDemo5 {
    private static final String[] suits = {"♥", "♠", "♣", "♦"};

    public static List<Card> buyCard() {
        ArrayList<Card> cards = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                /*
                String suit = suits[i];
                int rank = j;
                Card card = new Card(rank, suit);
                cards.add(card);
                 */
                cards.add(new Card(j, suits[i]));
            }
        }
        return cards;
    }

    private static void swap(List<Card> cards, int i, int j) {
        Card tmp = cards.get(i);
        cards.set(i, cards.get(j));
        cards.set(j, tmp);
    }

    public static void shuffle(List<Card> cards) {
        int size = cards.size();
        for (int i = size - 1; i > 0; i--) {
            Random random = new Random();
            int rand = random.nextInt(i);
            swap(cards, i, rand);
        }

    }

    public static void main(String[] args) {
        List<Card> cards = buyCard();
        System.out.println("买牌" + cards);
        shuffle(cards);
        System.out.println("洗牌" + cards);

        System.out.println("揭牌：3个人每人轮流揭五张");

        ArrayList<ArrayList<Card>> hand = new ArrayList<>();
        ArrayList<Card> hand1 = new ArrayList<>();
        ArrayList<Card> hand2 = new ArrayList<>();
        ArrayList<Card> hand3 = new ArrayList<>();
        hand.add(hand1);
        hand.add(hand2);
        hand.add(hand3);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                Card card = cards.remove(0);
                hand.get(j).add(card);
            }
        }
        System.out.println("第一个人的牌：" + hand1);
        System.out.println("第二个人的牌：" + hand2);
        System.out.println("第三个人的牌：" + hand3);
        System.out.println("剩下的牌：" + cards);
        System.out.println(hand);
    }
}
