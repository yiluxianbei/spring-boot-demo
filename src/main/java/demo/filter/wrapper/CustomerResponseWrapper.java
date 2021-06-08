package demo.filter.wrapper;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * 包装Response,代替原来的HttpServletResponse，重写HttpServletResponse中的方法
 * 如果调用原来HttpServletResponse中的方法，会走此包装类中的方法
 */
public class CustomerResponseWrapper extends HttpServletResponseWrapper {
    public CustomerResponseWrapper(HttpServletResponse response) {
        super(response);
    }
}
