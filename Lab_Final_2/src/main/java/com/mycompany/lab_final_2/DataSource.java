package com.mycompany.lab_final_2;

public interface DataSource {

    void connect();

    void disconnect();

    boolean isConnected();

}
