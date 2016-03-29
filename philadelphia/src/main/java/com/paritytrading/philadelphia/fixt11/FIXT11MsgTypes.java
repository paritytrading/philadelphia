package com.paritytrading.philadelphia.fixt11;

/**
 * Message types for FIXT 1.1.
 */
public class FIXT11MsgTypes {

    public static final char Heartbeat     = '0';
    public static final char TestRequest   = '1';
    public static final char ResendRequest = '2';
    public static final char Reject        = '3';
    public static final char SequenceReset = '4';
    public static final char Logout        = '5';
    public static final char Logon         = 'A';
    public static final char XMLnonFIX     = 'n';

    private FIXT11MsgTypes() {
    }

}
