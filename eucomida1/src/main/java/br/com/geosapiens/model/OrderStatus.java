package br.com.geosapiens.model;

public enum OrderStatus {
    EM_ANDAMENTO(1, "PENDING"),
    ENTREGUE(2, "COMPLETED"),
    CANCELADO(3, "CANCELLED");

    private final int code;
    private final String description;

    OrderStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static OrderStatus fromCode(int code) {
        for (OrderStatus status : OrderStatus.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid code: " + code);
    }

    public static OrderStatus fromDescription(String description) {
        for (OrderStatus status : OrderStatus.values()) {
            if (status.getDescription().equalsIgnoreCase(description)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid description: " + description);
    }
}