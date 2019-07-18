package Work.Filter;

import javax.servlet.*;
import java.io.IOException;

public class CoderFilter implements Filter {
    private String encoding;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //请求编码
        servletRequest.setCharacterEncoding(encoding);
        //设置响应
        servletResponse.setCharacterEncoding(encoding);
        servletResponse.setContentType("text/html;charset=utf-8");
        //执行客户端
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
