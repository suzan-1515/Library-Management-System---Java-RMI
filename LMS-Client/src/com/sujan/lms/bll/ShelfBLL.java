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
import com.sujan.lms.common.dao.ShelfDAO;
import com.sujan.lms.common.exception.UnknownException;
import com.sujan.lms.common.entity.shelf.Shelf;
import com.sujan.lms.common.exception.CorruptedDataException;
import com.sujan.lms.common.exception.DuplicateRecordException;
import com.sujan.lms.common.exception.MissingFileException;
import com.sujan.lms.common.exception.ReadWriteException;
import com.sujan.lms.common.exception.RecordNotFoundException;
import com.sujan.lms.common.params.ShelfParams;
import com.sujan.lms.common.util.ExceptionUtils;
import com.sujan.lms.rmi.RMIConnectionManager;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.List;

/**
 *
 * @shelf Suzn
 */
public class ShelfBLL {

    /**
     *
     * @param shelfInfo
     * @return
     * @throws DuplicateRecordException
     * @throws MissingFileException
     * @throws CorruptedDataException
     * @throws NotBoundException
     * @throws UnknownException
     * @throws ReadWriteException
     */
    public static int insertShelf(Shelf shelfInfo) throws DuplicateRecordException, MissingFileException,
            CorruptedDataException, NotBoundException, UnknownException, ReadWriteException {
        Registry registry = RMIConnectionManager.getRegistry();
        ShelfDAO shelfDAO;
        try {
            shelfDAO = (ShelfDAO) registry.lookup(ShelfParams.FILENAME);
            if (shelfDAO.isShelfAvailable(shelfInfo)) {
                throw new DuplicateRecordException();
            }

            return shelfDAO.save(shelfInfo);
        } catch (RemoteException e) {
            Throwable ex = ExceptionUtils.dwrapRemoteException(e);
            if (ex instanceof JsonSyntaxException) {
                throw new CorruptedDataException(e);
            } else if (ex instanceof FileNotFoundException) {
                throw new MissingFileException(ShelfParams.FILENAME, e);
            } else if ((ex instanceof JsonIOException) || (ex instanceof IOException)) {
                throw new ReadWriteException(e);
            } else {
                throw new UnknownException(e);
            }
        }
    }

    /**
     *
     * @param shelfInfo
     * @return
     * @throws DuplicateRecordException
     * @throws MissingFileException
     * @throws CorruptedDataException
     * @throws NotBoundException
     * @throws UnknownException
     * @throws RecordNotFoundException
     * @throws ReadWriteException
     */
    public static int updateShelf(Shelf shelfInfo) throws DuplicateRecordException, MissingFileException,
            CorruptedDataException, NotBoundException, UnknownException, RecordNotFoundException, ReadWriteException {
        Registry registry = RMIConnectionManager.getRegistry();
        ShelfDAO shelfDAO;
        try {

            shelfDAO = (ShelfDAO) registry.lookup(ShelfParams.FILENAME);
            if (!shelfDAO.isShelfAvailable(shelfInfo)) {
                throw new RecordNotFoundException();
            }

            return shelfDAO.update(shelfInfo);
        } catch (RemoteException e) {
            Throwable ex = ExceptionUtils.dwrapRemoteException(e);
            if (ex instanceof JsonSyntaxException) {
                throw new CorruptedDataException(e);
            } else if (ex instanceof FileNotFoundException) {
                throw new MissingFileException(ShelfParams.FILENAME, e);
            } else if ((ex instanceof JsonIOException) || (ex instanceof IOException)) {
                throw new ReadWriteException(e);
            } else {
                throw new UnknownException(e);
            }
        }
    }

    /**
     *
     * @param shelfInfo
     * @return
     * @throws DuplicateRecordException
     * @throws MissingFileException
     * @throws CorruptedDataException
     * @throws NotBoundException
     * @throws UnknownException
     * @throws RecordNotFoundException
     * @throws ReadWriteException
     */
    public static int deleteShelf(Shelf shelfInfo) throws DuplicateRecordException, MissingFileException,
            CorruptedDataException, NotBoundException, UnknownException, RecordNotFoundException, ReadWriteException {
        Registry registry = RMIConnectionManager.getRegistry();
        ShelfDAO shelfDAO;
        try {
            shelfDAO = (ShelfDAO) registry.lookup(ShelfParams.FILENAME);
            if (!shelfDAO.isShelfAvailable(shelfInfo)) {
                throw new RecordNotFoundException();
            }

            return shelfDAO.remove(shelfInfo);
        } catch (RemoteException e) {
            Throwable ex = ExceptionUtils.dwrapRemoteException(e);
            if (ex instanceof JsonSyntaxException) {
                throw new CorruptedDataException(e);
            } else if (ex instanceof FileNotFoundException) {
                throw new MissingFileException(ShelfParams.FILENAME, e);
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
     * @throws DuplicateRecordException
     * @throws MissingFileException
     * @throws CorruptedDataException
     * @throws NotBoundException
     * @throws UnknownException
     * @throws ReadWriteException
     */
    public static Shelf getShelfById(int id) throws DuplicateRecordException, MissingFileException,
            CorruptedDataException, NotBoundException, UnknownException, ReadWriteException {
        Registry registry = RMIConnectionManager.getRegistry();
        ShelfDAO shelfDAO;
        try {

            shelfDAO = (ShelfDAO) registry.lookup(ShelfParams.FILENAME);

            return shelfDAO.findById(id);
        } catch (RemoteException e) {
            Throwable ex = ExceptionUtils.dwrapRemoteException(e);
            if (ex instanceof JsonSyntaxException) {
                throw new CorruptedDataException(e);
            } else if (ex instanceof FileNotFoundException) {
                throw new MissingFileException(ShelfParams.FILENAME, e);
            } else if ((ex instanceof JsonIOException) || (ex instanceof IOException)) {
                throw new ReadWriteException(e);
            } else {
                throw new UnknownException(e);
            }
        }
    }

    /**
     *
     * @return @throws DuplicateRecordException
     * @throws MissingFileException
     * @throws CorruptedDataException
     * @throws NotBoundException
     * @throws UnknownException
     * @throws ReadWriteException
     */
    public static List<Shelf> getAllShelf() throws DuplicateRecordException, MissingFileException,
            CorruptedDataException, NotBoundException, UnknownException, ReadWriteException {
        Registry registry = RMIConnectionManager.getRegistry();
        ShelfDAO shelfDAO;
        try {

            shelfDAO = (ShelfDAO) registry.lookup(ShelfParams.FILENAME);
            return shelfDAO.findAll();
        } catch (RemoteException e) {
            Throwable ex = ExceptionUtils.dwrapRemoteException(e);
            if (ex instanceof JsonSyntaxException) {
                throw new CorruptedDataException(e);
            } else if (ex instanceof FileNotFoundException) {
                throw new MissingFileException(ShelfParams.FILENAME, e);
            } else if ((ex instanceof JsonIOException) || (ex instanceof IOException)) {
                throw new ReadWriteException(e);
            } else {
                throw new UnknownException(e);
            }
        }
    }

    /**
     *
     * @param shelf
     * @return
     * @throws DuplicateRecordException
     * @throws MissingFileException
     * @throws CorruptedDataException
     * @throws NotBoundException
     * @throws UnknownException
     * @throws ReadWriteException
     */
    public static boolean isShelfAvailable(Shelf shelf) throws DuplicateRecordException, MissingFileException,
            CorruptedDataException, NotBoundException, UnknownException, ReadWriteException {
        return getShelfById(shelf.getId()) != null;
    }

}
