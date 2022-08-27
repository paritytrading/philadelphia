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
package com.paritytrading.philadelphia;

import static com.paritytrading.philadelphia.FIX.*;
import static java.nio.charset.StandardCharsets.*;

/**
 * The protocol version.
 */
public enum FIXVersion {

    /**
     * FIX 4.0.
     */
    FIX_4_0("FIX.4.0"),

    /**
     * FIX 4.1.
     */
    FIX_4_1("FIX.4.1"),

    /**
     * FIX 4.2.
     */
    FIX_4_2("FIX.4.2"),

    /**
     * FIX 4.3.
     */
    FIX_4_3("FIX.4.3"),

    /**
     * FIX 4.4.
     */
    FIX_4_4("FIX.4.4"),

    /**
     * FIXT 1.1.
     */
    FIXT_1_1("FIXT.1.1");

    private final byte[] beginString;

    private FIXVersion(String beginString) {
        this.beginString = beginString.getBytes(US_ASCII);
    }

    byte[] getBeginString() {
        return beginString;
    }

}
