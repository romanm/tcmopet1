/*
 * Copyright 2002-2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.tasclin1.mopet1.amqp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * POJO handler that receives market data and trade responses. Calls are
 * delegated to the UI controller.
 * 
 * @author Mark Pollack
 * @author Mark Fisher
 */
public class ClientHandler {

	private static Log log = LogFactory.getLog(ClientHandler.class);

	public void handleMessage(MtlDocResponce rs) {
		log.debug("Receive Response:" + rs.toString());
	}

}
