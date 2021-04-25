package jdlg.musicproject.controller.doteacher;

import jdlg.musicproject.service.StudentService;
import jdlg.musicproject.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/doTeacher")
public class DoNews {
    @Resource(name = "studentServiceImpl")
    StudentService studentService;
    @Resource(name = "teacherServiceImpl")
    TeacherService teacherService;
}
