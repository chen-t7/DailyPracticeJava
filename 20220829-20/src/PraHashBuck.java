import java.util.Arrays;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -08 -31
 * Time: 16:49
 */
class Person2 {
    private String ID;

    public Person2(String ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "ID='" + ID + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person2 person2 = (Person2) o;
        return Objects.equals(ID, person2.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }
}

public class PraHashBuck<K,V> {
    private int usedSize;
    private Node<K,V>[] array;
    public static double DEFAULT_FACTORLOAD = 0.7;
    class Node<K,V> {
        private K key;
        private V val;
        private Node<K,V> next;

        Node (K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    PraHashBuck() {
        array = (Node<K,V>[])new Node[10];
        usedSize = 0;
    }

    public V get(K key) {
        int hashCode = key.hashCode();
        int index = hashCode % array.length;
        Node<K,V> cur = array[index];
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur.val;
            }
            cur = cur.next;
        }
        return null;
    }

    public void put(K key, V val) {
        int hashCode = key.hashCode();
        int index = hashCode % array.length;
        Node<K,V> cur = array[index];
        while (cur != null) {
            if (cur.val.equals(key)) {
                cur.val = val;
                return ;
            }
            cur = cur.next;
        }

        Node<K,V> tmpNode = new Node(key, val);
        tmpNode.next = array[index];
        array[index] = tmpNode;
        usedSize++;
        if (factor_load() > DEFAULT_FACTORLOAD) {
            resize();
        }
    }

    public double factor_load() {
        return 1.0*usedSize/array.length;
    }

    public void resize() {
        Node<K,V>[] newArray= (Node<K,V>[])new Node[array.length*2];
        for (int i = 0; i < array.length; i++) {
            Node<K,V> cur = array[i];
            while (cur != null) {
                Node<K,V> tmp = new Node<>(cur.key, cur.val);
                tmp.next = newArray[i];
                newArray[i] = tmp;
                cur = cur.next;
            }
        }
    }


    public static void main(String[] args) {
        Person2 person2 = new Person2("123456");
        Person2 person21 = new Person2("235521");
        PraHashBuck<Person2, String> praHashBuck= new PraHashBuck<>();
        praHashBuck.put(person2,"nan");
        praHashBuck.put(person21,"nv");
        praHashBuck.put(person21,"nan");
        System.out.println(person2.hashCode());
        System.out.println(person21.hashCode());
        System.out.println(praHashBuck.get(person21));
        praHashBuck.put(new Person2("526244"),"nv");
        praHashBuck.put(new Person2("526243"),"nv");
        praHashBuck.put(new Person2("526242"),"nv");
        praHashBuck.put(new Person2("526241"),"nv");
        praHashBuck.put(new Person2("526240"),"nv");
        praHashBuck.put(new Person2("526298"),"nv");
        praHashBuck.put(new Person2("526299"),"nv");

    }
}
