package entity;

import java.time.LocalDate;
import java.util.UUID;
import types.UserTypes.UserTypesOne;

public class User {
    private UUID id;
    private String name;
    private String email;
    private float balance;
    private UserTypesOne type;
    private LocalDate createdAt;

    public User(String name, String email, float balance, UserTypesOne type, LocalDate createdAt) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.balance = balance;
        this.type = type;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public float getBalance() {
        return balance;
    }

    public UserTypesOne getType() {
        return type;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setBalance(float newBalance) {
        this.balance = newBalance;
    }
}