package qhzhou.servlet;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

import javax.servlet.annotation.WebListener;

/**
 * Created by qianzhou on 5/2/15.
 */
@WebListener
public class JRestConfig extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new JRestServletModule());
    }
}
