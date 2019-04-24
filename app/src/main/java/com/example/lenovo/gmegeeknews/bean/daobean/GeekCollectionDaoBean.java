package com.example.lenovo.gmegeeknews.bean.daobean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class GeekCollectionDaoBean {
    
    @Id(autoincrement = true)
    private Long id;

    @Property
    private String image;

    @Property
    private String title;

    @Property
    private String content;

    @Property
    private String spare_String;

    @Property
    private String spare_int;

    @Generated(hash = 742438993)
    public GeekCollectionDaoBean(Long id, String image, String title,
            String content, String spare_String, String spare_int) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.content = content;
        this.spare_String = spare_String;
        this.spare_int = spare_int;
    }

    @Generated(hash = 1175151269)
    public GeekCollectionDaoBean() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSpare_String() {
        return this.spare_String;
    }

    public void setSpare_String(String spare_String) {
        this.spare_String = spare_String;
    }

    public String getSpare_int() {
        return this.spare_int;
    }

    public void setSpare_int(String spare_int) {
        this.spare_int = spare_int;
    }

    @Override
    public String toString() {
        return "GeekCollectionDaoBean{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", spare_String='" + spare_String + '\'' +
                ", spare_int='" + spare_int + '\'' +
                '}';
    }
}
