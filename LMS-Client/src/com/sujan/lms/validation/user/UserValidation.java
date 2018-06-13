/**
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
package com.sujan.lms.validation.user;

import com.sujan.lms.common.widget.Alert;
import com.sujan.lms.common.util.Logy;
import com.sujan.lms.common.validation.BaseValidation;
import java.awt.Component;
import java.util.Calendar;

/**
 *
 * @author Suzn
 */
public class UserValidation extends BaseValidation {

    public UserValidation(Component component) {
        super(component);
    }

    public boolean isUserFormValid(String name, String username, String confirmPassword) {
        Logy.d("Validating user insert form");
        if (isStringEmptyOrNull(name)) {
            Logy.d("User name not valid");
            Alert.showError(component, "Name field cannot be empty.");
            return false;
        }

        return isUserFormValid(username, confirmPassword);
    }

    public boolean isUserRegisterFormValid(String name, String username, String email,
            String tpNumber, Calendar dob, String course, String year, String password, String confirmPassword) {
        Logy.d("Validating user insert form");
        if (isStringEmptyOrNull(name)) {
            Logy.d("User name not valid");
            Alert.showError(component, "Name field cannot be empty.");
            return false;
        }

        if (isStringEmptyOrNull(tpNumber)) {
            Logy.d("User TP number not valid");
            Alert.showError(component, "TP number field cannot be empty.");
            return false;
        }

        if (!isBeforeDateValid(dob)) {
            Logy.d("User dob must be before current date");
            Alert.showError(component, "DOB must be before current date.");
            return false;
        }

        if (isStringEmptyOrNull(course)) {
            Logy.d("User course not valid");
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
            Logy.d("User email not valid");
            Alert.showError(component, "Email field cannot be empty.");
            return false;
        } else if (!isEmailValid(email)) {
            Logy.d("User email not valid");
            Alert.showError(component, "Email is not valid.");
            return false;
        }

        return isUserRegisterFormValid(username, password, confirmPassword);
    }

    public boolean isUserFormValid(String username, String password) {
        String s = username.trim();
        if (isStringEmptyOrNull(s)) {
            Logy.d("User username not valid");
            Alert.showError(component, "Username field cannot be empty.");
            return false;
        } else if (s.length() < 6 || s.length() > 10) {
            Logy.d("User username not valid");
            Alert.showError(component, "Username must be of between 6 to 10 characters");
            return false;
        }

        s = password.trim();
        if (isStringEmptyOrNull(s)) {
            Logy.d("User password not valid");
            Alert.showError(component, "Password field cannot be empty.");
            return false;
        } else if (s.length() < 8 || s.length() > 18) {
            Logy.d("User password not valid");
            Alert.showError(component, "Password number must be of between 8 to 18 characters");
            return false;
        }

        return true;
    }

    public boolean isUserRegisterFormValid(String username, String password, String confirmPassword) {
        String s = username.trim();
        if (isStringEmptyOrNull(s)) {
            Logy.d("User username not valid");
            Alert.showError(component, "Username field cannot be empty.");
            return false;
        } else if (s.length() < 6 || s.length() > 10) {
            Logy.d("User username not valid");
            Alert.showError(component, "Username must be of between 6 to 10 characters");
            return false;
        }

        s = password.trim();
        if (isStringEmptyOrNull(s)) {
            Logy.d("User password not valid");
            Alert.showError(component, "Password field cannot be empty.");
            return false;
        } else if (s.length() < 8 || s.length() > 18) {
            Logy.d("User password not valid");
            Alert.showError(component, "Password number must be of between 8 to 18 characters");
            return false;
        }

        String s1 = confirmPassword.trim();
        if (isStringEmptyOrNull(s1)) {
            Logy.d("User confirm password not valid");
            Alert.showError(component, "Confirm password field cannot be empty.");
            return false;
        } else if (s1.length() < 8 || s1.length() > 18) {
            Logy.d("User confirm password not valid");
            Alert.showError(component, "Confirm password number must be of between 8 to 18 characters");
            return false;
        }

        if (!s.equals(s1)) {
            Logy.d("User password do not match");
            Alert.showError(component, "Passwords do not match.");
            return false;
        }

        return true;
    }

    public boolean isLoginValid(String user, String pass) {
        Logy.d("Validating user login form");
        if (isStringEmptyOrNull(user)) {
            Logy.d("User username not valid");
            Alert.showError(component, "Username field cannot be empty.");
            return false;
        }

        if (isStringEmptyOrNull(pass)) {
            Logy.d("User password not valid");
            Alert.showError(component, "Password field cannot be empty.");
            return false;
        }

        return true;
    }

    public boolean isPasswordChangeValid(String pass, String confirmPass) {
        if (isStringEmptyOrNull(pass)) {
            Logy.d("User password not valid");
            Alert.showError(component, "Password field cannot be empty.");
            return false;
        }

        if (!pass.equals(confirmPass)) {
            Logy.d("User password do not match");
            Alert.showError(component, "Password do not match");
            return false;
        } else if (pass.length() < 8 || pass.length() > 18) {
            Logy.d("User password not valid");
            Alert.showError(component, "Password number must be of between 8 to 18 characters");
            return false;
        }

        return true;
    }

    public boolean isUserUpdateFormValid(String name, String username, String password) {

        Logy.d("Validating user update form");

        if (isStringEmptyOrNull(name)) {
            Logy.d("User name not valid");
            Alert.showError(component, "Name field cannot be empty.");
            return false;
        }

        String s = username.trim();
        if (isStringEmptyOrNull(s)) {
            Logy.d("User username not valid");
            Alert.showError(component, "Username field cannot be empty.");
            return false;
        } else if (s.length() < 6 || s.length() > 10) {
            Logy.d("User username not valid");
            Alert.showError(component, "Username must be of between 6 to 10 characters");
            return false;
        }

        s = password.trim();
        if (isStringEmptyOrNull(s)) {
            Logy.d("User password not valid");
            Alert.showError(component, "Password field cannot be empty.");
            return false;
        } else if (s.length() < 8 || s.length() > 18) {
            Logy.d("User password not valid");
            Alert.showError(component, "Password number must be of between 8 to 18 characters");
            return false;
        }

        return true;
    }

}
