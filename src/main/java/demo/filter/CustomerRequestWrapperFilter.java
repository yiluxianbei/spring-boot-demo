package demo.filter;

import demo.filter.wrapper.CustomerRequestWrapper;
import demo.filter.wrapper.CustomerResponseWrapper;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomerRequestWrapperFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        //  包装request,代替原来的HttpServletRequest，重写HttpServletRequest中的方法
        // 如果调用原来HttpServletRequest中的方法，会走此包装类中的方法
        CustomerRequestWrapper customerRequestWrapper = new CustomerRequestWrapper(httpServletRequest);
        // 包装Response,代替原来的HttpServletResponse，重写HttpServletResponse中的方法
        // 如果调用原来HttpServletResponse中的方法，会走此包装类中的方法
        CustomerResponseWrapper customerResponseWrapper = new CustomerResponseWrapper(httpServletResponse);
        filterChain.doFilter(customerRequestWrapper,customerResponseWrapper);
    }
}
