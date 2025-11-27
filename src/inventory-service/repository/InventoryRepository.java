@Repository
public interface InventoryRepository extends JpaRepository<InventoryBatch, Long> {
    List<InventoryBatch> findByProductIdOrderByExpiryDateAsc(String productId);
}