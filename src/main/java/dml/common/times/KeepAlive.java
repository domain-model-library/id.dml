package dml.common.times;

public class KeepAlive {
	private long lastActiveTime;
	private long maxIdleTime;

	public boolean checkAlive(long currTime) {
		return (currTime - lastActiveTime) <= maxIdleTime;
	}

	public void activate(long currTime) {
		lastActiveTime = currTime;
	}

	public long getLastActiveTime() {
		return lastActiveTime;
	}

	public void setLastActiveTime(long lastActiveTime) {
		this.lastActiveTime = lastActiveTime;
	}

	public long getMaxIdleTime() {
		return maxIdleTime;
	}

	public void setMaxIdleTime(long maxIdleTime) {
		this.maxIdleTime = maxIdleTime;
	}

}
