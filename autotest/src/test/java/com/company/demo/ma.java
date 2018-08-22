package com.company.demo;

public class ma {
    public static void main(String []args) {
        String[] value = new String[]{"a","b","c"};
        String str = "";
        for (String i : value) {
            str = str + i + ",";
        }
        str = str.substring(0, str.length() - 1);
        System.out.println(str);

    }

}
