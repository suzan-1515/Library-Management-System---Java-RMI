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
package com.sujan.lms.bll;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.sujan.lms.common.exception.UnknownException;
import com.sujan.lms.common.entity.book.Book;
import com.sujan.lms.common.entity.book.BookInfo;
import com.sujan.lms.common.exception.CorruptedDataException;
import com.sujan.lms.common.exception.DuplicateRecordException;
import com.sujan.lms.common.exception.MissingFileException;
import com.sujan.lms.common.exception.RecordNotFoundException;
import com.sujan.lms.common.params.BookParams;
import com.sujan.lms.common.dao.BookDAO;
import com.sujan.lms.common.util.ExceptionUtils;
import com.sujan.lms.common.exception.ReadWriteException;
import com.sujan.lms.rmi.RMIConnectionManager;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.List;

/**
 *
 * @author Suzn
 */
public class BookBLL {

    /**
     *
     * @param bookInfo
     * @return
     * @throws DuplicateRecordException
     * @throws MissingFileException
     * @throws CorruptedDataException
     * @throws NotBoundException
     * @throws UnknownException
     * @throws ReadWriteException
     */
    public static int insertBook(BookInfo bookInfo) throws DuplicateRecordException, MissingFileException,
            CorruptedDataException, NotBoundException, UnknownException, ReadWriteException {

        Registry registry = RMIConnectionManager.getRegistry();
        BookDAO bookDAO;
        try {
            bookDAO = (BookDAO) registry.lookup(BookParams.FILENAME);
            if (bookDAO.isBookAvailable(bookInfo)) {
                throw new DuplicateRecordException();
            }

            return bookDAO.save(bookInfo);
        } catch (RemoteException e) {
            Throwable ex = ExceptionUtils.dwrapRemoteException(e);
            if (ex instanceof JsonSyntaxException) {
                throw new CorruptedDataException(e);
            } else if (ex instanceof FileNotFoundException) {
                throw new MissingFileException(BookParams.FILENAME, e);
            } else if ((ex instanceof JsonIOException) || (ex instanceof IOException)) {
                throw new ReadWriteException(e);
            } else {
                throw new UnknownException(e);
            }
        }
    }

    /**
     *
     * @param bookInfo
     * @return
     * @throws RecordNotFoundException
     * @throws MissingFileException
     * @throws CorruptedDataException
     * @throws NotBoundException
     * @throws UnknownException
     * @throws ReadWriteException
     */
    public static int updateBook(BookInfo bookInfo) throws RecordNotFoundException,
            MissingFileException, CorruptedDataException, NotBoundException, UnknownException, ReadWriteException {

        Registry registry = RMIConnectionManager.getRegistry();
        BookDAO bookDAO;
        try {

            bookDAO = (BookDAO) registry.lookup(BookParams.FILENAME);
            if (!bookDAO.isBookAvailable(bookInfo)) {
                throw new RecordNotFoundException();
            }

            return bookDAO.update(bookInfo);
        } catch (RemoteException e) {
            Throwable ex = ExceptionUtils.dwrapRemoteException(e);
            if (ex instanceof JsonSyntaxException) {
                throw new CorruptedDataException(e);
            } else if (ex instanceof FileNotFoundException) {
                throw new MissingFileException(BookParams.FILENAME, e);
            } else if ((ex instanceof JsonIOException) || (ex instanceof IOException)) {
                throw new ReadWriteException(e);
            } else {
                throw new UnknownException(e);
            }
        }
    }

    /**
     *
     * @param bookInfo
     * @return
     * @throws RecordNotFoundException
     * @throws MissingFileException
     * @throws CorruptedDataException
     * @throws NotBoundException
     * @throws UnknownException
     * @throws ReadWriteException
     */
    public static int deleteBook(BookInfo bookInfo) throws RecordNotFoundException, MissingFileException,
            CorruptedDataException, NotBoundException, UnknownException, ReadWriteException {

        Registry registry = RMIConnectionManager.getRegistry();
        BookDAO bookDAO;
        try {
            bookDAO = (BookDAO) registry.lookup(BookParams.FILENAME);
            if (!bookDAO.isBookAvailable(bookInfo)) {
                throw new RecordNotFoundException();
            }

            return bookDAO.remove(bookInfo);
        } catch (RemoteException e) {
            Throwable ex = ExceptionUtils.dwrapRemoteException(e);
            if (ex instanceof JsonSyntaxException) {
                throw new CorruptedDataException(e);
            } else if (ex instanceof FileNotFoundException) {
                throw new MissingFileException(BookParams.FILENAME, e);
            } else if ((ex instanceof JsonIOException) || (ex instanceof IOException)) {
                throw new ReadWriteException(e);
            } else {
                throw new UnknownException(e);
            }
        }
    }

    /**
     *
     * @param id
     * @return
     * @throws RecordNotFoundException
     * @throws MissingFileException
     * @throws CorruptedDataException
     * @throws NotBoundException
     * @throws UnknownException
     * @throws ReadWriteException
     */
    public static BookInfo getBookById(int id) throws RecordNotFoundException, MissingFileException,
            CorruptedDataException, NotBoundException, UnknownException, ReadWriteException {

        Registry registry = RMIConnectionManager.getRegistry();
        BookDAO bookDAO;
        try {

            bookDAO = (BookDAO) registry.lookup(BookParams.FILENAME);

            return bookDAO.findById(id);
        } catch (RemoteException e) {
            Throwable ex = ExceptionUtils.dwrapRemoteException(e);
            if (ex instanceof JsonSyntaxException) {
                throw new CorruptedDataException(e);
            } else if (ex instanceof FileNotFoundException) {
                throw new MissingFileException(BookParams.FILENAME, e);
            } else if ((ex instanceof JsonIOException) || (ex instanceof IOException)) {
                throw new ReadWriteException(e);
            } else {
                throw new UnknownException(e);
            }
        }
    }

    /**
     *
     * @return @throws RecordNotFoundException
     * @throws MissingFileException
     * @throws CorruptedDataException
     * @throws UnknownException
     * @throws NotBoundException
     * @throws ReadWriteException
     */
    public static List<BookInfo> getAllBook() throws RecordNotFoundException, MissingFileException,
            CorruptedDataException, UnknownException, NotBoundException, ReadWriteException {

        Registry registry = RMIConnectionManager.getRegistry();
        BookDAO bookDAO;
        try {

            bookDAO = (BookDAO) registry.lookup(BookParams.FILENAME);
            return bookDAO.findAll();
        } catch (RemoteException e) {
            Throwable ex = ExceptionUtils.dwrapRemoteException(e);
            if (ex instanceof JsonSyntaxException) {
                throw new CorruptedDataException(e);
            } else if (ex instanceof FileNotFoundException) {
                throw new MissingFileException(BookParams.FILENAME, e);
            } else if ((ex instanceof JsonIOException) || (ex instanceof IOException)) {
                throw new ReadWriteException(e);
            } else {
                throw new UnknownException(e);
            }
        }
    }

    /**
     *
     * @param book
     * @return
     * @throws RecordNotFoundException
     * @throws MissingFileException
     * @throws CorruptedDataException
     * @throws NotBoundException
     * @throws UnknownException
     * @throws ReadWriteException
     */
    public static boolean isBookAvailable(Book book) throws RecordNotFoundException, MissingFileException,
            CorruptedDataException, NotBoundException, UnknownException, ReadWriteException {
        return getBookById(book.getId()) != null;
    }

}
