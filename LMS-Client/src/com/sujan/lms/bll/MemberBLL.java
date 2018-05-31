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
import com.sujan.lms.common.dao.MemberDAO;
import com.sujan.lms.common.exception.UnknownException;
import com.sujan.lms.common.entity.member.Member;
import com.sujan.lms.common.entity.member.MemberInfo;
import com.sujan.lms.common.exception.CorruptedDataException;
import com.sujan.lms.common.exception.DuplicateRecordException;
import com.sujan.lms.common.exception.MissingFileException;
import com.sujan.lms.common.exception.ReadWriteException;
import com.sujan.lms.common.exception.RecordNotFoundException;
import com.sujan.lms.common.params.MemberParams;
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
 * @author Suzn
 */
public class MemberBLL {

    /**
     *
     * @param memberInfo
     * @return
     * @throws DuplicateRecordException
     * @throws MissingFileException
     * @throws CorruptedDataException
     * @throws NotBoundException
     * @throws UnknownException
     * @throws ReadWriteException
     */
    public static int insertMember(MemberInfo memberInfo) throws DuplicateRecordException, MissingFileException,
            CorruptedDataException, NotBoundException, UnknownException, ReadWriteException {
        Registry registry = RMIConnectionManager.getRegistry();
        MemberDAO memberDAO;
        try {
            memberDAO = (MemberDAO) registry.lookup(MemberParams.FILENAME);
            if (memberDAO.isMemberAvailable(memberInfo)) {
                throw new DuplicateRecordException();
            }

            return memberDAO.save(memberInfo);
        } catch (RemoteException e) {
            Throwable ex = ExceptionUtils.dwrapRemoteException(e);
            if (ex instanceof JsonSyntaxException) {
                throw new CorruptedDataException(e);
            } else if (ex instanceof FileNotFoundException) {
                throw new MissingFileException(MemberParams.FILENAME, e);
            } else if ((ex instanceof JsonIOException) || (ex instanceof IOException)) {
                throw new ReadWriteException(e);
            } else {
                throw new UnknownException(e);
            }
        }
    }

    /**
     *
     * @param memberInfo
     * @return
     * @throws DuplicateRecordException
     * @throws MissingFileException
     * @throws CorruptedDataException
     * @throws NotBoundException
     * @throws UnknownException
     * @throws RecordNotFoundException
     * @throws ReadWriteException
     */
    public static int updateMember(MemberInfo memberInfo) throws DuplicateRecordException, MissingFileException,
            CorruptedDataException, NotBoundException, UnknownException, RecordNotFoundException, ReadWriteException {
        Registry registry = RMIConnectionManager.getRegistry();
        MemberDAO memberDAO;
        try {

            memberDAO = (MemberDAO) registry.lookup(MemberParams.FILENAME);
            if (!memberDAO.isMemberAvailable(memberInfo)) {
                throw new RecordNotFoundException();
            }

            return memberDAO.update(memberInfo);
        } catch (RemoteException e) {
            Throwable ex = ExceptionUtils.dwrapRemoteException(e);
            if (ex instanceof JsonSyntaxException) {
                throw new CorruptedDataException(e);
            } else if (ex instanceof FileNotFoundException) {
                throw new MissingFileException(MemberParams.FILENAME, e);
            } else if ((ex instanceof JsonIOException) || (ex instanceof IOException)) {
                throw new ReadWriteException(e);
            } else {
                throw new UnknownException(e);
            }
        }
    }

    /**
     *
     * @param memberInfo
     * @return
     * @throws DuplicateRecordException
     * @throws MissingFileException
     * @throws CorruptedDataException
     * @throws NotBoundException
     * @throws UnknownException
     * @throws RecordNotFoundException
     * @throws ReadWriteException
     */
    public static int deleteMember(MemberInfo memberInfo) throws DuplicateRecordException, MissingFileException,
            CorruptedDataException, NotBoundException, UnknownException, RecordNotFoundException, ReadWriteException {
        Registry registry = RMIConnectionManager.getRegistry();
        MemberDAO memberDAO;
        try {
            memberDAO = (MemberDAO) registry.lookup(MemberParams.FILENAME);
            if (!memberDAO.isMemberAvailable(memberInfo)) {
                throw new RecordNotFoundException();
            }

            return memberDAO.remove(memberInfo);
        } catch (RemoteException e) {
            Throwable ex = ExceptionUtils.dwrapRemoteException(e);
            if (ex instanceof JsonSyntaxException) {
                throw new CorruptedDataException(e);
            } else if (ex instanceof FileNotFoundException) {
                throw new MissingFileException(MemberParams.FILENAME, e);
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
    public static MemberInfo getMemberById(int id) throws DuplicateRecordException, MissingFileException,
            CorruptedDataException, NotBoundException, UnknownException, ReadWriteException {
        Registry registry = RMIConnectionManager.getRegistry();
        MemberDAO memberDAO;
        try {

            memberDAO = (MemberDAO) registry.lookup(MemberParams.FILENAME);

            return memberDAO.findById(id);
        } catch (RemoteException e) {
            Throwable ex = ExceptionUtils.dwrapRemoteException(e);
            if (ex instanceof JsonSyntaxException) {
                throw new CorruptedDataException(e);
            } else if (ex instanceof FileNotFoundException) {
                throw new MissingFileException(MemberParams.FILENAME, e);
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
    public static List<MemberInfo> getAllMember() throws DuplicateRecordException, MissingFileException,
            CorruptedDataException, NotBoundException, UnknownException, ReadWriteException {
        Registry registry = RMIConnectionManager.getRegistry();
        MemberDAO memberDAO;
        try {

            memberDAO = (MemberDAO) registry.lookup(MemberParams.FILENAME);
            return memberDAO.findAll();
        } catch (RemoteException e) {
            Throwable ex = ExceptionUtils.dwrapRemoteException(e);
            if (ex instanceof JsonSyntaxException) {
                throw new CorruptedDataException(e);
            } else if (ex instanceof FileNotFoundException) {
                throw new MissingFileException(MemberParams.FILENAME, e);
            } else if ((ex instanceof JsonIOException) || (ex instanceof IOException)) {
                throw new ReadWriteException(e);
            } else {
                throw new UnknownException(e);
            }
        }
    }

    /**
     *
     * @param member
     * @return
     * @throws DuplicateRecordException
     * @throws MissingFileException
     * @throws CorruptedDataException
     * @throws NotBoundException
     * @throws UnknownException
     * @throws ReadWriteException
     */
    public static boolean isMemberAvailable(Member member) throws DuplicateRecordException, MissingFileException,
            CorruptedDataException, NotBoundException, UnknownException, ReadWriteException {
        return getMemberById(member.getId()) != null;
    }

}
