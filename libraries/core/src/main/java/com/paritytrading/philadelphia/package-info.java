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
