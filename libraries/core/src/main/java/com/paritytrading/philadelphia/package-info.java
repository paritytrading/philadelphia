/**
 * An implementation of the FIX protocol.
 *
 * <p>The implementation is based on the Java NIO API and consists of three
 * primary functions:</p>
 * <ul>
 * <li>data reception
 *   ({@link com.paritytrading.philadelphia.FIXConnection#receive})</li>
 * <li>data transmission</li>
 * <li>connection keep-alive
 *   ({@link com.paritytrading.philadelphia.FIXConnection#keepAlive})</li>
 * </ul>
 *
 * <p>Data reception can run on one thread and data transmission and
 * connection keep-alive on another without locking. Data transmission and
 * connection keep-alive can run on different threads but require locking.</p>
 *
 * <p>The underlying socket channels can be either blocking or non-blocking.
 * In both cases, data transmission always blocks.</p>
 */
package com.paritytrading.philadelphia;
