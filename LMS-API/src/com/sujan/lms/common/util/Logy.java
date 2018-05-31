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
package com.sujan.lms.common.util;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Suzn
 */
public class Logy {

    public static String TAG = "LMS";

    public static void init(String tag) {
        TAG = tag;
    }

    public static void d(String message) {
        System.out.println(String.format("Log-%s: %s", TAG, message));
    }

    public static void e(Throwable t) {
        Logger.getLogger(TAG).log(Level.SEVERE, null, t);
    }

}
