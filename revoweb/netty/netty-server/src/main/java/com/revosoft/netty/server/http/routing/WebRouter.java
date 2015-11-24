package com.revosoft.netty.server.http.routing;


import com.revosoft.netty.server.Values;

public interface WebRouter {

	 Object routeRequest(String path, Values values);
	String toString();
}
