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

import com.sujan.lms.common.util.Logy;
import java.awt.Component;
import javax.swing.JPanel;

/**
 *
 * @author Suzn
 */
public class ComponentUtils {

    public static void addToPanel(JPanel root, JPanel child) {
        for (Component component : root.getComponents()) {
            if (component.equals(child)) {
                Logy.d("panel already attacted");
                return;
            }
        }

        Logy.d("Attaching panel");
        root.removeAll();
        root.add(child);
        root.revalidate();
        root.repaint();
    }

}
