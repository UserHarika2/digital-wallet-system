@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InsufficientBalanceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleInsufficientBalance(InsufficientBalanceException e) {
        return new ErrorResponse("INSUFFICIENT_BALANCE", e.getMessage());
    }
    
    @ExceptionHandler(WalletNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleWalletNotFound(WalletNotFoundException e) {
        return new ErrorResponse("WALLET_NOT_FOUND", e.getMessage());
    }
}