package org.jvirtanen.philadelphia;

/**
 * The protocol version.
 */
public enum FIXVersion {

    FIX_4_2("FIX.4.2");

    private String beginString;

    private FIXVersion(String beginString) {
        this.beginString = beginString;
    }

    /**
     * Get the BeginString(8).
     *
     * @return the BeginString(8)
     */
    public String getBeginString() {
        return beginString;
    }

}
