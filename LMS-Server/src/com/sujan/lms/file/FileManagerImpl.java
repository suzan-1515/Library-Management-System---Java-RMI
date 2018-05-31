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
package com.sujan.lms.file;

import com.sujan.lms.common.file.FileManager;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Suzn
 */
public class FileManagerImpl extends UnicastRemoteObject implements FileManager {

    public FileManagerImpl() throws RemoteException {
        super();
    }

    @Override
    public synchronized boolean exist(String filename) throws RemoteException {
        return Files.exists(Paths.get(filename));
    }

    @Override
    public synchronized boolean notExist(String filename) throws RemoteException {
        return Files.notExists(Paths.get(filename));
    }

}
