package Refactor_Yoga.Refactor_Yoga.entity;


import jakarta.persistence.Column;


import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class UserClassCompositeKey {

    @Column( name = "client_id")
    private UUID clientId ;

    @Column( name = "session_id")
    private UUID sessionId ;

    public UserClassCompositeKey() {
    }

    public UserClassCompositeKey(UUID clientId, UUID sessionId) {
        this.clientId = clientId;
        this.sessionId = sessionId;
    }

    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }

    public UUID getSessionId() {
        return sessionId;
    }

    public void setSessionId(UUID sessionId) {
        this.sessionId = sessionId;
    }
}






