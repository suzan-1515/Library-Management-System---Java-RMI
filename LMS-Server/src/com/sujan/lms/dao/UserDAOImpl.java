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
package com.sujan.lms.dao;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.sujan.lms.common.dao.UserDAO;
import com.sujan.lms.common.entity.user.User;
import com.sujan.lms.common.entity.user.UserInfo;
import com.sujan.lms.common.params.UserParams;
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
public class UserDAOImpl extends UnicastRemoteObject implements UserDAO {

    private final String filename;
    private final Gson gson;

    /**
     *
     * @param gson
     * @param filename
     * @throws java.rmi.RemoteException
     */
    public UserDAOImpl(Gson gson, String filename) throws RemoteException {
        this.gson = gson;
        this.filename = filename;
    }

    /**
     *
     * @param user
     * @return boolean
     * @throws java.rmi.RemoteException
     * @throws JsonIOException
     * @throws JsonSyntaxException
     */
    @Override
    public synchronized boolean isUserAvailable(User user) throws RemoteException {
        try {
            return findById(user.getId()) != null;
        } catch (IOException | JsonIOException | JsonSyntaxException ex) {
            throw new RemoteException(null, ex);
        }
    }

    /**
     *
     * @param t
     * @return Integer
     * @throws java.rmi.RemoteException
     * @throws JsonIOException
     * @throws JsonSyntaxException
     */
    @Override
    public synchronized int save(UserInfo t) throws RemoteException {

        try {
            if (FileUtils.exists(filename)) {
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
     * @throws java.rmi.RemoteException
     * @throws JsonIOException
     * @throws JsonSyntaxException
     */
    @Override
    public synchronized int append(UserInfo t) throws RemoteException {

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
     * @throws java.rmi.RemoteException
     * @throws JsonIOException
     * @throws JsonSyntaxException
     */
    @Override
    public synchronized int update(UserInfo t) throws RemoteException {

        try (Reader reader = new FileReader(filename)) {
            JsonArray rootArray = gson.fromJson(reader, JsonArray.class
            );
            Iterator<JsonElement> iterator = rootArray.iterator();
            boolean found = false;
            while (iterator.hasNext()) {
                JsonObject item = iterator.next().getAsJsonObject();
                if (item.get(UserParams.ID).getAsInt() == t.getId()) {

                    item.addProperty(UserParams.NAME, t.getName());
                    item.addProperty(UserParams.USERNAME, t.getUsername());
                    item.addProperty(UserParams.PASSWORD, t.getPassword());
                    item.add(UserParams.ROLE, gson.toJsonTree(t.getRole()));

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
     * @throws java.rmi.RemoteException
     * @throws JsonIOException
     * @throws JsonSyntaxException
     */
    @Override
    public synchronized int remove(UserInfo t) throws RemoteException {

        try (Reader reader = new FileReader(filename)) {
            JsonArray rootArray = gson.fromJson(reader, JsonArray.class
            );
            Iterator<JsonElement> iterator = rootArray.iterator();
            boolean found = false;
            while (iterator.hasNext()) {
                JsonObject item = iterator.next().getAsJsonObject();
                if (item.get(UserParams.ID).getAsInt() == t.getId()) {
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
     * @return UserInfo
     * @throws java.rmi.RemoteException
     * @throws JsonIOException
     * @throws JsonSyntaxException
     */
    @Override
    public synchronized UserInfo findById(int id) throws RemoteException {

        try (Reader reader = new FileReader(filename)) {
            JsonArray rootArray = gson.fromJson(reader, JsonArray.class
            );
            Iterator<JsonElement> iterator = rootArray.iterator();
            while (iterator.hasNext()) {
                JsonObject item = iterator.next().getAsJsonObject();

                if (item.get(UserParams.ID).getAsInt() == id) {
                    return gson.fromJson(item, UserInfo.class
                    );
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
     * @return @throws java.rmi.RemoteException @throws IOException
     * @throws JsonIOException
     * @throws JsonSyntaxException
     */
    @Override
    public synchronized List<UserInfo> findAll() throws RemoteException {
        try (Reader reader = new FileReader(filename)) {
            return gson.fromJson(reader, new TypeToken<List<UserInfo>>() {
            }.getType());
        } catch (FileNotFoundException ex) {
            throw new RemoteException(null, ex);
        } catch (IOException | JsonIOException | JsonSyntaxException ex) {
            throw new RemoteException(null, ex);
        }
    }

    /**
     *
     * @param user
     * @return UserInfo
     * @throws java.rmi.RemoteException
     * @throws JsonIOException
     * @throws JsonSyntaxException
     */
    @Override
    public synchronized UserInfo loginUser(User user) throws RemoteException {
        try (Reader reader = new FileReader(filename)) {
            JsonArray rootArray = gson.fromJson(reader, JsonArray.class
            );
            Iterator<JsonElement> iterator = rootArray.iterator();
            while (iterator.hasNext()) {
                JsonObject item = iterator.next().getAsJsonObject();

                if (item.get(UserParams.USERNAME).getAsString().equals(user.getUsername())
                        && item.get(UserParams.PASSWORD).getAsString().equals(user.getPassword())) {
                    return gson.fromJson(item, UserInfo.class
                    );
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
     * @param username
     * @return
     * @throws RemoteException
     */
    @Override
    public synchronized boolean isUsernameAlreadyUsed(String username) throws RemoteException {
        try (Reader reader = new FileReader(filename)) {
            JsonArray rootArray = gson.fromJson(reader, JsonArray.class
            );
            Iterator<JsonElement> iterator = rootArray.iterator();
            while (iterator.hasNext()) {
                JsonObject item = iterator.next().getAsJsonObject();

                if (item.get(UserParams.USERNAME).getAsString().equals(username.trim())) {
                    return true;
                }
            }
        } catch (FileNotFoundException ex) {
            throw new RemoteException(null, ex);
        } catch (IOException | JsonIOException | JsonSyntaxException ex) {
            throw new RemoteException(null, ex);
        }

        return false;
    }

}
