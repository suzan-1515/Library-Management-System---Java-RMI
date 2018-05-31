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
package com.sujan.lms.common.validation;

import java.awt.Component;
import java.util.Calendar;

/**
 *
 * @author Suzn
 */
public abstract class BaseValidation {

    protected final Component component;

    public BaseValidation(Component component) {
        this.component = component;
    }

    protected boolean isStringEmptyOrNull(String s) {
        s = s.trim();
        return (s == null || s.isEmpty() || s.matches(""));
    }

    protected boolean isContactValid(String c) {
        c = c.trim();
        return (c.length() < 9 || c.length() > 10);
    }

    protected boolean isDateEmptyOrNull(Calendar date) {
        return (date == null);
    }

    protected boolean isBeforeDateValid(Calendar expiryDate) {
        return expiryDate.before(java.util.Calendar.getInstance());
    }

    protected boolean isEmailValid(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

}
