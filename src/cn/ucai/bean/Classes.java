package cn.ucai.bean;

import java.util.Arrays;

public class Classes {
	/** 表名 **/
	private String className;
	/** 一维数组存字段个数，二维数组存每个字段的类型和名称 **/
	private String[][] strArr;
	public Classes() {
		super();
	}
	public Classes(String className, String[][] strArr) {
		super();
		this.className = className;
		this.strArr = strArr;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		String result = "";
		for(int i=0;i<className.length();i++){
			if(i==0){
				result += (className.charAt(i)+"").toUpperCase();
			}else{
				result += className.charAt(i)+"";
			}
		}
		this.className = result;
	}
	public String[][] getStrArr() {
		return strArr;
	}
	public void setStrArr(String[][] strArr) {
		this.strArr = strArr;
	}
	@Override
	public String toString() {
		String toString = "";
		for(int i=0;i<strArr.length;i++){
			toString += " "+Arrays.toString(strArr[i]);
		}
		return "Classes [className=" + className + ", strArr=" + toString + "]";
	}
}
