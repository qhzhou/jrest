package qhzhou.servlet;

import com.google.inject.servlet.ServletModule;

/**
 * Created by qianzhou on 5/2/15.
 */
public class JRestServletModule extends ServletModule {

    @Override
    protected void configureServlets() {
        serve("*").with(JRestServlet.class);
    }
}
