package com.atguigu.common;


public enum CountryEnum {

	ONE(1,"��"),TWO(2,"��"),THREE(3,"��"),FOUR(4,"��"),FIVE(5,"��"),SIX(6,"κ��");
	
	private Integer code;
	private String msg;
	
	CountryEnum(Integer code,String msg){
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
	
	public static CountryEnum getEnum(int index) {
		CountryEnum[] values = CountryEnum.values();
		for (CountryEnum countryEnum : values) {
			if(countryEnum.getCode()==index) {
				return countryEnum;
			}
		}
		return null;
	}
}
