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

/**
 * The protocol version.
 */
public enum FIXVersion {

    /**
     * FIX 4.2.
     */
    FIX_4_2(new byte[] { 'F', 'I', 'X', '.', '4', '.', '2', SOH }),

    /**
     * FIX 4.3.
     */
    FIX_4_3(new byte[] { 'F', 'I', 'X', '.', '4', '.', '3', SOH }),

    /**
     * FIX 4.4.
     */
    FIX_4_4(new byte[] { 'F', 'I', 'X', '.', '4', '.', '4', SOH }),

    /**
     * FIXT 1.1.
     */
    FIXT_1_1(new byte[] { 'F', 'I', 'X', 'T', '.', '1', '.', '1', SOH });

    private final byte[] beginString;

    private FIXVersion(byte[] beginString) {
        this.beginString = beginString;
    }

    byte[] getBeginString() {
        return beginString;
    }

}
