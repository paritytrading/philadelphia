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

/**
 * Indicates that the message length exceeds the capacity of the receive buffer
 * or that the number of fields exceeds the capacity of a message container.
 */
public class FIXMessageOverflowException extends FIXException {

    /**
     * Construct an instance with the specified detail message.
     *
     * @param message the detail message
     */
    public FIXMessageOverflowException(String message) {
        super(message);
    }

}
