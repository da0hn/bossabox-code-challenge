package com.gabriel.vuttr.application.security.adapters;

import com.gabriel.vuttr.application.configuration.properties.JwtProperties;
import com.gabriel.vuttr.application.security.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class JwtServiceImpl implements JwtService {

  private final JwtProperties jwtProperties;

  public String extractUsername(final String token) {
    return this.extractClaim(token, Claims::getSubject);
  }

  @Override
  public boolean isTokenValid(
    final String token,
    final UserDetails userDetails
  ) {
    final var username = this.extractUsername(token);
    return (username.equals(userDetails.getUsername())) && !this.isTokenExpired(token);
  }

  @Override
  public String generateToken(final UserDetails userDetails) {
    final Map<String, Object> claims = new HashMap<>();
    return this.createToken(claims, userDetails);
  }

  private String createToken(
    final
    Map<String, Object> claims,
    final UserDetails userDetails
  ) {
    return Jwts.builder()
      .setClaims(claims)
      .setSubject(userDetails.getUsername())
      .claim("authorities", userDetails.getAuthorities())
      .setIssuedAt(new Date(System.currentTimeMillis()))
      .setExpiration(new Date(System.currentTimeMillis() + TimeUnit.HOURS.toMillis(24)))
      .signWith(Keys.hmacShaKeyFor(this.jwtProperties.secret().getBytes()), SignatureAlgorithm.HS512)
      .compact();
  }

  private <T> T extractClaim(
    final String token,
    final Function<? super Claims, T> claimsResolver
  ) {
    final var claims = this.extractAllClaims(token);
    return claimsResolver.apply(claims);
  }

  private Claims extractAllClaims(final String token) {
    final var sanitizedToken = token.replace("Bearer ", "");
    return Jwts.parserBuilder()
      .setSigningKey(this.jwtProperties.secret().getBytes())
      .build()
      .parseClaimsJws(sanitizedToken)
      .getBody();
  }

  private boolean isTokenExpired(final String token) {
    final var expiration = this.extractExpiration(token);
    return expiration != null && expiration.before(new Date());
  }

  private Date extractExpiration(final String token) {
    return this.extractClaim(token, Claims::getExpiration);
  }

}
