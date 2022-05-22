package runners;

import helpers.MyArrayList;

public class MyListTester {
    public static void main(String[] args) {
        MyArrayList<String> myList = new MyArrayList<>();
        myList.add("1");
        myList.add("2");
        myList.add("3");
        myList.add("4");
        myList.add("5");
        myList.add("6");
        myList.add("7");
        System.out.println("size="+myList.size());
    }
}
