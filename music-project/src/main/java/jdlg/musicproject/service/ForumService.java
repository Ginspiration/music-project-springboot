package jdlg.musicproject.service;

import jdlg.musicproject.entries.common.ForumAnswer;
import jdlg.musicproject.entries.common.ForumQuestion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ForumService {
    /**
     * 添加提问
     * @param
     * @return
     */
    String addForumQuestion(ForumQuestion forumQuestion);

    /**
     * 参与回答问题
     * @param
     * @return
     */
    String addForumAnswer(ForumAnswer answer);

    /**
     * 获取分页的提问id
     * @param cId
     * @param index
     * @param pageSize
     * @return
     */
    List<Integer> selectForumIdByCId(Integer cId,Integer index,Integer pageSize);

    /**
     * 通过课程id获取所有问题
     * @param cId
     * @return
     */
    List<ForumQuestion> queryForumQuestionByCId(Integer cId,Boolean homePageFlag,Integer qId,Integer indexAnswer,Integer answerPageSize);

    /**
     * 删除论题
     * @param queId
     * @return
     */
    String deleteForumByQuestionId(Integer queId);
}
