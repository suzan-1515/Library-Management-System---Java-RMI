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
package com.sujan.lms.validation.book;

import com.sujan.lms.common.validation.BaseValidation;
import com.sujan.lms.common.widget.Alert;
import com.sujan.lms.common.util.Logy;
import com.sujan.lms.util.Utils;
import java.awt.Component;
import java.util.Calendar;

/**
 *
 * @author Suzn
 */
public class BookValidation extends BaseValidation {

    public BookValidation(Component component) {
        super(component);
    }

    public boolean isStockFormValid(String title, String edition, String isbn, String quantity) {
        Logy.d("Validating book stock insert form");
        if (isStringEmptyOrNull(title)) {
            Logy.d("Book title not valid");
            Alert.showError(component, "Title field cannot be empty.");
            return false;
        }

        if (isStringEmptyOrNull(edition)) {
            Logy.d("Edition not valid");
            Alert.showError(component, "Edition field cannot be empty.");
            return false;
        } else if (edition.trim().length() < 4 || edition.trim().length() > 4) {
            Logy.d("Edition not valid");
            Alert.showError(component, "Edition must be of 4 digit");
            return false;
        }
        if (isStringEmptyOrNull(isbn)) {
            Logy.d("ISBN not valid");
            Alert.showError(component, "ISBN field cannot be empty.");
            return false;
        }

        if (isStringEmptyOrNull(quantity)) {
            Logy.d("Quantity not valid");
            Alert.showError(component, "Quantity field cannot be empty.");
            return false;
        } else if (quantity.trim().matches("0")) {
            Logy.d("Quantity not valid");
            Alert.showError(component, "Quantity must be greater than 0.");
            return false;
        }

        Logy.d("Book stock insert form is validated");

        return true;
    }

    public boolean isSubjectFormValid(String title) {
        Logy.d("Validating book subject insert form");
        if (isStringEmptyOrNull(title)) {
            Logy.d("subject title not valid");
            Alert.showError(component, "Title field cannot be empty.");
            return false;
        }

        Logy.d("Book subject insert form is validated");

        return true;
    }

    public boolean isAuthorFormValid(String title, String contact) {
        Logy.d("Validating book author insert form");
        if (isStringEmptyOrNull(title)) {
            Logy.d("author title not valid");
            Alert.showError(component, "Title field cannot be empty.");
            return false;
        }

        if (isStringEmptyOrNull(contact)) {
            Logy.d("author contact not valid");
            Alert.showError(component, "Contact field cannot be empty.");
            return false;
        } else if (isContactValid(contact)) {
            Logy.d("author contact not valid");
            Alert.showError(component, "Contact number must be of 9 or 10 digits");
            return false;
        }

        Logy.d("Book author insert form is validated");

        return true;
    }

    public boolean isPublisherFormValid(String title, String contact) {
        Logy.d("Validating book publisher insert form");
        if (isStringEmptyOrNull(title)) {
            Logy.d("publisher title not valid");
            Alert.showError(component, "Title field cannot be empty.");
            return false;
        }

        if (isStringEmptyOrNull(contact)) {
            Logy.d("publisher contact not valid");
            Alert.showError(component, "Contact field cannot be empty.");
            return false;
        } else if (isContactValid(contact)) {
            Logy.d("publisher contact not valid");
            Alert.showError(component, "Contact number must be of 9 or 10 digits");
            return false;
        }

        Logy.d("Book publisher insert form is validated");

        return true;
    }

    public boolean isShelfFormValid(String title) {
        Logy.d("Validating book shelf insert form");
        if (isStringEmptyOrNull(title)) {
            Logy.d("shelf title not valid");
            Alert.showError(component, "Title field cannot be empty.");
            return false;
        }

        Logy.d("Book shelf insert form is validated");

        return true;
    }

    public boolean isBorrowFormValid(String book, String member, Calendar returningDate) {
        Logy.d("Validating borrow insert form");
        if (isStringEmptyOrNull(book)) {
            Logy.d("Borrow book not valid");
            Alert.showError(component, "Book Id field cannot be empty.");
            return false;
        }

        if (isStringEmptyOrNull(member)) {
            Logy.d("Borrow member not valid");
            Alert.showError(component, "Member Id field cannot be empty.");
            return false;
        }

        if (returningDate == null || isStringEmptyOrNull(returningDate.toString())) {
            Logy.d("Borrow returning date not valid");
            Alert.showError(component, "Returning date field cannot be empty.");
            return false;
        }

        if (isBeforeDateValid(returningDate)) {
            Logy.d("Borrow returning date not valid");
            Alert.showError(component, "Returning date must be after current date.");
            return false;
        }

        Logy.d("Borrow insert form is validated");

        return true;
    }

    public boolean isReturnFormValid(String book, String member) {
        Logy.d("Validating return insert form");
        if (isStringEmptyOrNull(book)) {
            Logy.d("Return book not valid");
            Alert.showError(component, "Book Id field cannot be empty.");
            return false;
        }

        if (isStringEmptyOrNull(member)) {
            Logy.d("Return member not valid");
            Alert.showError(component, "Member Id field cannot be empty.");
            return false;
        }

        return true;
    }

    public boolean isBookAvailable(int availableCopies) {
        return availableCopies > 0;
    }

    public boolean isMemberValid(long expiryDate) {
        return !isBeforeDateValid(Utils.millisToCalendar(expiryDate));
    }

}
