package jdlg.musicproject.controller.doteacher;

import jdlg.musicproject.service.NewsService;
import jdlg.musicproject.service.StudentService;
import jdlg.musicproject.service.TeacherService;
import jdlg.musicproject.util.UtilTeacherWebURI;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/doTeacher")
public class DoNews {
    @Resource(name = "studentServiceImpl")
    StudentService studentService;
    @Resource(name = "teacherServiceImpl")
    TeacherService teacherService;
    @Resource(name = "newsServiceImpl")
    private NewsService newsService;

    //  x:转发添加新闻页面
    @GetMapping("/showAddNews")
    public ModelAndView showAddNews(HttpServletRequest request, HttpSession session){
        ModelAndView mv = new ModelAndView();
        request.setAttribute("Context", UtilTeacherWebURI.teacherAddNewUri.getUri());
        String myWebUrl = System.getProperty("MyWebUrl");
        System.out.println(myWebUrl);
        mv.setViewName("index/index-teacher");
        return mv;
    }

    /*
     * tips:file必须放在第一个
     * */

    /**
     * x
     * 返回
     * 添加新闻
     * @param file
     * @param title
     * @param context
     * @param marked
     * @return
     */
    @ResponseBody
    @PostMapping("/addNews")
    public int  addNews(@RequestParam("files") CommonsMultipartFile[] file,
                        String title, String context, String marked, HttpServletRequest request){

        //文件上传
        //上传路径保存设置
        String path = request.getSession().getServletContext().getRealPath("/static/newsImg");
        File realPath = new File(path);
        if (!realPath.exists()){
            realPath.mkdir();
        }
        //上传文件地址并保存realPath
        System.out.println("上传文件保存地址："+realPath);

        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        for(int i = 0; i < file.length ; i++){
            MultipartFile file1 = file[i];
            try {
                file1.transferTo(new File(realPath +"/"+ file[i].getOriginalFilename()));
            } catch (IOException e) {
                return 1001; //返回1001：文件上传失败
            }
        }



        return 1000;
    }

}
