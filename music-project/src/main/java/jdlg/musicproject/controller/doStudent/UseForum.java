package jdlg.musicproject.controller.doStudent;

import jdlg.musicproject.service.StudentService;
import jdlg.musicproject.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/doStudent")
public class UseForum {
    @Resource(name = "studentServiceImpl")
    StudentService studentService;
    @Resource(name = "teacherServiceImpl")
    TeacherService teacherService;
}
