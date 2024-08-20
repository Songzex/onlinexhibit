package com.example.config;

import com.example.pojo.UserRole;
import com.example.service.UserService;
import com.example.utils.JwtBlacklist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private UserService userService;
    @Autowired
    private JwtBlacklist blacklist;

    //过滤操作  （认证授权操作）
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = getJwtFromRequest(request);

        if (StringUtils.hasText(token) && jwtUtils.validateToken(token)) {
            //黑名单token 判定
            if (blacklist.isBlacklisted(token)) {
                // Token 在黑名单中，拒绝访问
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                return;
            }
            String email = jwtUtils.getEmailFromToken(token);
            Set<SimpleGrantedAuthority> authorityList = getUserAuthorities(email);
            // 在 Spring Security 上下文中设置用户认证信息
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, null, authorityList);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }
    //获取用户权限列表并设置 （授权操作）
    private Set<SimpleGrantedAuthority> getUserAuthorities(String email) {
        // 根据用户名从数据库或其他存储中获取用户的权限信息，并转换成 Spring Security 的 GrantedAuthority 对象
        // 这里只是示例，实际情况根据项目需求来实现
        List<GrantedAuthority> authorities = new ArrayList<>();
        //List<UserRole> roleByemail =userService.getRoleByrid(userService.getRByemail(email));
   /*     authorities.add(new SimpleGrantedAuthority("ROLE_USER"));//这段代码是为登陆用户 添加角色来权限的吗*/
//        for (UserRole role : roleByemail) {
//            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoles()));
//        }
        Set<SimpleGrantedAuthority> collect = userService.getRoleByrid(userService.getRByemail(email)).stream().
                map(userRole -> new SimpleGrantedAuthority("ROLE_" + userRole.getRoles())).collect(Collectors.toSet());
        return collect;
    }
    //token获取
    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }


}


