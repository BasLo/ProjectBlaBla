package com.company.common.exceptions.validate;

@SuppressWarnings("serial")
public class UsernameExistsException
        extends Throwable{

    public UsernameExistsException(){
        super("Username already exists.");
    }

    public UsernameExistsException(final String message){
        super(message);
    }
}
