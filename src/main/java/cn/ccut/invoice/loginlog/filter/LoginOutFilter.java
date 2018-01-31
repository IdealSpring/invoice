package cn.ccut.invoice.loginlog.filter;

import cn.ccut.invoice.loginlog.service.LogService;
import cn.ccut.invoice.loginlog.model.Log;
import cn.ccut.invoice.user.model.User;
import org.apache.shiro.web.filter.PathMatchingFilter;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 过滤器，记录登录登出
 */
public class LoginOutFilter extends PathMatchingFilter{
    @Resource(name = "logService")
    private LogService logService;

    private Log log = null;

    @Override
    protected boolean onPreHandle(ServletRequest req, ServletResponse response, Object mappedValue) throws Exception {
        HttpServletRequest request = (HttpServletRequest) req;

        /*System.out.println("onPreHandle被执行了");
        System.out.println("RequestURL" + request.getRequestURL());
        System.out.println("RequestURI" + request.getRequestURI());
        System.out.println("RemoteAddr" + request.getRemoteAddr());
        System.out.println("用户id：" + request.getSession().getAttribute("roleID"));*/

        User currentUser = (User) request.getSession().getAttribute("currentUser");


        if(currentUser != null) {
            String uriValue = request.getRequestURI();
            int start = uriValue.lastIndexOf("/") + 1;
            String value = uriValue.substring(start);

            if(value.equals("welcome.jsp")) {
                log = new Log();
                log.setUsername(currentUser.getName());
                log.setUid(currentUser.getUid());
                log.setIp(request.getRemoteAddr());
                Date date=new Date();
                /*System.out.println(date.toString());*/
                log.setCreatedate(date);
                logService.addLog(log);
                /*System.out.println(log.getLid());*/
                request.getSession().setAttribute("log", log);
            }

            if(value.equals("logout")) {
                Log logg = (Log)request.getSession().getAttribute("log");
                Date date=new Date();
                /*System.out.println(date.toString());*/
                log.setDeletedate(date);
                logService.addLogLogout(logg);
            }
        }
        return true;
    }
}






