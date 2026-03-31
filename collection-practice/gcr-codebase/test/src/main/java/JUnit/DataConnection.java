package JUnit;

public class DataConnection {
	private boolean connect = false;

	public void connect() {
		connect = true;
	}

	public void disconnect() {
		connect = false;
	}

	public boolean isConnected() {
		return connect;
	}
}
