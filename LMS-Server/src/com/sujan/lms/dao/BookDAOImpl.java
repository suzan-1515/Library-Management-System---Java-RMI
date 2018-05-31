/**
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
package com.sujan.lms.dao;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.sujan.lms.common.dao.BookDAO;
import com.sujan.lms.common.entity.book.Book;
import com.sujan.lms.common.entity.book.BookInfo;
import com.sujan.lms.common.params.BookParams;
import com.sujan.lms.common.util.Logy;
import com.sujan.lms.util.FileUtils;
import com.sujan.lms.util.JsonHelper;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Suzn
 */
public class BookDAOImpl extends UnicastRemoteObject implements BookDAO {

    private final String filename;
    private final Gson gson;

    /**
     *
     * @param gson
     * @param filename
     * @throws java.rmi.RemoteException
     */
    public BookDAOImpl(Gson gson, String filename) throws RemoteException {
        super();
        this.gson = gson;
        this.filename = filename;
    }

    /**
     *
     * @param book
     * @return boolean
     * @throws JsonIOException
     * @throws JsonSyntaxException
     * @throws java.rmi.RemoteException
     */
    @Override
    public synchronized boolean isBookAvailable(Book book) throws RemoteException {
        try {
            return findById(book.getId()) != null;
        } catch (IOException | JsonIOException | JsonSyntaxException ex) {
            throw new RemoteException(null, ex);
        }
    }

    /**
     *
     * @param t
     * @return Integer
     * @throws JsonIOException
     * @throws JsonSyntaxException
     * @throws java.rmi.RemoteException
     */
    @Override
    public synchronized int save(BookInfo t) throws RemoteException {

        try {
            if (FileUtils.exists(filename)) {
                Logy.d("Appending file");
                append(t);
            } else {
                JsonHelper.writeToFile(Arrays.asList(t), filename, gson);
            }
        } catch (FileNotFoundException ex) {
            throw new RemoteException(null, ex);
        } catch (IOException | JsonIOException | JsonSyntaxException ex) {
            throw new RemoteException(null, ex);
        }

        return t.getId();
    }

    /**
     *
     * @param t
     * @return Integer
     * @throws JsonIOException
     * @throws JsonSyntaxException
     * @throws java.rmi.RemoteException
     */
    @Override
    public synchronized int append(BookInfo t) throws RemoteException {
        try (Reader reader = new FileReader(filename)) {
            JsonArray rootArray = gson.fromJson(reader, JsonArray.class);
            JsonObject newData = new JsonParser().parse(gson.toJson(t)).getAsJsonObject();

            rootArray.add(newData);

            JsonHelper.writeToFile(rootArray, filename, gson);

        } catch (FileNotFoundException ex) {
            throw new RemoteException(null, ex);
        } catch (IOException | JsonIOException | JsonSyntaxException ex) {
            throw new RemoteException(null, ex);
        }

        return t.getId();
    }

    /**
     *
     * @param t
     * @return Integer
     * @throws JsonIOException
     * @throws JsonSyntaxException
     * @throws java.rmi.RemoteException
     */
    @Override
    public synchronized int update(BookInfo t) throws RemoteException {

        try (Reader reader = new FileReader(filename)) {
            JsonArray rootArray = gson.fromJson(reader, JsonArray.class);
            Iterator<JsonElement> iterator = rootArray.iterator();
            boolean found = false;
            while (iterator.hasNext()) {
                JsonObject item = iterator.next().getAsJsonObject();
                if (item.get(BookParams.ID).getAsInt() == t.getId()) {

                    item.addProperty(BookParams.AVAILABLE_COPIES, t.getAvailableCopies());
                    item.addProperty(BookParams.TITLE, t.getTitle());
                    item.add(BookParams.SUBJECT, gson.toJsonTree(t.getSubject()));
                    item.add(BookParams.AUTHOR, gson.toJsonTree(t.getAuthor()));
                    item.add(BookParams.PUBLISHER, gson.toJsonTree(t.getPublisher()));
                    item.addProperty(BookParams.EDITION, t.getEdition());
                    item.addProperty(BookParams.ISBN, t.getIsbn());
                    item.add(BookParams.SHELF_NO, gson.toJsonTree(t.getShelfNo()));
                    item.addProperty(BookParams.NUMBER_OF_COPY, t.getNumberOfCopy());

                    found = true;
                    break;
                }
            }
            if (found) {
                JsonHelper.writeToFile(rootArray, filename, gson);
                return t.getId();
            }

        } catch (FileNotFoundException ex) {
            throw new RemoteException(null, ex);
        } catch (IOException | JsonIOException | JsonSyntaxException ex) {
            throw new RemoteException(null, ex);
        }

        return -1;
    }

    /**
     *
     * @param t
     * @return Integer
     * @throws JsonIOException
     * @throws JsonSyntaxException
     * @throws java.rmi.RemoteException
     */
    @Override
    public synchronized int remove(BookInfo t) throws RemoteException {

        try (Reader reader = new FileReader(filename)) {
            JsonArray rootArray = gson.fromJson(reader, JsonArray.class);
            Iterator<JsonElement> iterator = rootArray.iterator();
            boolean found = false;
            while (iterator.hasNext()) {
                JsonObject item = iterator.next().getAsJsonObject();
                if (item.get(BookParams.ID).getAsInt() == t.getId()) {
                    rootArray.remove(item);
                    found = true;
                    break;
                }
            }
            if (found) {
                JsonHelper.writeToFile(rootArray, filename, gson);
                return t.getId();
            }

        } catch (FileNotFoundException ex) {
            throw new RemoteException(null, ex);
        } catch (IOException | JsonIOException | JsonSyntaxException ex) {
            throw new RemoteException(null, ex);
        }

        return -1;
    }

    /**
     *
     * @param id
     * @return BoookInfo
     * @throws JsonIOException
     * @throws JsonSyntaxException
     * @throws java.rmi.RemoteException
     */
    @Override
    public synchronized BookInfo findById(int id) throws RemoteException {

        try (Reader reader = new FileReader(filename)) {
            JsonArray rootArray = gson.fromJson(reader, JsonArray.class);
            Iterator<JsonElement> iterator = rootArray.iterator();
            while (iterator.hasNext()) {
                JsonObject item = iterator.next().getAsJsonObject();
                if (item.get(BookParams.ID).getAsInt() == id) {
                    return gson.fromJson(item, BookInfo.class);
                }
            }
        } catch (FileNotFoundException ex) {
            throw new RemoteException(null, ex);
        } catch (IOException | JsonIOException | JsonSyntaxException ex) {
            throw new RemoteException(null, ex);
        }

        return null;
    }

    /**
     *
     * @return @throws JsonIOException
     * @throws JsonSyntaxException
     * @throws java.rmi.RemoteException
     */
    @Override
    public synchronized List<BookInfo> findAll() throws RemoteException {
        try (Reader reader = new FileReader(filename)) {
            return gson.fromJson(reader, new TypeToken<List<BookInfo>>() {
            }.getType());
        } catch (FileNotFoundException ex) {
            throw new RemoteException(null, ex);
        } catch (IOException | JsonIOException | JsonSyntaxException ex) {
            throw new RemoteException(null, ex);
        }

    }

}
