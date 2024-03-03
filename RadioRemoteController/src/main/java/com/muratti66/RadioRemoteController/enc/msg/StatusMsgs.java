package com.muratti66.RadioRemoteController.enc.msg;

import com.muratti66.RadioRemoteController.enc.msg.*;

public enum StatusMsgs {
    CONNECTING("Bağlanıyor .."),
    CONNECTED("Bağlı"),
    DISCONNECTED("Bağlantı Yok .!");
    
    private final String text;
    
    StatusMsgs(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return String.valueOf(text);
    }
}

