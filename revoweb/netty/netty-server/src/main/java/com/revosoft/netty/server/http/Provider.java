package com.revosoft.netty.server.http;

import com.revosoft.netty.server.Values;
import com.revosoft.netty.server.http.routing.WebRouter;

import java.util.concurrent.Callable;



public class Provider implements Callable<Object> {

    private final String path;

    private final Values values;

    private final WebRouter router;

    public Provider(String path, Values values, WebRouter router) {
        this.path = path;
        this.values = values;
        this.router = router;
    }

    @Override
    public Object call() throws Exception {
        Object res = null;

        System.out.println("In Provider, call");
        res = router.routeRequest(path, values);

        return res;
        // throw new RuntimeException("Hello, Exception!");
    }
}
