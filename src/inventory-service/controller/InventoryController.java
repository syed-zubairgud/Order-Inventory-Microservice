@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {


    private final InventoryService service;


    @GetMapping("/{productId}")
    public List<InventoryBatch> getInventory(@PathVariable String productId) {
        return service.getInventory(productId);
    }


    @PostMapping("/update")
    public ResponseEntity<String> updateInventory(@RequestBody Map<String, Object> request) {
        service.updateInventory((String) request.get("productId"), (int) request.get("quantity"));
        return ResponseEntity.ok("Inventory updated successfully");
    }
}