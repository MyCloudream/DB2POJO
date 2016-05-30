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
	 * �����������ֶ���Ϣ����ʵ����
	 * @param className ����
	 * @param attrs �ֶ���Ϣ�������ֶε�������Ϣ���ֶ���
	 */
	public static void generateClass(String className,String[][] attrs){
		// ����Velocity����
		VelocityEngine ve = new VelocityEngine();
		//����ʼ������
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();
		// ����ģ��
		Template actionTpt = ve.getTemplate("BeanTemplate.vm");
		// ��������Я�����ݵ�VelocityContext;
		VelocityContext ctx = new VelocityContext();
		// ����������ģ��
		ctx.put("classNameUpCase", className);
		// ����ȫ�ι���������б�ģ��
		String result = "";
		for(int i=0;i<attrs.length;i++){
			result += attrs[i][0]+" "+attrs[i][1]+",";
		}
		ctx.put("allargs", result.substring(0,result.length()-1));
		// ����attrs���鵽ģ��
		ctx.put("attrs", attrs);
		PrintWriter pw;
		try {
			pw = new PrintWriter(new File("src/com/cloudream/pojo/"+className+".java"));
			// ����ģ�壬������ģ�廯֮��תΪWriter����
			actionTpt.merge(ctx, pw);
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * �����ݿ��ȡ���еı�ͱ��е��ֶ������ֶ�������Ϣ
	 * @return
	 */
	public static List<Classes> getClassesData(){
		List<Classes> claList = new ArrayList<Classes>();
		// ������ݿ�����
		Connection conn = SQLiteDBUtils.getConnection();
		try {
			DatabaseMetaData databaseMataDate = conn.getMetaData();
			// �õ����ݿ��е����б�
			ResultSet tabs = databaseMataDate.getTables(null, null, null, new String[] { "TABLE" });
			ResultSet rs = null;
			Statement st = null;
			while (tabs.next()) {// �������б�
				Classes cla = new Classes();
				// �õ�����
				String className = tabs.getObject("TABLE_NAME").toString();
				String lastClassName = getUpString(className.substring(className.lastIndexOf("_")+1));
				if(lastClassName.equalsIgnoreCase("Sequence")){
					continue;
				}
				cla.setClassName(lastClassName);
				String sql = "select * from "+tabs.getObject("TABLE_NAME");
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				// �õ����е��ֶ����ͺ��ֶ���
				ResultSetMetaData rsmd = rs.getMetaData();
				int colCount = rsmd.getColumnCount();
				String[][] strArr = new String[colCount][3];
				for (int i = 1; i <= colCount; i++) {
					// �õ���ӦJava�������͵�����
					strArr[i-1][0] =  getDataType(rsmd.getColumnTypeName(i),rsmd.getColumnName(i));
					// �õ��ֶ���
					strArr[i-1][1] =  getFieldName(rsmd.getColumnName(i));
					// �õ�����ĸ��д���ֶ���
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
	 * ���ݱ������ݿ���ص㣬�õ���Ӧ���ֶε������ֶ���
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
	 * ������ݿ��е��������͵�java�е��������͵�ת��
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
	 * ��String�ַ���������ĸ��Ϊ��д
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