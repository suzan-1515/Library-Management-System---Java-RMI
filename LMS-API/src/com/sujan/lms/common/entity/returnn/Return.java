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
package com.sujan.lms.common.entity.returnn;

import com.sujan.lms.entity.book.Fine;
import java.io.Serializable;

/**
 *
 * @author Suzn
 */
public class Return implements Serializable {

    private int id;
    private Fine fine;
    private long returnedDate;

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
     * @return the fine
     */
    public Fine getFine() {
        return fine;
    }

    /**
     * @param fine the fine to set
     */
    public void setFine(Fine fine) {
        this.fine = fine;
    }

    /**
     * @return the returnedDate
     */
    public long getReturnedDate() {
        return returnedDate;
    }

    /**
     * @param returnedDate the returnedDate to set
     */
    public void setReturnedDate(long returnedDate) {
        this.returnedDate = returnedDate;
    }

}
