package br.com.lksferreira.todolist.filter;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.lksferreira.todolist.user.IUserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {

    @Autowired
    private IUserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        var servletPath = request.getServletPath();

        if (!servletPath.startsWith("/tasks/")) {
            filterChain.doFilter(request, response);
            return;
        }

        // Lógica para verificar a autenticação
        var autorization = request.getHeader("Authorization");
        var authEncoded = autorization.substring("Basic".length()).trim();
        byte[] decode = Base64.getDecoder().decode(authEncoded);
        String authDecoded = new String(decode);

        String[] credentials = authDecoded.split(":");
        String username = credentials[0];
        String password = credentials[1];

        // Verifica o usuário
        var user = userRepository.findByUsername(username);
        if (user == null) {
            response.sendError(401);
        } else {
            // Verifica a senha
            var passwordVerified = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());

            if (passwordVerified.verified) {
                request.setAttribute("userId", user.getId());
                filterChain.doFilter(request, response);
            } else {
                response.sendError(401);
            }
        }
    }

}
