package com.lun.utils;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;
import freemarker.template.Configuration;
import freemarker.template.Template;


/**
 * @Desc��word����������
 */
public class WordUtil {
   
/**
* @Desc������word�ļ�
* @param dataMap word����Ҫչʾ�Ķ�̬���ݣ���map����������
* @param templateName wordģ�����ƣ����磺test.ftl
* @param filePath �ļ����ɵ�Ŀ��·�������磺D:/wordFile/
* @param fileName ���ɵ��ļ����ƣ����磺test.doc
*/
    @SuppressWarnings("unchecked")
public static void createWord(Map dataMap,String templateName,String filePath,String fileName){
        try {
        //��������ʵ�� 
        Configuration configuration = new Configuration();
        
        //���ñ���
            configuration.setDefaultEncoding("UTF-8");
            
            //ftlģ���ļ�ͳһ���� com.lun.template ������
            configuration.setClassForTemplateLoading(WordUtil.class,"/com/lun/template/");
            
            //��ȡģ�� 
            Template template = configuration.getTemplate(templateName);
            
            //����ļ�
            File outFile = new File(filePath+File.separator+fileName);
            
            //������Ŀ���ļ��в����ڣ��򴴽�
            if (!outFile.getParentFile().exists()){
                outFile.getParentFile().mkdirs();
            }
            
            //��ģ�������ģ�ͺϲ������ļ� 
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile),"UTF-8"));


            //�����ļ�
            template.process(dataMap, out);
            
            //�ر���
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}