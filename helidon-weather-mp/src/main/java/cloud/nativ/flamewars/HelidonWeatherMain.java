/*
 * Copyright (c) 2018, 2020 Oracle and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cloud.nativ.flamewars;

import io.helidon.microprofile.server.Server;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public final class HelidonWeatherMain {

    public static void main(final String[] args) throws IOException {
        try (InputStream is = HelidonWeatherMain.class.getResourceAsStream("/logging.properties")) {
            LogManager.getLogManager().readConfiguration(is);
        }

        Server server = Server.create().start();

        Logger logger = Logger.getLogger(HelidonWeatherMain.class.getName());
        logger.log(Level.INFO, "Weather API at http://{0}:{1}/api/weather", new Object[]{server.host(), server.port()});
    }

}
