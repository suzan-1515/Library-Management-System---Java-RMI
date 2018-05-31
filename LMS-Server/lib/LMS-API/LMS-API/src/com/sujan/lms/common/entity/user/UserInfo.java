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
package com.sujan.lms.common.entity.user;

import java.sql.Timestamp;

/**
 *
 * @author Suzn
 */
public class UserInfo extends User {

    private Timestamp loginTimestamp;
    private Timestamp logoutTimestamp;

    public UserInfo() {
    }

    
    public UserInfo(int id) {
        super(id);
    }

    /**
     * @return the loginTimestamp
     */
    public Timestamp getLoginTimestamp() {
        return loginTimestamp;
    }

    /**
     * @param loginTimestamp the loginTimestamp to set
     */
    public void setLoginTimestamp(Timestamp loginTimestamp) {
        this.loginTimestamp = loginTimestamp;
    }

    /**
     * @return the logoutTimestamp
     */
    public Timestamp getLogoutTimestamp() {
        return logoutTimestamp;
    }

    /**
     * @param logoutTimestamp the logoutTimestamp to set
     */
    public void setLogoutTimestamp(Timestamp logoutTimestamp) {
        this.logoutTimestamp = logoutTimestamp;
    }

}
