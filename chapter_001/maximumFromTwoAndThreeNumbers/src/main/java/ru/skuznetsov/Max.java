package ru.skuznetsov;

public class Max {

    public int max(int first, int second){
        return (first > second) ? first : second;
    }

    public int max(int first, int second, int third){
        int maximumFromFirstAndSecond = max(first, second);
        return maximumFromFirstAndSecond > third ? maximumFromFirstAndSecond : third;
    }
}
