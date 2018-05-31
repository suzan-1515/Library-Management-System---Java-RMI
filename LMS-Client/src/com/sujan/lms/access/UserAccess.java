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
package com.sujan.lms.access;

import com.sujan.lms.common.entity.user.UserInfo;

/**
 *
 * @author Suzn
 */
public class UserAccess {

    public static final int ADMIN = 0;
    public static final int LIBRARIAN = 1;

    /**
     *
     * @param userInfo
     * @return
     */
    public boolean isAdmin(UserInfo userInfo) {
        return userInfo.getRole().getId() == ADMIN;
    }

    /**
     *
     * @param userInfo
     * @return
     */
    public boolean isLibrarian(UserInfo userInfo) {
        return userInfo.getRole().getId() == LIBRARIAN;
    }

}
