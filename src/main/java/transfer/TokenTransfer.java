package transfer;

public class TokenTransfer {

	private final long userId;
	private final String token;

	public TokenTransfer(long userId, String token) {
		super();
		this.userId = userId;
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public long getUserId() {
		return userId;
	}

}
