@Service
@RequiredArgsConstructor
public class OrderService {


    private final OrderRepository repository;
    private final RestTemplate restTemplate;


    public Order placeOrder(Order order) {
        String url = "http://localhost:8081/inventory/update";


        Map<String, Object> request = new HashMap<>();
        request.put("productId", order.getProductId());
        request.put("quantity", order.getQuantity());


        restTemplate.postForObject(url, request, String.class);


        return repository.save(order);
    }
}