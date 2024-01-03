package com.presstwo.input;

import org.junit.jupiter.api.Test;

import java.util.*;

public class test {
    @Test
    public void main()
    {
        int n = 4;
        Map<Integer, Integer> lookup = new HashMap<>();
        System.out.println(fib(n, lookup));
    }
    @Test
    public int fib(int n, Map<Integer, Integer> lookup)
    {
        if (n <= 1) {return n;}
        // если подзадача видна впервые
        if (!lookup.containsKey(n))
        {   System.out.println("recursive call");
            int val = fib(n - 1, lookup) + fib(n - 2, lookup);
            System.out.println("putting n to lookup: "+ n);
            lookup.put(n, val);
            System.out.println(Arrays.asList(lookup));
        }
        System.out.println("return n with value: "+ lookup.get(n));
        return lookup.get(n);
    }

    @Test
    public void main2()
    {
        Integer [] list2= new Integer[1];
        Integer [] list= new Integer[0];
        System.out.println("length2:"+list2.length);
        System.out.println("length:"+list.length);
String str= new String();

        List<Integer> list3= new ArrayList<>();
     //   list3.stream().flatMap()
    }
    @Test
    void test2(){
        rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 4);
    }
    public void rotate(int[] input, int step) {
        step = 4%7;
        System.out.println(input.length);
        System.out.println("step:" +step);

        reverse(input, 0, input.length - 1);
        reverse(input, 0, step - 1);
        reverse(input, step, input.length - 1);
    }

    private void reverse(int[] input, int start, int end) {
        while (start < end) {
            int temp = input[start];
            input[start] = input[end];
            input[end] = temp;
            start++;
            end--;
        }
    }

}