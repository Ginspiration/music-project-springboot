package jdlg.musicproject.controller.doteacher;

import jdlg.musicproject.entries.common.ForumAnswer;
import jdlg.musicproject.entries.common.ForumQuestion;
import jdlg.musicproject.service.ForumService;
import jdlg.musicproject.service.StudentService;
import jdlg.musicproject.service.TeacherService;
import jdlg.musicproject.util.UtilTeacherWebURI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/doTeacher")
public class DoForum {
    @Resource(name = "studentServiceImpl")
    StudentService studentService;
    @Resource(name = "teacherServiceImpl")
    TeacherService teacherService;
    @Autowired
    private ForumService forumService;

    @GetMapping("/indexForum")
    public ModelAndView indexForum(Model model) {
        model.addAttribute("Context", UtilTeacherWebURI.forumTeacher.getUri());
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index/index-teacher");
        return mv;
    }

    @PostMapping("/showQuestion")
    @ResponseBody
    public List<ForumQuestion> showQuestion(Integer cId, Integer qId, Integer indexAnswer, Integer answerPageSize) {
        return forumService.queryForumQuestionByCId(cId, true,qId, indexAnswer, answerPageSize);
    }

    @PostMapping("/showQueIdByCid")
    @ResponseBody
    public List<Integer> showQueIdByCid(Integer cId,Integer index,Integer pageSize){
        return forumService.selectForumIdByCId(cId, index, pageSize);
    }
}
