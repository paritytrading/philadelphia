package com.paritytrading.philadelphia.client.message;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Field {

    private static final Pattern PATTERN = Pattern.compile("(?<tag>\\d{1,5})=(?<value>.+)");

    private int    tag;
    private String value;

    public Field(int tag, String value) {
        this.tag   = tag;
        this.value = value;
    }

    public static Field get(String s) {
        Matcher matcher = PATTERN.matcher(s);
        if (!matcher.matches())
            throw new IllegalArgumentException();

        int    tag   = Integer.parseInt(matcher.group("tag"));
        String value = matcher.group("value");

        return new Field(tag, value);
    }

    public int getTag() {
        return tag;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("%d=%s", tag, value);
    }

}
