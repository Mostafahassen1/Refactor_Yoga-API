package Refactor_Yoga.Refactor_Yoga.config;


import Refactor_Yoga.Refactor_Yoga.entity.Client;
import Refactor_Yoga.Refactor_Yoga.util.ClientDetailes;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {
     private final String SECRET_KEY = "220d1bf626f0fed4ceb9e7c32c2e8e815804516263fcf574971fa1f5bb680598";


     public String extractUsername(String token) {
          return extractClaim(token, Claims::getSubject);
     }


     public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
          final Claims claims = extractAllClaims(token);
          return claimsResolver.apply(claims);
     }

     private Claims extractAllClaims(String token ){
          return Jwts
                  .parser()
                  .verifyWith(getSigninKey())
                  .build()
                  .parseSignedClaims(token)
                  .getPayload() ;
     }

     public boolean isTokenValid(String token, UserDetails userDetails) {
          final String username = extractUsername(token);
          return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
     }
     private boolean isTokenExpired(String token) {
          return extractExpiration(token).before(new Date());
     }

     private Date extractExpiration(String token) {
          return extractClaim(token, Claims::getExpiration);
     }
     public String generateToken(Client client){
          String token = Jwts
                  .builder()
                  .subject(client.getEmail())
                  .issuedAt(new Date(System.currentTimeMillis()))
                  .expiration(new Date(System.currentTimeMillis()+ 24 *60*60*1000) )
                  .signWith(getSigninKey())
                  .compact();
          return token ;
     }

     private SecretKey getSigninKey(){
          byte[] keyBytes = Decoders.BASE64URL.decode(SECRET_KEY) ;
          return Keys.hmacShaKeyFor(keyBytes) ;
     }
}
