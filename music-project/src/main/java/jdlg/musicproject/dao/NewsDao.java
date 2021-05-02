package jdlg.musicproject.dao;

import jdlg.musicproject.entries.common.News;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsDao {

    /* x:查询所有新闻 */
    List<News> selectAllNew();

    /* x:根据新闻标题查找新闻 */
    List<News> selectNewByTitle(@Param("new_title")String newTitle);

    /* x:添加新闻 */
    int addNew(News news);

    /* x:根据新闻id删除新闻 */
    int deleteNew(@Param("id")Integer id);

    /* x:更新新闻 */
    int updateNew(News news);

}
