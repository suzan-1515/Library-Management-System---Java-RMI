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
import com.sujan.lms.common.dao.TransactionDAO;
import com.sujan.lms.common.exception.UnknownException;
import com.sujan.lms.common.entity.transaction.Transaction;
import com.sujan.lms.common.exception.CorruptedDataException;
import com.sujan.lms.common.exception.DuplicateRecordException;
import com.sujan.lms.common.exception.MissingFileException;
import com.sujan.lms.common.exception.ReadWriteException;
import com.sujan.lms.common.exception.RecordNotFoundException;
import com.sujan.lms.common.params.TransactionParams;
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
 * @transaction Suzn
 */
public class TransactionBLL {

    /**
     *
     * @param transactionInfo
     * @return
     * @throws DuplicateRecordException
     * @throws MissingFileException
     * @throws CorruptedDataException
     * @throws NotBoundException
     * @throws UnknownException
     * @throws ReadWriteException
     */
    public static int insertTransaction(Transaction transactionInfo) throws DuplicateRecordException,
            MissingFileException, CorruptedDataException, NotBoundException, UnknownException, ReadWriteException {
        Registry registry = RMIConnectionManager.getRegistry();
        TransactionDAO transactionDAO;
        try {
            transactionDAO = (TransactionDAO) registry.lookup(TransactionParams.FILENAME);
            if (transactionDAO.isTransactionAvailable(transactionInfo)) {
                throw new DuplicateRecordException();
            }

            return transactionDAO.save(transactionInfo);
        } catch (RemoteException e) {
            Throwable ex = ExceptionUtils.dwrapRemoteException(e);
            if (ex instanceof JsonSyntaxException) {
                throw new CorruptedDataException(e);
            } else if (ex instanceof FileNotFoundException) {
                throw new MissingFileException(TransactionParams.FILENAME, e);
            } else if ((ex instanceof JsonIOException) || (ex instanceof IOException)) {
                throw new ReadWriteException(e);
            } else {
                throw new UnknownException(e);
            }
        }
    }

    /**
     *
     * @param transactionInfo
     * @return
     * @throws DuplicateRecordException
     * @throws MissingFileException
     * @throws CorruptedDataException
     * @throws NotBoundException
     * @throws UnknownException
     * @throws RecordNotFoundException
     * @throws ReadWriteException
     */
    public static int updateTransaction(Transaction transactionInfo) throws DuplicateRecordException, MissingFileException,
            CorruptedDataException, NotBoundException, UnknownException, RecordNotFoundException, ReadWriteException {
        Registry registry = RMIConnectionManager.getRegistry();
        TransactionDAO transactionDAO;
        try {

            transactionDAO = (TransactionDAO) registry.lookup(TransactionParams.FILENAME);
            if (!transactionDAO.isTransactionAvailable(transactionInfo)) {
                throw new RecordNotFoundException();
            }

            return transactionDAO.update(transactionInfo);
        } catch (RemoteException e) {
            Throwable ex = ExceptionUtils.dwrapRemoteException(e);
            if (ex instanceof JsonSyntaxException) {
                throw new CorruptedDataException(e);
            } else if (ex instanceof FileNotFoundException) {
                throw new MissingFileException(TransactionParams.FILENAME, e);
            } else if ((ex instanceof JsonIOException) || (ex instanceof IOException)) {
                throw new ReadWriteException(e);
            } else {
                throw new UnknownException(e);
            }
        }
    }

    /**
     *
     * @param transactionInfo
     * @return
     * @throws DuplicateRecordException
     * @throws MissingFileException
     * @throws CorruptedDataException
     * @throws NotBoundException
     * @throws UnknownException
     * @throws RecordNotFoundException
     * @throws ReadWriteException
     */
    public static int deleteTransaction(Transaction transactionInfo) throws DuplicateRecordException, MissingFileException,
            CorruptedDataException, NotBoundException, UnknownException, RecordNotFoundException, ReadWriteException {
        Registry registry = RMIConnectionManager.getRegistry();
        TransactionDAO transactionDAO;
        try {
            transactionDAO = (TransactionDAO) registry.lookup(TransactionParams.FILENAME);
            if (!transactionDAO.isTransactionAvailable(transactionInfo)) {
                throw new RecordNotFoundException();
            }

            return transactionDAO.remove(transactionInfo);
        } catch (RemoteException e) {
            Throwable ex = ExceptionUtils.dwrapRemoteException(e);
            if (ex instanceof JsonSyntaxException) {
                throw new CorruptedDataException(e);
            } else if (ex instanceof FileNotFoundException) {
                throw new MissingFileException(TransactionParams.FILENAME, e);
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
    public static Transaction getTransactionById(int id) throws DuplicateRecordException, MissingFileException,
            CorruptedDataException, NotBoundException, UnknownException, ReadWriteException {
        Registry registry = RMIConnectionManager.getRegistry();
        TransactionDAO transactionDAO;
        try {

            transactionDAO = (TransactionDAO) registry.lookup(TransactionParams.FILENAME);

            return transactionDAO.findById(id);
        } catch (RemoteException e) {
            Throwable ex = ExceptionUtils.dwrapRemoteException(e);
            if (ex instanceof JsonSyntaxException) {
                throw new CorruptedDataException(e);
            } else if (ex instanceof FileNotFoundException) {
                throw new MissingFileException(TransactionParams.FILENAME, e);
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
    public static List<Transaction> getAllTransaction() throws DuplicateRecordException, MissingFileException,
            CorruptedDataException, NotBoundException, UnknownException, ReadWriteException {
        Registry registry = RMIConnectionManager.getRegistry();
        TransactionDAO transactionDAO;
        try {

            transactionDAO = (TransactionDAO) registry.lookup(TransactionParams.FILENAME);
            return transactionDAO.findAll();
        } catch (RemoteException e) {
            Throwable ex = ExceptionUtils.dwrapRemoteException(e);
            if (ex instanceof JsonSyntaxException) {
                throw new CorruptedDataException(e);
            } else if (ex instanceof FileNotFoundException) {
                throw new MissingFileException(TransactionParams.FILENAME, e);
            } else if ((ex instanceof JsonIOException) || (ex instanceof IOException)) {
                throw new ReadWriteException(e);
            } else {
                throw new UnknownException(e);
            }
        }
    }

    /**
     *
     * @param transaction
     * @return
     * @throws DuplicateRecordException
     * @throws MissingFileException
     * @throws CorruptedDataException
     * @throws NotBoundException
     * @throws UnknownException
     * @throws ReadWriteException
     */
    public static boolean isTransactionAvailable(Transaction transaction) throws DuplicateRecordException, MissingFileException,
            CorruptedDataException, NotBoundException, UnknownException, ReadWriteException {
        return getTransactionById(transaction.getId()) != null;
    }

}
