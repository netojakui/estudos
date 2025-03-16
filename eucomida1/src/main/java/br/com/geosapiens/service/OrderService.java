package br.com.geosapiens.service;

import br.com.geosapiens.model.Order;
import br.com.geosapiens.repository.OrderRepository;
import br.com.geosapiens.repository.ProductRepository;
import br.com.geosapiens.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public List<Order> getOrdersByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    public Double calculateTotalEarnings(Long userId) {
        List<Order> orders = orderRepository.findByUserId(userId);
        return orders.stream()
                .mapToDouble(Order::calculateDeliveryEarnings)
                .sum();
    }
}