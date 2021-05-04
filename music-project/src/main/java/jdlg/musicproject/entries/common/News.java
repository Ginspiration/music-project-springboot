package jdlg.musicproject.entries.common;

public class News {

    private Integer id;
    private String newTitle;
    private String newContext;
    private String newImgUrl;
    private Integer newMark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNewMark() {
        return newMark;
    }

    @Override
    public String toString() {
        return "News{" +
                "newTitle='" + newTitle + '\'' +
                ", newContext='" + newContext + '\'' +
                ", newImgUrl='" + newImgUrl + '\'' +
                ", newMark='" + newMark + '\'' +
                '}';
    }

    public void setNewMark(Integer newMark) {
        this.newMark = newMark;
    }

    public String getNewTitle() {
        return newTitle;
    }

    public void setNewTitle(String newTitle) {
        this.newTitle = newTitle;
    }

    public String getNewContext() {
        return newContext;
    }

    public void setNewContext(String newContext) {
        this.newContext = newContext;
    }

    public String getNewImgUrl() {
        return newImgUrl;
    }

    public void setNewImgUrl(String newImgUrl) {
        this.newImgUrl = newImgUrl;
    }

}
