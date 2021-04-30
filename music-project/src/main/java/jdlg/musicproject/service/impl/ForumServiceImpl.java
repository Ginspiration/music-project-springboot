package jdlg.musicproject.service.impl;

import jdlg.musicproject.dao.ForumDao;
import jdlg.musicproject.entries.common.ForumAnswer;
import jdlg.musicproject.entries.common.ForumQuestion;
import jdlg.musicproject.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForumServiceImpl implements ForumService {

    @Autowired
    private ForumDao forumDao;

    private static final String success = "提问成功！";
    private static final String answer = "参与讨论成功！";
    private static final String systemError = "系统错误,请重试";
    private static final String delete = "删除成功！";

    @Override
    public String addForumQuestion(ForumQuestion forumQuestion) {
        if (!forumQuestion.equals(null)) {
            if (forumDao.insertForumQuestion(forumQuestion) != 1)
                return systemError;
            else
                return success;
        } else
            return systemError;
    }

    @Override
    public String addForumAnswer(ForumAnswer answer) {
        if (!answer.equals(null)) {
            if (forumDao.insertForumAnswer(answer) != 1)
                return systemError;
            else
                return this.answer;
        } else
            return systemError;
    }

    @Override
    public List<Integer> selectForumIdByCId(Integer cId, Integer index, Integer pageSize) {
        if (cId != null && index != null && pageSize != null) {
            return forumDao.selectForumIdByCId(cId, index, pageSize);
        } else
            return null;
    }

    @Override
    public List<ForumQuestion> queryForumQuestionByCId(Integer cId,Boolean homePageFlag,Integer qId , Integer indexAnswer, Integer answerPageSize) {
        if (cId != null && qId != null && indexAnswer != null && answerPageSize != null) {
            return forumDao.selectForumQuestionByCId(cId,homePageFlag, qId, indexAnswer, answerPageSize);
        } else
            return null;
    }

    @Override
    public String deleteForumByQuestionId(Integer queId) {
        if (queId != null) {
            if (forumDao.deleteForumByQuestionId(queId) != 1)
                return systemError;
            else
                return delete;
        } else
            return systemError;
    }
}
