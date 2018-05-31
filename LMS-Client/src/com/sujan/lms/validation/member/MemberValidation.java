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

    public boolean isMemberFormValid(String name, String address, String contact, Calendar expiryDate) {
        Logy.d("Validating member insert form");
        if (isStringEmptyOrNull(name)) {
            Logy.d("Member name not valid");
            Alert.showError(component, "Name field cannot be empty.");
            return false;
        }

        if (isStringEmptyOrNull(address)) {
            Logy.d("Member address not valid");
            Alert.showError(component, "Address field cannot be empty.");
            return false;
        }
        if (isStringEmptyOrNull(contact)) {
            Logy.d("Member contact not valid");
            Alert.showError(component, "Contact field cannot be empty.");
            return false;
        } else if (isContactValid(contact)) {
            Logy.d("Member contact not valid");
            Alert.showError(component, "Contact number must be of 9 or 10 digits");
            return false;
        }

        if (isDateEmptyOrNull(expiryDate)) {
            Logy.d("Member expiry date not valid");
            Alert.showError(component, "Expiry date field cannot be empty.");
            return false;
        } else if (isBeforeDateValid(expiryDate)) {
            Logy.d("Member expiry date not valid");
            Alert.showError(component, "Expiry date must be after current date.");
            return false;
        }

        return true;
    }

}
