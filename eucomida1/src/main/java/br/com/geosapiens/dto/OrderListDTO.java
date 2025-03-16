package br.com.geosapiens.dto;

public class OrderListDTO implements OrderDTO {
    private Long idProduct;
    private Long idUser;
    private Integer status;
    private String descStatus;
    private Double productValue;
    private Double deliveryFee;
    private Double deliveryFeePartPerson;

    public Double getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(Double deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Double getProductValue() {
        return productValue;
    }

    public void setProductValue(Double productValue) {
        this.productValue = productValue;
    }

    public Double getDeliveryFeePartPerson() {
        return deliveryFeePartPerson;
    }

    public void setDeliveryFeePartPerson(Double deliveryFeePartPerson) {
        this.deliveryFeePartPerson = deliveryFeePartPerson;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescStatus() {
        return descStatus;
    }

    public void setDescStatus(String descStatus) {
        this.descStatus = descStatus;
    }
}