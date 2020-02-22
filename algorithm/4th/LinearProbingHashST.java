package easy.Tree.Algorithm4th;

import java.util.NoSuchElementException;

/**
 * @Time : 2020年2月22日15:40:35
 * @Author : yyw@ustc
 * @E-mail : yang0@mail.ustc.edu.cn
 * @Github : https://github.com/ustcyyw
 * @desc :
 */
public class LinearProbingHashST<Key, Value>{
    private static final int INIT_CAPACITY = 4;

    private int n = 0;
    private int m;
    private Key[] keys = null;
    private Value[] values = null;

    public LinearProbingHashST(){
        this(INIT_CAPACITY);
    }

    public LinearProbingHashST(int m){
        this.m = m;
        keys = (Key[]) new Object[m];
        values = (Value[]) new Object[m];
    }

    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff) % m;
    }

    public int size(){
        return n;
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public boolean contains(Key key){
        return get(key) != null;
    }

    public Value get(Key key){
        if (n == 0) throw new NoSuchElementException("ST is empty");
        for(int i = hash(key); keys[i] != null; i = (i + 1) % m){
            if(keys[i].equals(key))
                return values[i];
        }
        return null;
    }

    public void put(Key key, Value val){
        if(val == null){
            delete(key);
            return;
        }
        if(n > m / 2) resize(m * 2);
        int i = hash(key);
        for(; keys[i] != null; i = (i + 1) % m){
            if(keys[i].equals(key)){
                values[i] = val;
                return;
            }
        }
        values[i] = val;
        keys[i] = key;
        n++;
    }

    public void delete(Key key){
        int i = hash(key);
        for(; keys[i] != null; i = (i + 1) % m){
            if(keys[i].equals(key))
                break;
        }
        if(keys[i] == null) return; // 表中没有该键则返回；否则i现在指向要删除的键
        keys[i] = null;
        values[i] = null;
        i = (i + 1) % m; // 删除该元素后右移一位。
        for(; keys[i] != null; i = (i + 1) % m){
            Key tempKey = keys[i];
            Value tempValue = values[i];
            keys[i] = null;
            values[i] = null;
            n--;
            put(tempKey, tempValue);
        }
        n--;
        if(n > 0 && n < m / 8) resize(m / 2);
    }

    private void resize(int cap){
        LinearProbingHashST<Key, Value> temp = new LinearProbingHashST<>(cap);
        for(int i = 0; i < m; i++)
            if(keys[i] != null)
                temp.put(keys[i], values[i]);
        this.keys = temp.keys;
        this.values = temp.values;
        this.m = temp.m;
    }
}
