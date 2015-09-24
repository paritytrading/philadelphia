package org.jvirtanen.philadelphia;

import java.io.IOException;

interface TestMessageListener {

    void message(String message) throws IOException;

}
