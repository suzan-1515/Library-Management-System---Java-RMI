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
package com.sujan.lms.util;

import java.sql.Date;
import java.util.Calendar;
import javax.swing.JTable;

/**
 *
 * @author Suzn
 */
public class Utils {

    public static int generateRandomID() {
        return (int) (Math.random() * 90000) + 10000;
    }

    public static java.sql.Date calanderToSqlDate(java.util.Calendar calendar) {
        return new java.sql.Date(calendar.getTimeInMillis());
    }

    public static java.util.Calendar sqlToCalandarDate(Date expiryDate) {
        java.util.Calendar c = new java.util.GregorianCalendar();
        c.setTime(expiryDate);
        return c;
    }

    public static Calendar millisToCalendar(long expiryDate) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(expiryDate);
        return c;
    }

    public static java.sql.Date millisToSql(long expiryDate) {
        return new java.sql.Date(expiryDate);
    }

    public static boolean isTableRowSelected(final javax.swing.JTable table) {
        return table.getSelectedRow() > -1;
    }

    public static int getIdFromTable(JTable table, int row) {
        return (int) table.getModel().getValueAt(row, 0);
    }
   

}
