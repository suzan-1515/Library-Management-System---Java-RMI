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
package com.sujan.lms.ui.book.transaction;

import com.sujan.lms.bll.BookBLL;
import com.sujan.lms.bll.MemberBLL;
import com.sujan.lms.common.widget.Alert;
import com.sujan.lms.common.entity.book.BookInfo;
import com.sujan.lms.common.entity.member.MemberInfo;
import com.sujan.lms.common.util.Logy;
import java.awt.Frame;
import java.util.Calendar;

/**
 *
 * @author Suzn
 */
public abstract class BaseBookTransaction extends javax.swing.JDialog {

    public BaseBookTransaction(Frame frame, boolean bln) {
        super(frame, bln);
    }

    protected BookInfo getBook(String bookId) {
        try {
            return BookBLL.getBookById(Integer.parseInt(bookId));
        } catch (Exception ex) {
            Logy.e(ex);
            Alert.showError(this, ex.getMessage());
        }

        return null;
    }

    protected MemberInfo getMember(String memberId) {
        try {
            return MemberBLL.getMemberById(Integer.parseInt(memberId));
        } catch (Exception ex) {
            Logy.e(ex);
            Alert.showError(this, ex.getMessage());
        }

        return null;
    }

    protected int getDays(Calendar expiryDate) {
        return (int) ((expiryDate.getTime().getTime() - Calendar.getInstance().getTime().getTime())
                / (1000 * 60 * 60 * 24));
    }

}
