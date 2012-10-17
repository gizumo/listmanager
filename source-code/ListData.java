package jp.listmanager;

import java.io.Serializable;

public class ListData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String listname;
	private String tag;
	private String item[];

	public String getListName() {
		return listname;
	}

	public void setListName(String listname) {
		this.listname = listname;
	}
	
	public String getTag(){
		return tag;
	}
	
	public void setTag(String tag){
		this.tag = tag;
	}

	public String[] getItem() {
		return item;
	}

	public void setTel(String[] item) {
		this.item = item;
	}

}
