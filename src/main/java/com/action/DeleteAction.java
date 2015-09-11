package com.action;
import com.service.HandleService;

public class DeleteAction{

	public HandleService handleServiceImp;
	private short id;
	public HandleService getHandleServiceImp() {
		return handleServiceImp;
	}
	public void setHandleServiceImp(HandleService handleServiceImp) {
		this.handleServiceImp = handleServiceImp;
	}
	public short getId() {
		return id;
	}
	public void setId(short id) {
		this.id = id;
	}


	public String delete(){
		handleServiceImp.delete(id);
		return "success";

	}



}
