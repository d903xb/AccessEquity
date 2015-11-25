package com.revosoft.netty.server.http.routing;


import org.codehaus.jackson.JsonParseException;

import java.io.IOException;

public interface WebRouter {

	 Object routeRequest(String path, String valueJson) throws IOException;
	 String toString();
}
