package com.db.assignment.trade.exception;

public class NotValidTradeException extends RuntimeException {

	private final String id;

	public NotValidTradeException(final String id) {
		super("NotValid Trade: " + id);
		this.id = id;
	}

	public String getId() {
		return id;
	}
}
