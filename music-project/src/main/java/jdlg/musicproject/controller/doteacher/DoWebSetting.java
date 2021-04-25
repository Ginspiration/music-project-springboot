package jdlg.musicproject.controller.doteacher;

import jdlg.musicproject.entries.web.WebManage;
import jdlg.musicproject.service.StudentService;
import jdlg.musicproject.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/doTeacher")
public class DoWebSetting {
    /*    @Resource(name = "studentServiceImpl")
        StudentService studentService;*/
    @Resource(name = "teacherServiceImpl")
    TeacherService teacherService;

    /*网站管理转发*/
    @RequestMapping("webManagement")
    public ModelAndView webManagement(HttpServletRequest request, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        WebManage message = teacherService.showWebMessage();
        session.setAttribute("webUsed", message.getWebUsed());
        session.setAttribute("webRegister", message.getRegistered());
        request.setAttribute("Context", "../teacher/webSetting/admin-web.jsp");
        mv.setViewName("index/index-teacher");
        return mv;
    }

    /*网站管理*/
    @RequestMapping(value = "webSubmit", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String webManagement(WebManage webManage) {
        String flag = "网站设置成功！";
        if (webManage.getRegistered() != null && webManage.getWebUsed() != null) {
            teacherService.setUpWeb(webManage);
        } else
            flag = "网站设置失败！";
        return flag;
    }
}
