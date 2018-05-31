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
package com.sujan.lms.common.entity.borrow;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author Suzn
 */
public class Borrow implements Serializable {

    private int id;
    private int numOfDays;
    private long returningDate;
    private Timestamp timestamp;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the numOfDays
     */
    public int getNumOfDays() {
        return numOfDays;
    }

    /**
     * @param numOfDays the numOfDays to set
     */
    public void setNumOfDays(int numOfDays) {
        this.numOfDays = numOfDays;
    }

    /**
     * @return the returningDate
     */
    public long getReturningDate() {
        return returningDate;
    }

    /**
     * @param returningDate the returningDate to set
     */
    public void setReturningDate(long returningDate) {
        this.returningDate = returningDate;
    }

    /**
     * @return the timestamp
     */
    public Timestamp getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

}
