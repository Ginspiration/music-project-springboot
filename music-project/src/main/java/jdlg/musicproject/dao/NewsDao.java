package jdlg.musicproject.dao;

import jdlg.musicproject.entries.common.News;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsDao {

    /* x:查询所有新闻 */
    List<News> selectAllNews();

    /**
     * 根据标记查找新闻
     * @param newMark
     * @return
     */
    List<News> selectNewsByMark(@Param("new_mark")Integer newMark);



    /* x:根据新闻标题查找新闻 */
    News selectNewByTitle(@Param("new_title")String newTitle);

    /* x:添加新闻 */
    int addNew(News news);

    /* x:根据新闻标题删除新闻 */
    int deleteNew(@Param("newTitle")String newTitle);

    /* x:更新新闻 */
    int updateNew(News news);

}
