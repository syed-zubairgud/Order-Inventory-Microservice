@Component
@RequiredArgsConstructor
public class InventoryHandlerFactory {


    private final DefaultInventoryHandler defaultHandler;


    public InventoryHandler getHandler(String productId) {
        return defaultHandler; // easily extendable later
    }
}