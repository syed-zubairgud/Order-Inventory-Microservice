@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryBatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productId;
    private int quantity;
    private LocalDate expiryDate;
}