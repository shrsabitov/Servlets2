package secure.filters.auth;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintWriter;

//@WebFilter(
//        urlPatterns = "/uploadFilter",
//        initParams = @WebInitParam(name = "fileTypes", value = "doc;xls;zip;txt;jpg;png;gif")
//)

@WebFilter("/admin")
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String password = servletRequest.getParameter("password");
        PrintWriter out = servletResponse.getWriter();
        servletResponse.setContentType("text/html;charset=UTF-8"); //обязательно, иначе по умолчанию "text/plain"

        if (password.equals("root")) {
            filterChain.doFilter(servletRequest, servletResponse);//по сути это аналогично RequestDispatcher->forward
        } else {
            out.println("Wrong ...<br><br>"); /* иначе модифицируем response

                т.е. фильтры не только позволяют направлять и перенаправлять response, но и модифицировать содержимое риспонса.
                Также можно модифицировать и request, например:
                HttpServletRequest httpServletRequest = ((HttpServletRequest) servletRequest);
                String requestURI = httpServletRequest.getRequestURI();
                if (requestURI.startsWith("/admin") && !requestURI.contains(".xhtml")) {
                    request.getRequestDispatcher(requestURI.concat(".xhtml"))
                .forward(request,response);
                } else {
                 chain.doFilter(httpServletRequest, response);
                }

                Еще интересный вариант - работать с оберткой, для модификации риспонса,
                например, ограничить метод flushBuffer респонса:

                class DisallowFlushResponseWrapper extends HttpServletResponseWrapper {
                    public DisallowFlushResponseWrapper(HttpServletResponse response) {
                        super(response);
                    }

                    @Override
                    public void flushBuffer() {
                        throw new UnsupportedOperationException("Don't call this!");
                    }
                }

                И соответствующий фильтр, где с помощью обертки создаем новый риспонс. Иначе пришлось бы слишком много
                переопределять, если напрямую HttpServletResponse response=new HttpServletResponse ... :

                class DisallowFlushFilter implements Filter {
                    public void doFilter(ServletRequest request, ServletResponse response,
                            FilterChain chain) {
                        if (response instanceof HttpServletResponse) {
                            HttpServletResponse newResponse =
                                new DisallowFlushResponseWrapper((HttpServletResponse) response);
                            chain.doFilter(request, newResponse);
                        }
                        ...
                    }
                    ...
                }

             */
            RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher("admin.html");
            requestDispatcher.include(servletRequest, servletResponse);
        }


    }
}
//неплохой детальный пример тут: