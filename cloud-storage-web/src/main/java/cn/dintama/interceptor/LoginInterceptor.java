package cn.dintama.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Pattern;

/**
 * Created by Dintama on 2017/5/26.
 */
public class LoginInterceptor implements HandlerInterceptor {

    private static final String urlF = "/api/.*";
    private static final String urlS = "/static/.*";
    private static final String urlT = "/signUp";
    private static final String urlFo = "/validate/.*";


    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String requestURI = httpServletRequest.getRequestURI();
        Pattern compileHF = Pattern.compile(urlF);
        Pattern compile = Pattern.compile(urlS);
        Pattern compile1 = Pattern.compile(urlT);
        Pattern compile2 = Pattern.compile(urlFo);
        if(compileHF.matcher(requestURI).matches() || compile.matcher(requestURI).matches()
                || compile1.matcher(requestURI).matches() || compile2.matcher(requestURI).matches()){
            return true;
        }
        Object user = httpServletRequest.getSession().getAttribute("user");
        if(user == null){
            httpServletRequest.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(httpServletRequest, httpServletResponse);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
