package com.company.common.exceptions.validate;

@SuppressWarnings("serial")
public class EmailExistsException
    extends Throwable{

    public EmailExistsException(){
        super("Mailing address is already in use.");
    }

    public EmailExistsException(final String message){
        super(message);
    }
}
