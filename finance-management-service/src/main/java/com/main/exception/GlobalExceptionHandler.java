package com.main.exception;


import java.util.HashMap;
import java.util.Map;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(BudgetNotFoundException.class)
    public ResponseEntity<Object> handleBudgetNotFoundException(BudgetNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BudgetAlreadyExistsException.class)
    public ResponseEntity<Object> handleBudgetAlreadyExistsException(BudgetAlreadyExistsException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(InvalidBudgetException.class)
    public ResponseEntity<Object> handleInvalidBudgetException(InvalidBudgetException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvalidGoalException.class)
    public ResponseEntity<Object> handleInvalidGoalException(InvalidGoalException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(GoalNotFoundException.class)
    public ResponseEntity<Object> handleGoalNotFoundException(GoalNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(RemainingAmountException.class)
    public ResponseEntity<Object> handleRemainingAmountException(RemainingAmountException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGlobalException(Exception ex, WebRequest request) {
        return new ResponseEntity<>("An error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

	@ExceptionHandler(TransactionNotFoundException.class)
	public ResponseEntity<Object> handleTransactionNotFoundException(TransactionNotFoundException ex, WebRequest request)
	{
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(InsufficientBalanceException.class)
	public ResponseEntity<Object> handleInsufficientBalanceException(InsufficientBalanceException ex, WebRequest request)
	{
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(DebtCreateFailedException.class)
	public ResponseEntity<Object> handleDebtCreateFailedException(DebtCreateFailedException ex, WebRequest request)
	{
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(DebtFetchFailedException.class)
	public ResponseEntity<Object> handleDebtFetchFailedException(DebtFetchFailedException ex, WebRequest request)
	{
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(DebtUpdateFailedException.class)
	public ResponseEntity<Object> handleDebtUpdateFailedException(DebtUpdateFailedException ex, WebRequest request)
	{
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(DebtDeleteFailedException.class)
	public ResponseEntity<Object> handleDebtDeleteFailedException(DebtDeleteFailedException ex, WebRequest request)
	{
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(TransactionCreateFailedException.class)
	public ResponseEntity<Object> handleTransactionCreateFailedException(TransactionCreateFailedException ex, WebRequest request)
	{
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(TransactionFetchFailedException.class)
	public ResponseEntity<Object> handleTransactionFetchFailedException(TransactionFetchFailedException ex, WebRequest request)
	{
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> handleMethodArgsNotValidException(MethodArgumentNotValidException mex){
		Map<String, String> resp = new HashMap<String, String>();
		mex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError)error).getField();
			String message = error.getDefaultMessage();
			resp.put(fieldName, message);			
		});
		
		return new ResponseEntity<Map<String,String>>(resp,HttpStatus.NOT_ACCEPTABLE);
	}
	
	
}

