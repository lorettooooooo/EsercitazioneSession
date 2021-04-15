package it.objectmethod.esercitazionesession.domain;

public class ToDoObject {
	private String name;
	private int id;
	private boolean isDone;

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setIsDone(boolean isDone) {
		this.isDone= isDone;
	}
	public boolean getIsDone() {
		return isDone;
	}
	
	public void setid(int id) {
		this.id= id;
	}
	
	public int getid() {
		return id;
	}

}
