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
package com.sujan.lms.common.entity.book;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Suzn
 */
public class Books implements Serializable {

    private List<Book> books;

    /**
     * @return the books
     */
    public List<Book> getBooks() {
        return books;
    }

    /**
     * @param books the books to set
     */
    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        if (this.books == null) {
            this.books = new ArrayList<>();
        }
        this.books.add(book);
    }

}
