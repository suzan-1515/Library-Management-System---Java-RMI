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
package com.sujan.lms.common.entity.address;

import java.io.Serializable;

/**
 *
 * @author Suzn
 */
public class Address implements Serializable {

    private String permanent;
    private String temporary;

    public Address() {
    }

    public Address(String permanent, String temporary) {
        this.permanent = permanent;
        this.temporary = temporary;
    }

    public Address(String temporary) {
        this.permanent = temporary;
        this.temporary = temporary;
    }

    /**
     * @return the permanent
     */
    public String getPermanent() {
        return permanent;
    }

    /**
     * @param permanent the permanent to set
     */
    public void setPermanent(String permanent) {
        this.permanent = permanent;
    }

    /**
     * @return the temporary
     */
    public String getTemporary() {
        return temporary;
    }

    /**
     * @param temporary the temporary to set
     */
    public void setTemporary(String temporary) {
        this.temporary = temporary;
    }

}
