/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.lms.util;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Suzn
 */
public class Logy {

    public static final String TAG = "LMS";

    public static void d(String message) {
        System.out.println("Log Message: "+message);
    }

    public static void e(Throwable t) {
        Logger.getLogger(TAG).log(Level.SEVERE, null, t);
    }

}
