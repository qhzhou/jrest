package qhzhou.controller;

import java.util.List;

/**
 * Created by qianzhou on 5/2/15.
 */
public abstract class BaseController<T> {

    public abstract void post(T data);

    public abstract void post(String id, T data);

    public abstract void put(String id, T data);

    public abstract void delete(String id);

    public abstract T get(String id);
    
    public abstract List<String> options();
}
