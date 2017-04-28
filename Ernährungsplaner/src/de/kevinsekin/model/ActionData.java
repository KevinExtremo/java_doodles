package de.kevinsekin.model;

public class ActionData 
{
	private String Index;
	private Object Data;
	public ActionData(String Index, Object Data)
	{
		this.Index = Index;
		this.Data = Data;
	}
	public String getIndex() {
		return Index;
	}
	public void setIndex(String index) {
		Index = index;
	}
	public String getData() {
		return Data.toString();
	}
	public void setData(Object data) {
		Data = data;
	}
	public Object getRawData()
	{
		return Data;
	}
}
