package com.atguigu.common;


public enum CountryEnum {

	ONE(1,"Æë"),TWO(2,"³þ"),THREE(3,"ÕÔ"),FOUR(4,"Ñà"),FIVE(5,"º«"),SIX(6,"Îº¹ú");
	
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
