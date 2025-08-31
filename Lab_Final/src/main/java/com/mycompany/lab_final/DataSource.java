
package com.mycompany.lab_final;


public interface DataSource {
    void connect();
    void disconnect();
    boolean isConnected();
    
}
