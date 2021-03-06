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
package com.sujan.lms.ui;

import com.sujan.lms.access.UserAccess;
import com.sujan.lms.common.entity.user.UserInfo;
import javax.swing.JFrame;
import com.sujan.lms.view.UserPermission;

/**
 *
 * @author Suzn
 */
public abstract class BaseDashboard extends JFrame implements UserPermission {

    private final UserAccess userAccess;

    public BaseDashboard() {
        userAccess = new UserAccess();
    }

    @Override
    public void setupUserView(UserInfo userInfo) {
        if (userAccess.isAdmin(userInfo)) {
            setupAdminView();
        } else if (userAccess.isLibrarian(userInfo)) {
            setupLibrarianView();
        } else if (userAccess.isMember(userInfo)) {
            setupMemberView();
        }
    }

    protected abstract void setupAdminView();

    protected abstract void setupLibrarianView();

    protected abstract void setupMemberView();

}
