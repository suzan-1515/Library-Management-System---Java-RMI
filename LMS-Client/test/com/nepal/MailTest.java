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

import com.sujan.lms.mail.MailClient;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import org.junit.Test;

/**
 *
 * @author Suzn
 */
public class MailTest {

    @Test
    public void mailSendTestCase() {
        MailClient mailClient = new MailClient("smartbahun2@gmail.com", "");
        mailClient.sendMail("suzanparajuli@gmail.com");
    }

    @Test
    public void createPropertiesFileForMailCredintialsTestCase() {
        Properties prop = new Properties();
        OutputStream output = null;

        try {

            output = new FileOutputStream("mail_config.properties");

            // set the properties value
            prop.setProperty("username", "");
            prop.setProperty("password", "");

            // save properties to project root folder
            prop.store(output, null);

        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
   

}
