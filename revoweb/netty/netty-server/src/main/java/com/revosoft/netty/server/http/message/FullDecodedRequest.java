package com.revosoft.netty.server.http.message;

import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.QueryStringDecoder;
import com.revosoft.netty.server.Values;
import io.netty.handler.codec.http.multipart.Attribute;
import io.netty.handler.codec.http.multipart.DefaultHttpDataFactory;
import io.netty.handler.codec.http.multipart.HttpPostRequestDecoder;
import io.netty.handler.codec.http.multipart.InterfaceHttpData;
import io.netty.util.CharsetUtil;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;

import java.io.IOException;

public class FullDecodedRequest {

	private final Request request;
	private final Values values;

	public FullDecodedRequest(Request request, Values values) {
		this.request = request;
		this.values = values;
	}

	public Request getRequest() {
		return request;
	}

	public String getValueJson() throws IOException {
		FullHttpRequest req = (FullHttpRequest) request.getHttpRequest();
		return req.content().toString(CharsetUtil.UTF_8);
	}
	
	public String getPath() {
		QueryStringDecoder queryStringDecoder = new QueryStringDecoder(
				request.getHttpRequest().getUri());
		return queryStringDecoder.path();
	}


}
