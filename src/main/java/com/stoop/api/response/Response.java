package com.stoop.api.response;

import java.util.ArrayList;
import java.util.List;

public class Response<T> {

	private T data;
	private List<T> listData;
	private List<String> errors;

	public Response() {
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<T> getListData() {
		if (this.listData == null) {
			this.listData = new ArrayList<T>();
		}
		return listData;
	}

	public void setListData(List<T> listData) {
		this.listData = listData;
	}

	public List<String> getErrors() {
		if (this.errors == null) {
			this.errors = new ArrayList<String>();
		}
		return errors;
	}

	public void setErros(List<String> errors) {
		this.errors = errors;
	}

}
