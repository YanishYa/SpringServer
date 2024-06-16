package com.example.SpringServer;

public class KeyValuePair<T, Q> {
    T key;
    Q value;
    public KeyValuePair(T key, Q value){
        this.key = key;
        this.value = value;
    }
    public void setKey(T key){
        this.key = key;
    }
    public T getKey(){
        return key;
    }
    public void setValue(Q value){
        this.value = value;
    }
    public Q getValue(){
        return value;
    }
}
