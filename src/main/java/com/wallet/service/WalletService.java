@Service
@Transactional
public class WalletService {
    private final WalletRepository walletRepository;
    
    @Autowired
    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }
    
    @Transactional
    public Wallet createWallet(String userId) {
        Wallet wallet = new Wallet(userId);
        return walletRepository.save(wallet);
    }
    
    @Transactional
    public void transfer(UUID fromId, UUID toId, BigDecimal amount) {
        Wallet from = walletRepository.findById(fromId)
            .orElseThrow(() -> new WalletNotFoundException(fromId));
        Wallet to = walletRepository.findById(toId)
            .orElseThrow(() -> new WalletNotFoundException(toId));
        
        from.debit(amount);
        to.credit(amount);
        
        walletRepository.saveAll(List.of(from, to));
    }
}