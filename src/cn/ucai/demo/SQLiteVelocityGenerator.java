package cn.ucai.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import cn.ucai.bean.Classes;
import cn.ucai.util.SQLiteDBUtils;

public class SQLiteVelocityGenerator {

public static void main(String[] args) {
	List<Classes> list = getClassesData();
	for(Classes cal : list){
		generateClass(cal.getClassName(),cal.getStrArr());
	}
}
	/**
	 * 根据类名和字段信息生成实体类
	 * @param className 类名
	 * @param attrs 字段信息，包括字段的类型信息和字段名
	 */
	public static void generateClass(String className,String[][] attrs){
		// 创建Velocity引擎
		VelocityEngine ve = new VelocityEngine();
		//　初始化环境
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();
		// 加载模板
		Template actionTpt = ve.getTemplate("BeanTemplate.vm");
		// 创建用于携带数据的VelocityContext;
		VelocityContext ctx = new VelocityContext();
		// 设置类名到模板
		ctx.put("classNameUpCase", className);
		// 设置全参构造参数名列表到模板
		String result = "";
		for(int i=0;i<attrs.length;i++){
			result += attrs[i][0]+" "+attrs[i][1]+",";
		}
		ctx.put("allargs", result.substring(0,result.length()-1));
		// 设置attrs数组到模板
		ctx.put("attrs", attrs);
		PrintWriter pw;
		try {
			pw = new PrintWriter(new File("src/com/cloudream/pojo/"+className+".java"));
			// 根据模板，将数据模板化之后转为Writer流。
			actionTpt.merge(ctx, pw);
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 从数据库获取所有的表和表中的字段名和字段类型信息
	 * @return
	 */
	public static List<Classes> getClassesData(){
		List<Classes> claList = new ArrayList<Classes>();
		// 获得数据库连接
		Connection conn = SQLiteDBUtils.getConnection();
		try {
			DatabaseMetaData databaseMataDate = conn.getMetaData();
			// 得到数据库中的所有表
			ResultSet tabs = databaseMataDate.getTables(null, null, null, new String[] { "TABLE" });
			ResultSet rs = null;
			Statement st = null;
			while (tabs.next()) {// 遍历所有表
				Classes cla = new Classes();
				// 得到表名
				String className = tabs.getObject("TABLE_NAME").toString();
				String lastClassName = getUpString(className.substring(className.lastIndexOf("_")+1));
				if(lastClassName.equalsIgnoreCase("Sequence")){
					continue;
				}
				cla.setClassName(lastClassName);
				String sql = "select * from "+tabs.getObject("TABLE_NAME");
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				// 得到所有的字段类型和字段名
				ResultSetMetaData rsmd = rs.getMetaData();
				int colCount = rsmd.getColumnCount();
				String[][] strArr = new String[colCount][3];
				for (int i = 1; i <= colCount; i++) {
					// 得到对应Java数据类型的类型
					strArr[i-1][0] =  getDataType(rsmd.getColumnTypeName(i),rsmd.getColumnName(i));
					// 得到字段名
					strArr[i-1][1] =  getFieldName(rsmd.getColumnName(i));
					// 得到首字母大写的字段名
					strArr[i-1][2] =  getUpString(rsmd.getColumnName(i));
				}
				cla.setStrArr(strArr);
				
				claList.add(cla);
			}
			tabs.close();
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return claList;
	}
	
	/**
	 * 根据本次数据库的特点，得到对应的字段的完整字段名
	 */
	public static String getFieldName(String fieldName){
		String[] strArr = fieldName.split("_");
		String result = strArr[0]+strArr[1];
		for(int i=2;i<strArr.length;i++){
			result +=getUpString(strArr[i]);
		}
		return result;
	}
	
	/**
	 * 完成数据库中的数据类型到java中的数据类型的转换
	 */
	public static String getDataType(String colName,String filedName){
		String result = "";
		if(filedName.contains("_is_")){
			result = "Boolean";
		}else{
			if(colName.equalsIgnoreCase("INT") || colName.equalsIgnoreCase("INTEGER")){
				result = "Integer";
			}else if(colName.equalsIgnoreCase("VARCHAR") || colName.equalsIgnoreCase("TEXT")){
				result = "String";
			}else if(colName.equalsIgnoreCase("FLOAT")){
				result = "Double";
			}
		}
		return result;
	}
	
	
	/**
	 * 将String字符串的首字母置为大写
	 */
	public static String getUpString(String str){
		String result = "";
		for(int i=0;i<str.length();i++){
			if(i==0){
				result += (str.charAt(i)+"").toUpperCase();
			}else{
				result += str.charAt(i)+"";
			}
		}
		return result;
	}
}