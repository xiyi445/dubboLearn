package com.ls.provider;

public class MessageFormat {
    protected static final String PATTERN_D1 = "%d'{'yyyy-MM-dd/HH:mm:ss.SSS'}'|{0}|%X'{'requestId:--'}'|%X'{'requestSeq:--'}'";


    public static void main(String[] args) {
        System.out.println(java.text.MessageFormat.format(PATTERN_D1, "aa"));
    }
}
