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
package com.sujan.lms.common.dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Suzn
 * @param <T>
 */
public interface DAO<T> extends Remote {

    int save(T t) throws RemoteException;

    int append(T t) throws RemoteException;

    int update(T t) throws RemoteException;

    int remove(T t) throws RemoteException;

    T findById(int id) throws RemoteException;

    List<T> findAll() throws RemoteException;
}
