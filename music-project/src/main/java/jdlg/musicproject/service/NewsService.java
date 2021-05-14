package jdlg.musicproject.service;

import jdlg.musicproject.entries.common.News;

import java.util.List;

public interface NewsService {

    /* x:查询所有新闻 */
    List<News> selectAllNews();

    /* x:根据新闻标题查找新闻 */
    News selectNewByTitle(String newTitle);

    /* x:添加新闻 */
    int addNew(News news);

    /* x:根据新闻标题删除新闻 */
    int deleteNew(String newTitle);

    /* x:更新新闻 */
    int updateNew(News news);

}
