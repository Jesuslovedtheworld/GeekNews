package com.example.lenovo.gmegeeknews.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.lenovo.gmegeeknews.bean.daobean.GeekCollectionDaoBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "GEEK_COLLECTION_DAO_BEAN".
*/
public class GeekCollectionDaoBeanDao extends AbstractDao<GeekCollectionDaoBean, Long> {

    public static final String TABLENAME = "GEEK_COLLECTION_DAO_BEAN";

    /**
     * Properties of entity GeekCollectionDaoBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Image = new Property(1, String.class, "image", false, "IMAGE");
        public final static Property Title = new Property(2, String.class, "title", false, "TITLE");
        public final static Property Content = new Property(3, String.class, "content", false, "CONTENT");
        public final static Property Spare_String = new Property(4, String.class, "spare_String", false, "SPARE__STRING");
        public final static Property Spare_int = new Property(5, String.class, "spare_int", false, "SPARE_INT");
    }


    public GeekCollectionDaoBeanDao(DaoConfig config) {
        super(config);
    }
    
    public GeekCollectionDaoBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"GEEK_COLLECTION_DAO_BEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"IMAGE\" TEXT," + // 1: image
                "\"TITLE\" TEXT," + // 2: title
                "\"CONTENT\" TEXT," + // 3: content
                "\"SPARE__STRING\" TEXT," + // 4: spare_String
                "\"SPARE_INT\" TEXT);"); // 5: spare_int
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"GEEK_COLLECTION_DAO_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, GeekCollectionDaoBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String image = entity.getImage();
        if (image != null) {
            stmt.bindString(2, image);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(3, title);
        }
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(4, content);
        }
 
        String spare_String = entity.getSpare_String();
        if (spare_String != null) {
            stmt.bindString(5, spare_String);
        }
 
        String spare_int = entity.getSpare_int();
        if (spare_int != null) {
            stmt.bindString(6, spare_int);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, GeekCollectionDaoBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String image = entity.getImage();
        if (image != null) {
            stmt.bindString(2, image);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(3, title);
        }
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(4, content);
        }
 
        String spare_String = entity.getSpare_String();
        if (spare_String != null) {
            stmt.bindString(5, spare_String);
        }
 
        String spare_int = entity.getSpare_int();
        if (spare_int != null) {
            stmt.bindString(6, spare_int);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public GeekCollectionDaoBean readEntity(Cursor cursor, int offset) {
        GeekCollectionDaoBean entity = new GeekCollectionDaoBean( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // image
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // title
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // content
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // spare_String
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5) // spare_int
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, GeekCollectionDaoBean entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setImage(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setTitle(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setContent(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setSpare_String(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setSpare_int(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(GeekCollectionDaoBean entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(GeekCollectionDaoBean entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(GeekCollectionDaoBean entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
