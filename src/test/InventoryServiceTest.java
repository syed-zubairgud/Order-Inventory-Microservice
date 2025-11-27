@SpringBootTest
class InventoryServiceTest {


    @Mock
    private InventoryRepository repository;


    @Mock
    private InventoryHandlerFactory factory;


    @InjectMocks
    private InventoryService service;


    @Test
    void testGetInventoryReturnsSortedList() {
        List<InventoryBatch> batches = List.of(
                new InventoryBatch(1L, "P1", 10, LocalDate.now().plusDays(5)),
                new InventoryBatch(2L, "P1", 5, LocalDate.now().plusDays(1))
        );


        when(repository.findByProductIdOrderByExpiryDateAsc("P1")).thenReturn(batches);


        List<InventoryBatch> result = service.getInventory("P1");


        assertEquals(2, result.size());
        assertEquals(5, result.get(0).getQuantity());
    }
}