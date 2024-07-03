package pti.sb_treasurehunter_mvc.dto;

public class UserDto {
	
	private int id;
	private String name;
	private Integer recordSteps;
	private Boolean win;
	
	
	public UserDto(int id, String name, Integer recordSteps, Boolean win) {
		super();
		this.id = id;
		this.name = name;
		this.recordSteps = recordSteps;
		this.win = win;
	}
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getRecordSteps() {
		return recordSteps;
	}
	
	public void setRecordSteps(Integer recordSteps) {
		this.recordSteps = recordSteps;
	}
	
	public Boolean getWin() {
		return win;
	}
	
	public void setWin(Boolean win) {
		this.win = win;
	}
}
