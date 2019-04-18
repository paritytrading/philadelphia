/*
 * Copyright 2015 Philadelphia authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.paritytrading.philadelphia.client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Field {

    private static final Pattern PATTERN = Pattern.compile("(?<tag>\\d{1,5})=(?<value>.+)");

    private final int    tag;
    private final String value;

    Field(int tag, String value) {
        this.tag   = tag;
        this.value = value;
    }

    static Field get(String s) {
        Matcher matcher = PATTERN.matcher(s);
        if (!matcher.matches())
            throw new IllegalArgumentException();

        int    tag   = Integer.parseInt(matcher.group("tag"));
        String value = matcher.group("value");

        return new Field(tag, value);
    }

    int getTag() {
        return tag;
    }

    String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("%d=%s", tag, value);
    }

}
