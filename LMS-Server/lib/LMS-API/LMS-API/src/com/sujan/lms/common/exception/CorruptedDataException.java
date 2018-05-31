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
public class CorruptedDataException extends Exception {

    /**
     * Creates a new instance of <code>CorruptedDataexception</code> without
     * detail message.
     */
    public CorruptedDataException() {
        this("File data is corrupted!");
    }

    /**
     * Constructs an instance of <code>CorruptedDataexception</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CorruptedDataException(String msg) {
        super(msg);
    }

    public CorruptedDataException(Throwable thrwbl) {
        super("File data is corrupted!", thrwbl);
    }

    public CorruptedDataException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

}
