package br.com.geosapiens.mapper;

import br.com.geosapiens.dto.OrderInsertDTO;
import br.com.geosapiens.dto.OrderListDTO;
import br.com.geosapiens.exception.ResourceNotFoundException;
import br.com.geosapiens.model.Order;
import br.com.geosapiens.model.OrderStatus;
import br.com.geosapiens.model.Product;
import br.com.geosapiens.model.User;
import br.com.geosapiens.repository.ProductRepository;
import br.com.geosapiens.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    public OrderListDTO toOrderDTO(Order order) {
        OrderListDTO orderListDTO = new OrderListDTO();
        orderListDTO.setIdProduct(order.getProduct() != null ? order.getProduct().getId() : null);
        orderListDTO.setIdUser(order.getUser() != null ? order.getUser().getId() : null);
        if (order.getStatus() != null) {
            orderListDTO.setStatus(order.getStatus());
            orderListDTO.setDescStatus(OrderStatus.fromCode(order.getStatus()).getDescription());
        }

        orderListDTO.setProductValue(order.getProductValue());
        orderListDTO.setDeliveryFee(order.getDeliveryFee());
        orderListDTO.setDeliveryFeePartPerson(order.getDeliveryFeePartPerson());
        return orderListDTO;
    }

    public Order toOrder(OrderInsertDTO orderListDTO) {
        Order order = new Order();
        order.setDeliveryFee(orderListDTO.getDeliveryFee());
        order.setStatus(orderListDTO.getStatus());
        if (orderListDTO.getIdProduct() != null) {
            Product product = productRepository.findById(orderListDTO.getIdProduct())
                    .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + orderListDTO.getIdProduct()));
            order.setProduct(product);
            order.setProductValue(product.getValue());
        }
        if (orderListDTO.getIdUser() != null) {
            User user = userRepository.findById(orderListDTO.getIdUser())
                    .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + orderListDTO.getIdUser()));
            order.setUser(user);
        }
        order.setDeliveryFeePartPerson(order.calculateDeliveryEarnings());
        return order;
    }

}