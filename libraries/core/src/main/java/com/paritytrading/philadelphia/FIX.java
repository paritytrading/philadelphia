package com.paritytrading.philadelphia;

class FIX {

    static final byte EQUALS = '=';

    static final byte SOH = 1;

    static final byte YES = 'Y';

    static final byte NO = 'N';

    static final byte[] BEGIN_STRING = new byte[] { '8', '=' };

    static final byte[] BODY_LENGTH = new byte[] { '9', '=' };

    static final byte[] CHECK_SUM = new byte[] { '1', '0', '=' };

    static final int BEGIN_STRING_FIELD_CAPACITY = 16;

    static final int BODY_LENGTH_FIELD_CAPACITY = 16;

    static final int CHECK_SUM_FIELD_CAPACITY = 8;

}
