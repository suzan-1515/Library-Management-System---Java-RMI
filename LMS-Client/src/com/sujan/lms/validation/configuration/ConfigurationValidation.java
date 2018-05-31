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
package com.sujan.lms.validation.configuration;

import com.sujan.lms.common.util.Logy;
import com.sujan.lms.common.validation.BaseValidation;
import com.sujan.lms.common.widget.Alert;
import java.awt.Component;

/**
 *
 * @author Suzn
 */
public class ConfigurationValidation extends BaseValidation {

    public ConfigurationValidation(Component component) {
        super(component);
    }

    public boolean isConfigurationValid(String hostname, String port) {
        Logy.d("Validating configuration form");
        if (isStringEmptyOrNull(hostname)) {
            Logy.d("Configuration host address is not valid");
            Alert.showError(component, "Host address field cannot be empty.");
            return false;
        }

        if (isStringEmptyOrNull(port)) {
            Logy.d("Configuration port is not valid");
            Alert.showError(component, "Port field cannot be empty.");
            return false;
        } else if (port.trim().length() < 4 || port.trim().length() > 4) {
            Logy.d("Port not valid");
            Alert.showError(component, "Port must be of 4 digit");
            return false;
        }

        Logy.d("Configuration form is validated");

        return true;
    }

}
