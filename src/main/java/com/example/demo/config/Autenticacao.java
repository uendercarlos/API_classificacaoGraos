
package com.example.demo.config;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;

/**
 *
 * @author Uender Carlos
 */
public class Autenticacao {

    public static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

}
