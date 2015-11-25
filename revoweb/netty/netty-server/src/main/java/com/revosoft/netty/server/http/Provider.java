package com.revosoft.netty.server.http;

import com.revosoft.netty.server.Values;
import com.revosoft.netty.server.http.routing.WebRouter;

import java.util.concurrent.Callable;



public class Provider implements Callable<Object> {

    private final String path;

    private final String valueJson;

    private final WebRouter router;

    public Provider(String path, String valueJson, WebRouter router) {
        this.path = path;
        this.valueJson = valueJson;
        this.router = router;
    }

    @Override
    public Object call() throws Exception {
        Object res = null;

        res = router.routeRequest(path, valueJson);

        return res;
        // throw new RuntimeException("Hello, Exception!");
    }
}
