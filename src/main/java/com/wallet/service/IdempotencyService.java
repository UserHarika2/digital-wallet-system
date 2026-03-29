@Service
public class IdempotencyService {
    private final Map<String, Boolean> processedKeys = new ConcurrentHashMap<>();
    
    public boolean isProcessed(String idempotencyKey) {
        return processedKeys.containsKey(idempotencyKey);
    }
    
    public void markProcessed(String idempotencyKey) {
        processedKeys.put(idempotencyKey, true);
    }
}