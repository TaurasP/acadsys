package lt.tauras.acadsys.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Configuration
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

        // Pagalvoti kaip geriau - ar nukreipti visas roles i index puslapi ar i atskirus
        if (roles.contains("ROLE_ADMIN")) {
            // galetu buti i /admin
            httpServletResponse.sendRedirect("/index");
        } else {
            httpServletResponse.sendRedirect("/index");
        }
    }
}
