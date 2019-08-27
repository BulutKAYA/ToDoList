package com.bulut.todolist.security;

public class SecurityConstants {

    public static final String SIGN_UP_URL = "/api/user/sign-up";
    public static final String LOG_IN_URL = "/api/user/login";
    public static final String SECRET = "EmakinaTalent";
    public static final long EXPIRATION_TIME = 432_000_000; // 5 gün
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
}