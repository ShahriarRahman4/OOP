package com.mycompany.lab_final_2;

import java.util.List;

public abstract class AbstractDataLoader implements DataSource {

    protected boolean connected;

    public AbstractDataLoader() {
        this.connected = false;
    }

    public void connect() {
        this.connected = true;
    }

    public void disconnect() {
        this.connected = false;
    }

    public boolean isConnected() {
        return this.connected;
    }

    public abstract List<Book> loadBooks();
}
