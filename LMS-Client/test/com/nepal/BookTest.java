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
package com.nepal;

import com.sujan.lms.bll.BookBLL;
import com.sujan.lms.common.entity.book.BookInfo;
import com.sujan.lms.common.util.Logy;
import com.sujan.lms.common.exception.CorruptedDataException;
import com.sujan.lms.common.exception.MissingFileException;
import com.sujan.lms.common.exception.ReadWriteException;
import com.sujan.lms.common.exception.RecordNotFoundException;
import com.sujan.lms.common.exception.UnknownException;
import java.rmi.NotBoundException;
import org.junit.Test;

/**
 *
 * @author Suzn
 */
public class BookTest {

    @Test
    public void onGetBookByIDTestCase() {
        try {
            BookInfo findById = BookBLL.getBookById(26353);
            Logy.d("Bookname: " + findById.getTitle());
        } catch (CorruptedDataException | MissingFileException | ReadWriteException
                | RecordNotFoundException | UnknownException | NotBoundException ex) {
        }
    }

}
