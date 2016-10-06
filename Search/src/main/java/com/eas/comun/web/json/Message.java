/*
 * Property of RECAPT http://recapt.com.ec/
 * Chief Developer Ing. Eduardo Alfonso Sanchez eddie.alfonso@gmail.com
 */
package com.eas.comun.web.json;

import java.util.Arrays;

/**
 *
 * @author eduardo
 */
public class Message {

    public static final int ERROR = 0;
    public static final int WARN = 1;
    public static final int INFO = 2;
    public static final boolean SHOW_STACKTRACE = false;
    public static final boolean SHOW_ERROR_MESSAGE = true;
    private String message;
    private String stacktrace;
    private int type;

    public Message(String message, int type) {
        this.message = message;
        this.type = type;
        this.stacktrace = "";
    }
    
    public Message(String message, int type, String stacktrace) {
        this.message = message;
        this.type = type;
        this.stacktrace = stacktrace;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getStacktrace() {
        return stacktrace;
    }

    public void setStacktrace(String stacktrace) {
        this.stacktrace = stacktrace;
    }
    
    

    public static Message buildMessage(String msg, int type, String errorMessage, StackTraceElement[] stackTraceElements) {

        StringBuilder me = new StringBuilder(msg);
        String stackTrace = null;
        if (SHOW_ERROR_MESSAGE) {
            me.append(" Causa: ").append(errorMessage);
        }
        if (SHOW_STACKTRACE) {
          stackTrace = Arrays.toString(stackTraceElements);
        }       
        
        Message message = new Message(me.toString(), type, stackTrace);
        return message;
    }

    public static Message buildErrorMessage(Exception e) {
        return buildMessage("Ha ocurrido un error. ", ERROR, e.getMessage(), e.getStackTrace());
    }
    
    public static Message buildDefaulInfoMessage() {
        return new Message("Operación realizada satisfactoriamente", INFO);
    }

}
