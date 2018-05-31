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
public class MissingFileException extends Exception {

    /**
     * Creates a new instance of <code>MissingFileException</code> without
     * detail message.
     */
    public MissingFileException() {
    }

    /**
     * Constructs an instance of <code>MissingFileException</code> with the
     * specified detail message.
     *
     * @param filename the missing filename.
     */
    public MissingFileException(String filename) {
        super(String.format("%s file is missing!", filename));
    }

    /**
     *
     * @param filename
     * @param thrwbl
     */
    public MissingFileException(String filename, Throwable thrwbl) {
        super(String.format("%s file is missing!", filename), thrwbl);
    }

    /**
     *
     * @param thrwbl
     */
    public MissingFileException(Throwable thrwbl) {
        super(thrwbl);
    }

}
