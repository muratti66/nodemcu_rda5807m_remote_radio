package com.muratti66.RadioRemoteController.enc.msg;

public enum OutputMsgs {
    FIRST_INIT("First initialization..."),
    CONN_TRY("Try to connect..."),
    CONN_SUCC("Connected."),
    DISCONN("Disconnected..!"),
    ERR("Error .! : "),
    ONL_ERR("Connection problem..!"),
    UND_CHAR("Undefined character : "),
    APP_STARTING("App will be started..");


    private final String text;
    
    OutputMsgs(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return String.valueOf(text);
    }
    
}
