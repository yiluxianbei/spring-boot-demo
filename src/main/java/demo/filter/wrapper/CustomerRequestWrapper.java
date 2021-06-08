package demo.filter.wrapper;

import javax.servlet.http.*;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Map;

/**
 * 包装request,代替原来的HttpServletRequest，重写HttpServletRequest中的方法
 * 如果调用原来HttpServletRequest中的方法，会走此包装类中的方法
 * 需放到filter中的filterChain中使用
 */
public class CustomerRequestWrapper extends HttpServletRequestWrapper {

    public CustomerRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public Cookie[] getCookies() {
        return super.getCookies();
    }

    @Override
    public String getHeader(String name) {
        return super.getHeader(name);
    }

    @Override
    public Enumeration<String> getHeaders(String name) {
        return super.getHeaders(name);
    }

    @Override
    public Enumeration<String> getHeaderNames() {
        return super.getHeaderNames();
    }

    @Override
    public HttpServletMapping getHttpServletMapping() {
        return super.getHttpServletMapping();
    }

    @Override
    public String getMethod() {
        return super.getMethod();
    }

    @Override
    public String getContextPath() {
        return super.getContextPath();
    }

    @Override
    public HttpSession getSession(boolean create) {
        return super.getSession(create);
    }

    @Override
    public HttpSession getSession() {
        return super.getSession();
    }

    @Override
    public String changeSessionId() {
        return super.changeSessionId();
    }

    @Override
    public Object getAttribute(String name) {
        return super.getAttribute(name);
    }

    @Override
    public Enumeration<String> getAttributeNames() {
        return super.getAttributeNames();
    }

    @Override
    public String getCharacterEncoding() {
        return super.getCharacterEncoding();
    }

    @Override
    public void setCharacterEncoding(String enc) throws UnsupportedEncodingException {
        super.setCharacterEncoding(enc);
    }

    @Override
    public String getContentType() {
        return super.getContentType();
    }

    @Override
    public String getParameter(String name) {
        return super.getParameter(name);
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        return super.getParameterMap();
    }

    @Override
    public Enumeration<String> getParameterNames() {
        return super.getParameterNames();
    }

    @Override
    public String[] getParameterValues(String name) {
        return super.getParameterValues(name);
    }

    @Override
    public void setAttribute(String name, Object o) {
        super.setAttribute(name, o);
    }
}
