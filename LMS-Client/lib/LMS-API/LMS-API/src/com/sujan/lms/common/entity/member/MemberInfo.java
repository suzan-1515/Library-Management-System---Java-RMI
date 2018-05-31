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
package com.sujan.lms.common.entity.member;

/**
 *
 * @author Suzn
 */
public class MemberInfo extends Member {

    private long expiryDate;
    private long joinedDate;

    public MemberInfo() {
    }

    
    public MemberInfo(int id) {
        super(id);
    }

    /**
     * @return the expiryDate
     */
    public long getExpiryDate() {
        return expiryDate;
    }

    /**
     * @param expiryDate the expiryDate to set
     */
    public void setExpiryDate(long expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * @return the joinedDate
     */
    public long getJoinedDate() {
        return joinedDate;
    }

    /**
     * @param joinedDate the joinedDate to set
     */
    public void setJoinedDate(long joinedDate) {
        this.joinedDate = joinedDate;
    }

}
