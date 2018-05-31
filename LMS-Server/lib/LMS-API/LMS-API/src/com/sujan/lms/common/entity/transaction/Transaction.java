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
package com.sujan.lms.common.entity.transaction;

import com.sujan.lms.common.entity.book.BookInfo;
import com.sujan.lms.common.entity.borrow.Borrow;
import com.sujan.lms.common.entity.member.MemberInfo;
import com.sujan.lms.common.entity.returnn.Return;
import com.sujan.lms.common.entity.user.UserInfo;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author Suzn
 */
public class Transaction implements Serializable {

    private int id;
    private BookInfo book;
    private MemberInfo member;
    private UserInfo user;
    private Borrow borrow;
    private Return retrn;
    private boolean status;
    private Timestamp timestamp;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the book
     */
    public BookInfo getBook() {
        return book;
    }

    /**
     * @param book the book to set
     */
    public void setBook(BookInfo book) {
        this.book = book;
    }

    /**
     * @return the member
     */
    public MemberInfo getMember() {
        return member;
    }

    /**
     * @param member the member to set
     */
    public void setMember(MemberInfo member) {
        this.member = member;
    }

    /**
     * @return the user
     */
    public UserInfo getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(UserInfo user) {
        this.user = user;
    }

    /**
     * @return the borrow
     */
    public Borrow getBorrow() {
        return borrow;
    }

    /**
     * @param borrow the borrow to set
     */
    public void setBorrow(Borrow borrow) {
        this.borrow = borrow;
    }

    /**
     * @return the retrn
     */
    public Return getRetrn() {
        return retrn;
    }

    /**
     * @param retrn the retrn to set
     */
    public void setRetrn(Return retrn) {
        this.retrn = retrn;
    }

    /**
     * @return the timestamp
     */
    public Timestamp getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

}
