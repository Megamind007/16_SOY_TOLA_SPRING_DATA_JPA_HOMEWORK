package org.example.springdatajpahomework.service.serviceImp;
import lombok.AllArgsConstructor;
import org.example.springdatajpahomework.model.dto.request.OrderRequest;
import org.example.springdatajpahomework.model.dto.response.OrderResponse;
import org.example.springdatajpahomework.model.entity.Customer;
import org.example.springdatajpahomework.model.entity.Order;
import org.example.springdatajpahomework.model.entity.Product;
import org.example.springdatajpahomework.model.entity.ProductOrder;
import org.example.springdatajpahomework.model.eum.Status;
import org.example.springdatajpahomework.repository.CustomerRepository;
import org.example.springdatajpahomework.repository.OrderRepository;
import org.example.springdatajpahomework.repository.ProductOrderRepository;
import org.example.springdatajpahomework.repository.ProductRepository;
import org.example.springdatajpahomework.service.OrderService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
@AllArgsConstructor
public class OrderServiceImp implements OrderService {
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final ProductOrderRepository productOrderRepository;
    private final OrderRepository orderRepository;

    public OrderResponse saveOrder(Long customerId, List<OrderRequest> orderRequests) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow();
        Order order = new Order();
        order.setCustomer(customer);
        order.setOrderDate(LocalDateTime.now());
        order.setStatus(Status.PENDING);
        order.setTotalAmount(0f);
        Set<ProductOrder> productOrders = new HashSet<>();
        float totalAmount = 0f;
        for (OrderRequest orderRequest : orderRequests) {
            Product product = productRepository.findById(orderRequest.getProductId())
                    .orElseThrow();
            ProductOrder productOrder = orderRequest.toEntity(order, product);
            float amount = (float) (product.getUnitPrice() * productOrder.getQuantity());
            totalAmount += amount;
            productOrders.add(productOrder);
        }
        order.setTotalAmount(totalAmount);
        order.setProductOrders(productOrders);
        orderRepository.save(order);
        productOrderRepository.saveAll(productOrders);
        return order.toResponse();
    }

    @Override
    public List<OrderResponse> updateStatusOrder(Status status, Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if (customer == null) {
            return null;
        }
        Set<Order> orders = orderRepository.findOrderByCustomer_CustomerId(customerId);
        System.out.println("Order: " + orders);
        for(Order order : orders) {
            order.setStatus(status);
            orderRepository.save(order);
        }
        return orders.stream().map(Order::toResponse).toList();
    }

    @Override
    public List<OrderResponse> findOrderByCustomerId(Long customerId) {
        Set<Order> orders = orderRepository.findOrderByCustomer_CustomerId(customerId);
        return orders.stream().map(Order::toResponse).toList();
    }

    @Override
    public OrderResponse findOrderById(Long orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order == null) {
            return null;
        }
        return order.toResponse();
    }

}
