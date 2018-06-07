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
package com.sujan.lms.validation.member;

import com.sujan.lms.common.widget.Alert;
import com.sujan.lms.common.util.Logy;
import com.sujan.lms.common.validation.BaseValidation;
import java.awt.Component;
import java.util.Calendar;

/**
 *
 * @author Suzn
 */
public class MemberValidation extends BaseValidation {

    public MemberValidation(Component component) {
        super(component);
    }

    public boolean isMemberRegisterFormValid(String name, String username, String email,
            String tpNumber, Calendar dob, String course, String year, String password,
            String confirmPassword, Calendar expiryDate) {
        Logy.d("Validating member insert form");
        if (isStringEmptyOrNull(name)) {
            Logy.d("Member name not valid");
            Alert.showError(component, "Name field cannot be empty.");
            return false;
        }

        if (isStringEmptyOrNull(tpNumber)) {
            Logy.d("Member TP number not valid");
            Alert.showError(component, "TP number field cannot be empty.");
            return false;
        }

        if (!isBeforeDateValid(dob)) {
            Logy.d("Member dob must be before current date");
            Alert.showError(component, "DOB must be before current date.");
            return false;
        }

        if (isBeforeDateValid(expiryDate)) {
            Logy.d("Member expiryDate must be after current date");
            Alert.showError(component, "Expiry date must be after current date.");
            return false;
        }

        if (isStringEmptyOrNull(course)) {
            Logy.d("Member course not valid");
            Alert.showError(component, "Course field cannot be empty.");
            return false;
        }

        if (isStringEmptyOrNull(year)) {
            Logy.d("Year not valid");
            Alert.showError(component, "Year field cannot be empty.");
            return false;
        } else if (year.trim().length() < 4 || year.trim().length() > 4) {
            Logy.d("Year not valid");
            Alert.showError(component, "Year must be of 4 digit");
            return false;
        }

        if (isStringEmptyOrNull(email)) {
            Logy.d("Member email not valid");
            Alert.showError(component, "Email field cannot be empty.");
            return false;
        } else if (!isEmailValid(email)) {
            Logy.d("Member email not valid");
            Alert.showError(component, "Email is not valid.");
            return false;
        }

        return isMemberRegisterFormValid(username, password, confirmPassword);
    }

    public boolean isMemberRegisterFormValid(String username, String password, String confirmPassword) {
        String s = username.trim();
        if (isStringEmptyOrNull(s)) {
            Logy.d("Member username not valid");
            Alert.showError(component, "Username field cannot be empty.");
            return false;
        } else if (s.length() < 6 || s.length() > 10) {
            Logy.d("Member username not valid");
            Alert.showError(component, "Username must be of between 6 to 10 characters");
            return false;
        }

        s = password.trim();
        if (isStringEmptyOrNull(s)) {
            Logy.d("Member password not valid");
            Alert.showError(component, "Password field cannot be empty.");
            return false;
        } else if (s.length() < 8 || s.length() > 18) {
            Logy.d("Member password not valid");
            Alert.showError(component, "Password number must be of between 8 to 18 characters");
            return false;
        }

        String s1 = confirmPassword.trim();
        if (isStringEmptyOrNull(s1)) {
            Logy.d("Member confirm password not valid");
            Alert.showError(component, "Confirm password field cannot be empty.");
            return false;
        } else if (s1.length() < 8 || s1.length() > 18) {
            Logy.d("Member confirm password not valid");
            Alert.showError(component, "Confirm password number must be of between 8 to 18 characters");
            return false;
        }

        if (!s.equals(s1)) {
            Logy.d("Member password do not match");
            Alert.showError(component, "Passwords do not match.");
            return false;
        }

        return true;
    }

}
