package ch.heig.amt.academic.api.interceptor;

import ch.heig.amt.academic.api.service.JwtService;
import ch.heig.amt.academic.api.service.UserAuthority;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class JwtInterceptor extends HandlerInterceptorAdapter {
    private static final Logger logger = LoggerFactory.getLogger(JwtInterceptor.class);

    @Autowired
    JwtService jwtService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try{
            String token = getJwtFromRequest(request);
            if(jwtService.validateToken(token)) {
                UserAuthority userAuthority = jwtService.getUserAuthority(token);

                request.setAttribute("userAuthority", userAuthority);
                return true;
            }
        }catch (JWTVerificationException | NullPointerException exception){
            //Return an unauthorized status (401)
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
    }

    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken)) {
            return bearerToken;
        }
        bearerToken = (String)request.getParameter("token");
        if (StringUtils.hasText(bearerToken)) {
            return bearerToken;
        }
        return null;
    }
}
