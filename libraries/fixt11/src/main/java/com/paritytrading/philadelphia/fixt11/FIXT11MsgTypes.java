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
package com.paritytrading.philadelphia.fixt11;

/*
 * This file has been automatically generated using Philadelphia Code
 * Generator. For more information on Philadelphia Code Generator, see:
 *
 *   https://github.com/paritytrading/philadelphia
 */

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
