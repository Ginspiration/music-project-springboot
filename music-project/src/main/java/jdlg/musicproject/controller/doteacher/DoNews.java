package jdlg.musicproject.controller.doteacher;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sun.org.apache.xpath.internal.operations.Mod;
import jdlg.musicproject.entries.common.News;
import jdlg.musicproject.service.NewsService;
import jdlg.musicproject.service.StudentService;
import jdlg.musicproject.service.TeacherService;
import jdlg.musicproject.util.UtilTeacherWebURI;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        mv.setViewName("index/index-teacher");
        return mv;
    }

    /**
     * 添加新闻
     * @param file
     * @param title
     * @param context
     * @param marked
     * @return
     * tips:file必须放在第一个
     */
    @ResponseBody
    @PostMapping("/addNews")
    public int  addNews(@RequestParam("files") CommonsMultipartFile[] file,
                        String title, String context, String marked, HttpServletRequest request){

        /*文件上传*/
        //上传路径保存设置
        String path = request.getSession().getServletContext().getRealPath("/static/newsImg");
        File filePath = new File(path);
        if (!filePath.exists()){
            filePath.mkdir();
        }
        //上传文件地址并保存realPath
        System.out.println("上传文件保存地址："+filePath);

        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        for(int i = 0; i < file.length ; i++){
            MultipartFile file1 = file[i];
            try {
                File file2 = new File(filePath + "/" + file[i].getOriginalFilename());
                file1.transferTo(file2);
            } catch (IOException e) {
                return 1001; //返回1001：文件上传失败
            }
        }

        /*对象存储信息*/
        News news = new News();
        news.setNewContext(context);
        //存储标题前，需先查找是否有重复标题
        List<News> getTitleList = newsService.selectAllNews();
        for (News news1 : getTitleList) {
            if( news1.getNewTitle().equals(title) ){
                System.out.println(news1.getNewTitle());
                System.out.println(title);
                return 1002;    //返回错误：标题重复
            }
        }
        news.setNewTitle(title);
        //对于文件路径，需循环保存，且为webapp的相对地址realPath。分隔符为&*&
        String realPath = "static/newsImg/";
        String url = "";
        for (int i = 0;i < file.length; i++){
            if( i < file.length-1){
                url += realPath + file[i].getOriginalFilename() + "&*&";
            }else
                url += realPath + file[i].getOriginalFilename();
            System.out.println(url);
        }
        //文件路径转义
        url = url.replace("\\", "\\\\");
        news.setNewImgUrl(url);
        //判断marked
        if(marked == "marked")
            news.setNewMark(1);
        else
            news.setNewMark(0);
        System.out.println(news);
        newsService.addNew(news);
        return 1000;
    }


    /**
     * 查看新闻跳转
     * @param model
     * @param request
     * @param session
     * @return
     */
    @GetMapping("viewNews")
    public ModelAndView viewNews(Model model, HttpServletRequest request,HttpSession session){
        ModelAndView mv = new ModelAndView();
        request.setAttribute("Context", UtilTeacherWebURI.teacherViewNews.getUri());

        /*需先查找所有新闻并传送前端*/
        //使用pagehelper分页获取
        Page<Object> page = PageHelper.startPage(1,5);
        List<News> newsList = newsService.selectAllNews();

        //获取总页数
        int totalPage = page.getPages();
        //获取当前页
        int nowPage = page.getPageNum();

//        session设置会话
        session.setAttribute("nowPage",nowPage);

        session.setAttribute("totalPage", totalPage);

        session.setAttribute("news",newsList);


//        model.addAttribute("nowPage",nowPage);
//        model.addAttribute("totalpage", totalpage);
//        model.addAttribute("news",newsList);


        mv.setViewName("index/index-teacher");
        return mv;
    }

    /**
     * 页面改变并跳转
     * @param nowPage       当前页
     * @param updatePage    更新页
     * @param model
     * @param request
     * @param session
     * @return
     */
    @GetMapping("turnPage")
    public ModelAndView aPage(int nowPage, int updatePage,
                              Model model,HttpServletRequest request,
                              HttpSession session){
        System.out.println(nowPage + updatePage);
        //求出跳转页数
        nowPage = nowPage + updatePage;

        /*查找对应新闻并传送前端*/
        //使用pagehelper分页获取
        Page<Object> page = PageHelper.startPage(nowPage,5);
        List<News> newsList = newsService.selectAllNews();

        //获取总页数
        int totalpage = page.getPages();
        //获取当前页
        nowPage = page.getPageNum();

        session.removeAttribute("nowPage");
        session.setAttribute("nowPage",nowPage);

        session.removeAttribute("totalpage");
        session.setAttribute("totalpage", totalpage);

        session.removeAttribute("news");
        session.setAttribute("news",newsList);

        ModelAndView mv = new ModelAndView();
        request.setAttribute("Context", UtilTeacherWebURI.teacherViewNews.getUri());
        mv.setViewName("index/index-teacher");
        return mv;
    }


    /*新闻详情跳转*/
    @RequestMapping("/newsDetail")
    public ModelAndView newsDetail(String newTitle,HttpServletRequest request,
                                   HttpSession session){
        ModelAndView mv = new ModelAndView();
        request.setAttribute("Context", UtilTeacherWebURI.teacherViewNewsDetail.getUri());

        //获取新闻对象
        News news = newsService.selectNewByTitle(newTitle);

        session.removeAttribute("news");
        session.setAttribute("news",news);

        mv.setViewName("index/index-teacher");
        return mv;
    }

}
