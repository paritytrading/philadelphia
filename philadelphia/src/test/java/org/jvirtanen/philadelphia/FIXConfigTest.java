package org.jvirtanen.philadelphia;

import org.junit.Test;

public class FIXConfigTest {
    
    @Test
    public void beginStringLength() {
        FIXConfig config = new FIXConfig.Builder()
                .setVersion(FIXVersion.FIXT_1_1)
                .build();
        new FIXSession(null, config, null, null);
    }
}
