package jdlg.musicproject.controller.doteacher;

import jdlg.musicproject.entries.common.Register;
import jdlg.musicproject.entries.common.Seek;
import jdlg.musicproject.entries.student.Student;
import jdlg.musicproject.entries.student.StudentAdmin;
import jdlg.musicproject.entries.student.StudentNamePwd;
import jdlg.musicproject.service.StudentService;
import jdlg.musicproject.service.TeacherService;
import jdlg.musicproject.util.UtilTeacherWebURI;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/doTeacher")
public class DoStudentManage {
    @Resource(name = "studentServiceImpl")
    StudentService studentService;
    @Resource(name = "teacherServiceImpl")
    TeacherService teacherService;

    /*跳转添加学生*/
    @RequestMapping("/addStudent")
    public ModelAndView addStudent(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        request.setAttribute("Context", UtilTeacherWebURI.studentAddUri.getUri());
        mv.setViewName("index/index-teacher");
        return mv;
    }

    /*添加学生*/
    @Transactional
    @RequestMapping(value = "/regStudent", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String regStudent(Register register) {
        //System.out.println("方法调用");
        String flag = "学生添加成功！";
        if (register.getsRegName() != null && register.getsRegNumber() != null && register.getsRegPwd() != null) {
            StudentNamePwd res = studentService.stuLoginById(register.getsRegNumber());
            if (res == null) {
                Student student = new Student();
                /*插入基本信息*/
                student.setStudent_id(register.getsRegNumber());
                student.setStudent_name(register.getsRegName());
                /*插入账号密码*/
                StudentAdmin studentAdmin = new StudentAdmin();
                studentAdmin.setAdmin_stu_id(register.getsRegNumber());
                studentAdmin.setStudent_pwd(register.getsRegPwd());
                /*返回两条记录*/
                studentService.addStudent(student);
                studentService.regStudent(studentAdmin);
            } else
                flag = "该生已存在！";
        } else
            flag = "学生添加失败！";
        //response.setCharacterEncoding("text/html;charset=utf-8");
        return flag;
    }

    /*跳转禁用学生*/
    @RequestMapping(value = "/unusedStudent")
    public ModelAndView disablesStudent(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        request.setAttribute("Context", UtilTeacherWebURI.studentDisableUri.getUri());
        mv.setViewName("index/index-teacher");
        return mv;
    }

    /*禁用学生*/
    @Transactional
    @RequestMapping(value = "/disableStudent", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String disableStudent(Seek seek) {
        String flag = "禁用成功！";
        if (seek.getSeekId() != null) {
            teacherService.disableStudent(seek.getSeekId());
        } else
            flag = "禁用失败！";
        return flag;
    }

    /*启用学生*/
    @Transactional
    @RequestMapping(value = "/ableStudent", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String ableStudent(Seek seek) {
        String flag = "启用成功！";
        if (seek.getSeekId() != null) {
            teacherService.ableStudent(seek.getSeekId());
        } else
            flag = "启用失败！";
        return flag;
    }
}
