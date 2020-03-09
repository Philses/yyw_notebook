package Algorithm4th;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @Time : 2020年3月9日17:06:29
 * @Author : yyw@ustc
 * @E-mail : yang0@mail.ustc.edu.cn
 * @Github : https://github.com/ustcyyw
 * @desc : 复习图的辅助数据结构
 */
public class Bag<Item> implements Iterable<Item> {
    private Node head;
    private int n;

    public Bag() {
        n = 0;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void add(Item item){
        head = new Node(item, head);
        n++;
    }

    public Iterator<Item> iterator(){
        return new BagIterator();
    }

    private class BagIterator implements Iterator<Item>{
        private Node x = head;
        public boolean hasNext(){
            return x != null;
        }
        public void remove(){

        }

        public Item next(){
            if (!hasNext()) throw new NoSuchElementException();
            Item res = x.item;
            x = x.next;
            return res;
        }
    }

    private class Node {
        Item item;
        Node next;

        public Node(Item item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Bag<Integer> bag = new Bag<>();
        bag.add(5);
        bag.add(1);
        bag.add(6);
        System.out.println(bag.size());
        for(int i : bag)
            System.out.print(i + " ");
        System.out.println();
        bag.add(2);
        for(int i : bag)
            System.out.print(i + " ");
    }
}
