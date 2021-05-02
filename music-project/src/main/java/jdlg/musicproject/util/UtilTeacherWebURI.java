package jdlg.musicproject.util;

public enum UtilTeacherWebURI {
    /**
     * -------------------网站地址--------------------------
     */
    basePathURL("http://localhost:8080/music_project_war_exploded/"),
    /**
     * -------------------新闻--------------------------
     */

    /**
     * -------------------学生--------------------------
     */
    /*禁用学生*/
    studentDisableUri("../teacher/stu/disable-student.jsp"),
    /*添加学生*/
    studentAddUri("../teacher/stu/add-student.jsp"),

    /**
     * -------------------课程--------------------------
     */
    /*添加课程*/
    coursesAddUri("../teacher/courses/add-course.jsp"),

    /**
     * -------------------论坛--------------------------
     */
    /**
     * -------------------学生自学基础--------------------------
     */
    multimediaBasicUri("../teacher/multimedia/basic-knowledge.jsp"),
    multimediaViewListen("../teacher/multimedia/view-listen.jsp"),
    /**
     * -------------------考核--------------------------
     */
    workAddUri("../teacher/examine/new-work.jsp"),
    workPreviousUri("../teacher/examine/previous-work.jsp"),
    ;
    private final String uri;

    UtilTeacherWebURI(String uri) {
        this.uri = uri;
    }

    public String getUri() {
        return this.uri;
    }
}
