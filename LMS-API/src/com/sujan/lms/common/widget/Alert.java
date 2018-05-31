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
package com.sujan.lms.common.widget;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Suzn
 */
public class Alert {

    public static void showInformation(Component component, String message) {
        JOptionPane.showMessageDialog(component, message, "Information?", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showError(Component component, String message) {
        JOptionPane.showMessageDialog(component, message, "Error?", JOptionPane.ERROR_MESSAGE);
    }

    public static int showDeleteConfirmDialog(Component component) {
        return JOptionPane.showConfirmDialog(component, "Are you sure you want to delete?", "Confirm?", JOptionPane.YES_NO_OPTION);
    }

}
