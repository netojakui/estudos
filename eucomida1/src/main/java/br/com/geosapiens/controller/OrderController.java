package br.com.geosapiens.controller;

import br.com.geosapiens.dto.OrderInsertDTO;
import br.com.geosapiens.dto.OrderListDTO;
import br.com.geosapiens.mapper.OrderMapper;
import br.com.geosapiens.model.Order;
import br.com.geosapiens.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderMapper orderMapper;

    @PostMapping
    public ResponseEntity<OrderListDTO> createOrder(@RequestBody OrderInsertDTO orderListDTO) {
        Order createdOrder = orderService.createOrder(orderMapper.toOrder(orderListDTO));
        return ResponseEntity.ok(orderMapper.toOrderDTO(createdOrder));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderListDTO> getOrderById(@PathVariable Long id) {
        Order order = orderService.getOrderById(id);
        return ResponseEntity.ok(orderMapper.toOrderDTO(order));
    }

    @GetMapping
    public ResponseEntity<List<OrderListDTO>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        List<OrderListDTO> orderListDTOS = orders.stream()
                                         .map(orderMapper::toOrderDTO)
                                         .collect(Collectors.toList());
        return ResponseEntity.ok(orderListDTOS);
    }
}