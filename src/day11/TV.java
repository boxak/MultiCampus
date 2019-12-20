package day11;

class TV{
	private String model;
	private int size;
	private int channel;
	public TV() {}
	public TV(String model,int size,int channel) {
		this.model=model;
		this.size=size;
		this.channel=channel;
	}
	
	public String getModel() {
		return model;
	}
	public int getSize() {
		return size;
	}
	public int getChannel() {
		return channel;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}
	public void channelUp() {
		channel=channel==10 ? 1 : channel+1;
	}
	public void channelDown() {
		channel=channel==1 ? 10 : channel-1;
	}
}
