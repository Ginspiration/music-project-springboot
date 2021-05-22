package student;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import jdlg.musicproject.dao.ForumDao;
import jdlg.musicproject.dao.NewsDao;
import jdlg.musicproject.entries.common.QuestionBank;
import jdlg.musicproject.entries.student.StudentNamePwd;
import jdlg.musicproject.entries.teacher.TeacherKnowledge;
import jdlg.musicproject.entries.teacher.TeacherRegister;
import jdlg.musicproject.service.AdminService;
import jdlg.musicproject.service.StudentService;
import jdlg.musicproject.service.TeacherService;
import jdlg.musicproject.service.TeacherServiceMultimedia;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TestStudent {
    @Test
    public void insertTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
/*        StudentService service = (StudentService)ctx.getBean("studentServiceImpl");
        Student student = new Student();
        student.setStudent_id(1);
        student.setStudent_name("高云");
        int res = service.addStudent(student);
        System.out.println("是否成功"+res);*/
        String names[] = ctx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

    @Test
    public void test01() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService service = (StudentService) ctx.getBean("studentServiceImpl");
        StudentNamePwd message = service.stuLoginById(1);
        System.out.println(message);
    }

    @Test
    public void test02() {
        try {
            // 使用基本编码
            String str1 = "aa aa";
            String str = str1.replace(" ", "+");
            System.out.println(str);
            String strName = Base64.getEncoder().encodeToString(str.getBytes("utf-8"));
            System.out.println("加密后" + strName);

            // 解码
            byte[] res2 = Base64.getDecoder().decode(strName);
            System.out.println("原始字符串: " + new String(res2, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            System.out.println("Error :" + e.getMessage());
        }
    }

    @Test
    public void test04() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        TeacherService service = (TeacherService) ctx.getBean("teacherServiceImpl");
        System.out.println(service.ableStudent(2018001));
    }

    @Test
    public void test05() {
        String str = "选b*&*aaaaaaaaaaaaaaaaaaaaaaa*&*bbbbbb*&*ccccccccccccccccccccc*&*dddddddddddddddddd";

        String[] strs = str.split("\\*&\\*");

        for (int i = 0; i < strs.length; i++) {
            System.out.println(i + strs[i].toString());
        }
    }

    @Test
    public void test06() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        TeacherService service = (TeacherService) ctx.getBean("teacherServiceImpl");
        List<QuestionBank> banks = service.showQuestionsByIndex(20180906, 1, 1, 2);
        System.out.println(banks);
    }

    @Test
    public void test07() {
        float x = 100;
        int y = 9;
        System.out.println((x / y));
        float a = 123.2334f;
        System.out.println(Math.round(a * 100));
        float b = (float) (Math.round(a * 10)) / 10;//(这里的100就是2位小数点,如果要其它位,如4位,这里两个100改成10000)
        System.out.println(b);
    }

    /*测试学生音乐基础知识学习*/
    @Test
    public void test08() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        TeacherServiceMultimedia serviceMultimedia = (TeacherServiceMultimedia) ctx.getBean("teacherServiceMultimediaImpl");
        /*添加*/
//        TeacherKnowledge knowledge = new TeacherKnowledge();
//        knowledge.setTitle("标题四");
//        knowledge.setContext("内容二");
//        knowledge.setCourseId(20180906);
//        knowledge.setImgUrl("Url1");
//        String str = serviceMultimedia.addKnow(knowledge);
//        System.out.println(str);

        /*删除*/
//        String  str = serviceMultimedia.deleteKnow("标题四",20180906);
//        System.out.println(str);

        /*更新*/
//        TeacherKnowledge knowledge = new TeacherKnowledge();
//        knowledge.setTitle("标题三");
//        knowledge.setContext("内容三");
//        knowledge.setCourseId(20180906);
//        knowledge.setImgUrl("Url3");
//        String str = serviceMultimedia.modifyKnow(knowledge);
//        System.out.println(str);

        /*查找*/
        List<TeacherKnowledge> ks = serviceMultimedia.findKnow("%一%", 20180906);
        for (TeacherKnowledge k : ks) {
            System.out.println(k);
        }
        /*显示所有*/
        List<TeacherKnowledge> ks2 = serviceMultimedia.showAllKnow(201809006);
        for (TeacherKnowledge k : ks2) {
            System.out.println(k);
        }
    }

    @Test
    public void test09() {
        Date date = new Date();
        System.out.println(date.getTime());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = format.format(date);
        System.out.println(str);
    }

    @Test
    public void test10() throws IOException {
//当前项目下路径
        File file = new File("");
        String filePath = file.getCanonicalPath();
        System.out.println(System.getProperty("java.class.path"));

    }

    @Test
    public void test11() {
        Map<Integer, Character> map = new TreeMap<>();
        map.put(2, 'a');
        map.put(1, 'c');
        map.put(3, 'b');
        for (Map.Entry<Integer, Character> node : map.entrySet()) {
            System.out.println(node);
        }
    }

    @Test
    public void test12() {
        List<Integer> a = new ArrayList<>();
        a.add(3);
        a.add(2);
        a.add(1);
        a.add(4);
        for (Integer b : a) {
            System.out.println(b);
        }
        Integer i = null;
        System.out.println(i.intValue());
    }

    @Test
    public void test13() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        TeacherServiceMultimedia multimedia = (TeacherServiceMultimedia) ctx.getBean("teacherServiceMultimediaImpl");
        multimedia.deleteKnow("测试7", 20180906, 2011001);
    }
    @Test
    public void test14() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ForumDao forumDao = (ForumDao)ctx.getBean("forumDao");
        System.out.println(forumDao.selectForumQuestionByCId(20190306,null,2,10,10));
        System.out.println("----------------------------------");
        //System.out.println(forumDao.selectForumIdByCId(20180309,0,2));
    }
    @Test
    public void test15(){
        File file = new File("D://test4.xls");
        if(file.isFile()){
            file.delete();
        }
        System.out.println("success");

    }
}