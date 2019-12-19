package com.spring.project.common.enums;

/**
 * Created by HauKute on 12/20/2019.
 */
public enum StatusEnum {
	ACTIVE(1),
	DEACTIVE(0);

	StatusEnum(int value) {

		this.value = value;
	}

	public int getValue() {

		return value;
	}

	private int value;
}
