@Component
@RequiredArgsConstructor
public class DefaultInventoryHandler implements InventoryHandler {


    private final InventoryRepository inventoryRepository;


    @Override
    public void updateInventory(String productId, int quantity) {
        List<InventoryBatch> batches = inventoryRepository.findByProductIdOrderByExpiryDateAsc(productId);


        for (InventoryBatch batch : batches) {
            if (quantity <= 0) break;
            int used = Math.min(batch.getQuantity(), quantity);
            batch.setQuantity(batch.getQuantity() - used);
            quantity -= used;
            inventoryRepository.save(batch);
        }
    }
}