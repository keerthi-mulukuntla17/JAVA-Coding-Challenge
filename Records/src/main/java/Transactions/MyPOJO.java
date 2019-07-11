package Transactions;

import java.time.LocalDateTime;

public class MyPOJO {
	private String transactionId;
    private String fromAccountId;
    private String toAccountId;
    private LocalDateTime createdAt;
    private double amount;
    private String transactionType;
    private String relatedTransaction;
	
    public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getFromAccountId() {
		return fromAccountId;
	}
	public void setFromAccountId(String fromAccountId) {
		this.fromAccountId = fromAccountId;
	}
	public String getToAccountId() {
		return toAccountId;
	}
	public void setToAccountId(String toAccountId) {
		this.toAccountId = toAccountId;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getRelatedTransaction() {
		return relatedTransaction;
	}
	public void setRelatedTransaction(String relatedTransaction) {
		this.relatedTransaction = relatedTransaction;
	}

    
	 @Override
	    public String toString() {
	        return "TransactionId=" + transactionId + ", FromAccountId=" + fromAccountId + " , ToAccountId=" + toAccountId + ", CreatedAt=" + createdAt + ", Amount=" + amount + ", TransactionType= " + transactionType + ", RelatedTransaction=" + relatedTransaction;
	    }



}