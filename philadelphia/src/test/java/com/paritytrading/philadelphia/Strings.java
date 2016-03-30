package com.paritytrading.philadelphia;

class Strings {

    public static String repeat(char c, int num) {
        StringBuilder builder = new StringBuilder(num);

        for (int i = 0; i < num; i++)
            builder.append(c);

        return builder.toString();
    }

}
