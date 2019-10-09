package com.b3c2bab2.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.springframework.util.StreamUtils.copyToString;

/**
 * @author b3c2bab2
 * created on 2019/10/9
 */
public class SimpleZuulFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        try {
            RequestContext context = RequestContext.getCurrentContext();
            InputStream stream = context.getResponseDataStream();
            String body = copyToString(stream, StandardCharsets.UTF_8);
            context.setResponseBody("Called by zuul: " + body);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ZuulException(e, 500, e.getMessage());
        }
        return null;
    }
}
