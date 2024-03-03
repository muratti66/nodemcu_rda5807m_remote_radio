#include <RDA5807.h>
#include <ESP8266WiFi.h>
#include <ESP8266HTTPClient.h>

const char* C_SSID = "****"; # must be change
const char* C_PASSWD = "****"; # must be change
const char* ESP_HOSTNAME = "McuRadioSystem"; # optional change
const boolean DEBUG = true;

RDA5807 rx;
WiFiServer wifiServer(12345); # optional port
WiFiClient client;

int device_frequance = 10400;
int device_volume = 1;

void setup() {
  Serial.begin(9600);

  rx.setup();
  rx.setVolume(device_volume);
  rx.setRDS(false);
  rx.setAFC(true);
  rx.setFrequency(device_frequance);

  wifi_setup();
  wifiServer.begin();
}

void loop() {
  wifi_handler();
  delay(10);
}

void wifi_handler() {
  String dataa;
  bool breaking = false;

  client = wifiServer.available();

  if (client) {
    if (DEBUG) {
      Serial.println("Client is connected.");
    }
    while (client.connected()) {
      while (client.available() > 0) {
        dataa = client.readStringUntil('\n');
        dataa.trim();
        if (DEBUG) {
          Serial.println("Data : " + dataa);
        }
        if (dataa.length() == 0) {
          continue;
        }
        if (dataa == "ping") {
          client.println("pong");
        }
        if (dataa == "exit") {
          breaking = true;
        }
        if (dataa == "quit") {
          breaking = true;
          break;
        }
        if (dataa == "restart") {
          ESP.restart();
          breaking = true;
        }
        rradio_sending(dataa);
      }
      if (breaking) {
        break;
      }
      delay(10);
    }
    client.stop();
    if (DEBUG) {
      Serial.println("Client disconnected..");
    }
  }
}

void rradio_sending(String rr_code) {

  String valueString;
  int int_value;
  
  if (rr_code.startsWith("VOL")) {
     valueString = rr_code.substring(3);
     rx.setVolume(rr_code.substring(3).toInt());
     device_volume = rr_code.substring(3).toInt();
  } else if (rr_code.startsWith("GETVOL")) {
    client.println(String(device_volume));
  } else if (rr_code.startsWith("FREQ")) {
    valueString = rr_code.substring(4);
    rx.setFrequency(rr_code.substring(4).toInt());
    device_frequance = rr_code.substring(4).toInt();
  } else if (rr_code.startsWith("GETFREQ")) {
    client.println(String(device_frequance));
  } else if (rr_code.startsWith("AFCSET")) {
    int stat = rr_code.substring(6).toInt();
    if (stat == 0) {
      rx.setAFC(false);
    } else {
      rx.setAFC(true);
    }
    if (DEBUG) {
      Serial.println("RR Code : " + rr_code);
    }
  }
}

void wifi_setup() {
  WiFi.setAutoConnect(true);
  WiFi.setAutoReconnect(true);
  WiFi.persistent(true);
  WiFi.setSleepMode(WIFI_NONE_SLEEP);
  
  String out;
  if (DEBUG) {
    Serial.println("");
    Serial.println("Setup Started..");
    Serial.print("Connecting to ");
    Serial.print(C_SSID);
    Serial.print(" : ");

  }
  WiFi.mode(WIFI_STA);
  out = (WiFi.begin(C_SSID, C_PASSWD) ? "Ready" : "Failed!");
  if (DEBUG) {
    Serial.println(out);
    Serial.print("Waiting ap initialization..");
  }

  while (WiFi.status() != WL_CONNECTED) {
    WiFi.hostname(ESP_HOSTNAME);
    delay(2000);
    if (DEBUG) {
      Serial.print(".");
    }
  }
  if (DEBUG) {
    Serial.println(" Device Ready ...");
    Serial.print("WiFi connected, IP address : ");
    Serial.println(WiFi.localIP());
    Serial.println("Setup Ended .");
  }
}
