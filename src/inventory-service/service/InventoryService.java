@Service
@RequiredArgsConstructor
public class InventoryService {


    private final InventoryRepository repository;
    private final InventoryHandlerFactory factory;


    public List<InventoryBatch> getInventory(String productId) {
        return repository.findByProductIdOrderByExpiryDateAsc(productId);
    }


    public void updateInventory(String productId, int quantity) {
        InventoryHandler handler = factory.getHandler(productId);
        handler.updateInventory(productId, quantity);
    }
}