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
package com.sujan.lms.mail;

import com.sujan.lms.common.util.Logy;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Suzn
 */
public final class MailClient {

    private Properties props;
    private Session session;

    private final String username;
    private final String password;

    /**
     *
     * @param username
     * @param password
     */
    public MailClient(final String username, final String password) {
        this.username = username;
        this.password = password;
        this.init();
    }

    /**
     *
     */
    public MailClient() {
        String[] credintials = loadMailCredintials();
        this.username = credintials[0];
        this.password = credintials[1];
        this.init();
    }

    /**
     *
     */
    public void init() {
        //Setting up configurations for the email connection to the Google SMTP server using TLS
        props = new Properties();
        props.put("mail.smtp.host", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        //Establishing a session with required user details
        session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
    }

    /**
     *
     * @param recipient
     * @throws MessagingException
     * @throws UnsupportedEncodingException
     */
    public void sendMail(String recipient) throws MessagingException, UnsupportedEncodingException {

        //Creating a Message object to set the email content
        MimeMessage msg = new MimeMessage(session);
        //Storing the comma seperated values to email addresses
        /*Parsing the String with defualt delimiter as a comma by marking the boolean as true and storing the email
            addresses in an array of InternetAddress objects*/
        InternetAddress[] address = InternetAddress.parse(recipient, true);
        //Setting the recepients from the address variable
        msg.setRecipients(Message.RecipientType.TO, address);
        msg.setSubject("Registration Complete!");
        msg.setFrom(new InternetAddress(username, "Knowledgica Library!"));
        msg.setSentDate(new Date());
        msg.setText("Thank you for registering to Knowledgica Library. Please "
                + "login with your credientials to start using our system");
        msg.setHeader("XPriority", "1");
        Transport.send(msg);
        Logy.d("Mail hass been sent successfully");

    }

    private String[] loadMailCredintials() {
        Properties prop = new Properties();
        InputStream input = null;
        String[] credintials;

        try {

            input = new FileInputStream("mail_config.properties");

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            credintials = new String[2];
            credintials[0] = prop.getProperty("username");
            credintials[1] = prop.getProperty("password");

            return credintials;
        } catch (IOException ex) {
            Logy.e(ex);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    Logy.e(e);
                }
            }
        }

        return null;
    }

}
