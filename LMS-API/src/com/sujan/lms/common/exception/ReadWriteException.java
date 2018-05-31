/* 
 * Copyright (C) 2018 Suzn
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.sujan.lms.common.exception;

/**
 *
 * @author Suzn
 */
public class ReadWriteException extends Exception {

    /**
     * Creates a new instance of <code>ReadWriteException</code> without detail
     * message.
     */
    public ReadWriteException() {
        this("Error reading or writing file. First, make sure server is up and running!");
    }

    /**
     * Constructs an instance of <code>ReadWriteException</code> with the
     * specified detail message.
     *
     * @param message
     */
    public ReadWriteException(String message) {
        super(message);
    }

    /**
     *
     * @param message
     * @param thrwbl
     */
    public ReadWriteException(String message, Throwable thrwbl) {
        super(message, thrwbl);
    }

    /**
     *
     * @param thrwbl
     */
    public ReadWriteException(Throwable thrwbl) {
        super("Error reading or writing file. First, make sure server is up and running!", thrwbl);
    }

}
