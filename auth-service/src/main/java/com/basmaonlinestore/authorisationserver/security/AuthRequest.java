package com.basmaonlinestore.authorisationserver.security;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthRequest {
    private String firstName;
    private String lastName;
    private String login;
    private String password;
}
