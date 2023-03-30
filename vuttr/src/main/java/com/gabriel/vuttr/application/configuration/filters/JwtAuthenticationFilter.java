package com.gabriel.vuttr.application.configuration.filters;

import com.gabriel.vuttr.application.security.JwtService;
import com.gabriel.vuttr.application.security.adapters.UserDetailsServiceAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

  private final JwtService jwtService;
  private final UserDetailsServiceAdapter userDetailsServiceAdapter;

  @Override
  protected void doFilterInternal(
    @NonNull final HttpServletRequest request,
    @NonNull final HttpServletResponse response,
    @NonNull final FilterChain filterChain
  ) throws ServletException, IOException {
    final var authenticationHeader = request.getHeader("Authorization");
    if (authenticationHeader == null || !authenticationHeader.startsWith("Bearer ")) {
      filterChain.doFilter(request, response);
      return;
    }
    final var jwtToken = authenticationHeader.substring("Bearer ".length());
    final var userEmail = this.jwtService.extractUsername(jwtToken);
    if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
      final var userDetails = this.userDetailsServiceAdapter.loadUserByUsername(userEmail);
      if (this.jwtService.isTokenValid(jwtToken, userDetails)) {
        final var authenticationToken = new UsernamePasswordAuthenticationToken(
          userDetails,
          null,
          userDetails.getAuthorities()
        );
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
      }
    }
    filterChain.doFilter(request, response);
  }

}
