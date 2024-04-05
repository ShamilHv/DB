package aze.coders.entity;

public class Client {
    private String client_name;
    private int client_id;

    public Client(String client_name, int client_id) {
        this.client_name = client_name;
        this.client_id = client_id;
    }

    public Client() {

    }

    @Override
    public String toString() {
        return "Client{" +
                "client_name='" + client_name + '\'' +
                ", client_id=" + client_id +
                '}';
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }
}
