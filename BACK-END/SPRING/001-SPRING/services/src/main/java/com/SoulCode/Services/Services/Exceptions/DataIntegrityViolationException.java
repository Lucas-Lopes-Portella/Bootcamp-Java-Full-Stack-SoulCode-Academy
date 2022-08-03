package com.SoulCode.Services.Services.Exceptions;

public class DataIntegrityViolationException extends RuntimeException{
   public DataIntegrityViolationException(String msg){
      super(msg);
   }
}
