package com.lun.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.apache.struts2.ServletActionContext;
import com.lun.utils.WordUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @Desc������word
 */
@SuppressWarnings("serial")
public class WordAction  extends ActionSupport{

 private String filePath; //�ļ�·��
 private String fileName; //�ļ�����
 private String fileOnlyName; //�ļ�Ψһ����

 /**
  * @Desc������word�ĵ�
  * @return
  */
    public String createWo111rd() {
        /** ������װwordҳ����Ҫ������ */
        Map<String, Object> dataMap = new HashMap<String, Object>();
        
        /** ��װ���� */
        dataMap.put("userName","����");
        
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy��MM��dd��");
        dataMap.put("currDate",sdf.format(new Date()));
        
        dataMap.put("content","������������������������������������������������������������������������������������������������������������������������������������������������������������");
        
        List<Map<String, Object>> newsList=new ArrayList<Map<String,Object>>();
        for(int i=1;i<=10;i++){
         Map<String, Object> map=new HashMap<String, Object>();
         map.put("title", "����"+i);
         map.put("content", "����"+(i*2));
         map.put("author", "����"+(i*3));
         newsList.add(map);
        }
        dataMap.put("newsList",newsList);
        
        /** �ļ����ƣ�Ψһ�ַ��� */
        Random r=new Random();
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyyMMdd_HHmmss_SSS");
        StringBuffer sb=new StringBuffer();
        sb.append(sdf1.format(new Date()));
        sb.append("_");
        sb.append(r.nextInt(100));
        
        //�ļ�·��
        filePath=ServletActionContext.getServletContext().getRealPath("/")+"upload";
        
        //�ļ�Ψһ����
        fileOnlyName = "��freemarker������Word�ĵ�_"+sb+".doc";
        
        //�ļ�����
        fileName="��freemarker������Word�ĵ�.doc";
        
        /** ����word */
        WordUtil.createWord(dataMap, "news.ftl", filePath, fileOnlyName);
        
        return "createWordSuccess";
    }
    
    
 /**
  * @Desc���������ɵ�word�ĵ�����ڣ�������ת��struts XML����
  * @return
  */
    public String dowloadWord() {
        /** ���ж��ļ��Ƿ�������  */
        try {
         //�����������
         filePath = URLDecoder.decode(filePath, "UTF-8");
         fileOnlyName = URLDecoder.decode(fileOnlyName, "UTF-8");
         fileName = URLDecoder.decode(fileName, "UTF-8");
         
         //����ļ������ڣ���������쳣��Ȼ����Խ����쳣����
            new FileInputStream(filePath + File.separator +  fileOnlyName);
        } catch (Exception e) {
         e.printStackTrace();
         return "error";
        }
        return "dowloadWord";
    }
    
    /**
     * @Desc���������ɵ�word�ĵ�
     * �÷�����struts.xml�ļ��еģ� <param name="inputName">wordFile</param> ���Զ���Ӧ��get�������÷����Զ�����
     * @return �����������ɵ�word�ĵ� �ļ���
     */
    public InputStream getWordFile(){
        try {
         //�����������
         fileName = URLDecoder.decode(fileName, "UTF-8");
         
            /** �����������ɵ�word�ļ���  */
            return new FileInputStream(filePath + File.separator + fileOnlyName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


 public String getFilePath() {
  return filePath;
 }


 public void setFilePath(String filePath) {
  this.filePath = filePath;
 }


 public String getFileName() {
  return fileName;
 }


 public void setFileName(String fileName) {
  this.fileName = fileName;
 }


 public String getFileOnlyName() {
  return fileOnlyName;
 }


 public void setFileOnlyName(String fileOnlyName) {
  this.fileOnlyName = fileOnlyName;
 }

}