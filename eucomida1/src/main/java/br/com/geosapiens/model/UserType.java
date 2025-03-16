package br.com.geosapiens.model;

public enum UserType {
    ADMIN(1, "Admin"),
    User(2, "Usuario"),
    ENTREGADOR(3, "Entregador");

    private final int code;
    private final String description;

    UserType(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static UserType fromCode(int code) {
        for (UserType status : UserType.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid code: " + code);
    }

    public static UserType fromDescription(String description) {
        for (UserType status : UserType.values()) {
            if (status.getDescription().equalsIgnoreCase(description)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid description: " + description);
    }
}