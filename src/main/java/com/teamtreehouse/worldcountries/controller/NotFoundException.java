package com.teamtreehouse.worldcountries.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Page Not Found")
public class NotFoundException extends RuntimeException{
}
