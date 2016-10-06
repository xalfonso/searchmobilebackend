/*
 * Property of RECAPT http://recapt.com.ec/
 * Chief Developer Ing. Eduardo Alfonso Sanchez eddie.alfonso@gmail.com
 */
package com.eas.comun.web.json;

/**
 *
 * @author Eduardo
 */
public class ResponseJsonWrapper {

    private Message message;
    private Object result;

    public ResponseJsonWrapper() {
    }

    public ResponseJsonWrapper(Message message, Object result) {
        this.message = message;
        this.result = result;
    }

    public ResponseJsonWrapper(Message message) {
        this.message = message;
        this.result = null;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

}
