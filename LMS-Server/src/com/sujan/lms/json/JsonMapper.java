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
package com.sujan.lms.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 *
 * @author Suzn
 */
public class JsonMapper {

    private final Gson gson;

    private JsonMapper() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public synchronized static JsonMapper getInstance() {
        return GsonHolder.INSTANCE;
    }

    private static class GsonHolder {

        private static final JsonMapper INSTANCE = new JsonMapper();
    }

    /**
     * @return the gson
     */
    public Gson getGson() {
        return gson;
    }
}
