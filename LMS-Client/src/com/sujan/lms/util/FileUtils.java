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
package com.sujan.lms.util;

import com.sujan.lms.common.params.FileParams;
import com.sujan.lms.rmi.RMIConnectionManager;
import com.sujan.lms.common.file.FileManager;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author Suzn
 */
public class FileUtils {

    public static boolean exists(final String filename) throws RemoteException, NotBoundException {
        FileManager fileManager = (FileManager) RMIConnectionManager.getRegistry().lookup(FileParams.BIND_NAME);
        return fileManager.exist(filename);
    }

    public static boolean notExist(final String filename) throws RemoteException, NotBoundException {
        FileManager fileManager = (FileManager) RMIConnectionManager.getRegistry().lookup(FileParams.BIND_NAME);
        return fileManager.notExist(filename);
    }

}
