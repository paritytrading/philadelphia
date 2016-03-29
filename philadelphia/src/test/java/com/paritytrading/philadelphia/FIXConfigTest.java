package com.paritytrading.philadelphia;

import org.junit.Test;

public class FIXConfigTest {

    @Test
    public void fixt11() {
        FIXConfig config = new FIXConfig.Builder()
                .setVersion(FIXVersion.FIXT_1_1)
                .build();
        new FIXSession(null, config, null, null);
    }

}
