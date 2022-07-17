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

import org.junit.jupiter.api.Test;

class FIXConfigTest {

    @SuppressWarnings("resource")
    @Test
    void fixt11() {
        FIXConfig config = new FIXConfig.Builder()
                .setVersion(FIXVersion.FIXT_1_1)
                .build();
        new FIXConnection(null, config, null, null);
    }

}
