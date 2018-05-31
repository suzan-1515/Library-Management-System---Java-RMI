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

import com.sujan.lms.common.entity.author.Author;
import com.sujan.lms.common.entity.publisher.Publisher;
import com.sujan.lms.common.entity.shelf.Shelf;
import com.sujan.lms.common.entity.subject.Subject;
import java.io.Serializable;

/**
 *
 * @author Suzn
 */
public class Book implements Serializable {

    private int id;
    private String title;
    private Subject subject;
    private Author author;
    private Publisher publisher;
    private String edition;
    private String isbn;
    private Shelf shelfNo;
    private int numberOfCopy;

    public Book() {
    }

    
    
    public Book(int id) {
        this.id = id;
    }

        
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
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the subject
     */
    public Subject getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    /**
     * @return the author
     */
    public Author getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(Author author) {
        this.author = author;
    }

    /**
     * @return the publisher
     */
    public Publisher getPublisher() {
        return publisher;
    }

    /**
     * @param publisher the publisher to set
     */
    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    /**
     * @return the edition
     */
    public String getEdition() {
        return edition;
    }

    /**
     * @param edition the edition to set
     */
    public void setEdition(String edition) {
        this.edition = edition;
    }

    /**
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * @return the shelfNo
     */
    public Shelf getShelfNo() {
        return shelfNo;
    }

    /**
     * @param shelfNo the shelfNo to set
     */
    public void setShelfNo(Shelf shelfNo) {
        this.shelfNo = shelfNo;
    }

    /**
     * @return the numberOfCopy
     */
    public int getNumberOfCopy() {
        return numberOfCopy;
    }

    /**
     * @param numberOfCopy the numberOfCopy to set
     */
    public void setNumberOfCopy(int numberOfCopy) {
        this.numberOfCopy = numberOfCopy;
    }

}
