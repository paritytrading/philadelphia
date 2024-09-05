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

class FIX {

    static final byte EQUALS = '=';

    static final byte SOH = 1;

    static final byte YES = 'Y';

    static final byte NO = 'N';

    static final byte[] BEGIN_STRING_BYTES = { '8', '=' };

    static final byte[] BODY_LENGTH_BYTES = { '9', '=' };

    static final byte[] CHECK_SUM_BYTES = { '1', '0', '=' };

    static final short BEGIN_STRING_SHORT = '8' << 8 | '=';

    static final short BODY_LENGTH_SHORT = '9' << 8 | '=';

    static final int BODY_LENGTH_FIELD_CAPACITY = 16;

    static final int CHECK_SUM_FIELD_CAPACITY = 8;

    static final int ADMIN_MESSAGE_CAPACITY = 8;

}
