package Model;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.LocalDateTime;


public class NhanVien {
    private String id;
    private String fist_Name;
    private String last_Name;
    private String nick_Name;
    private boolean is_deleted;
    private Timestamp created_At;
    private Timestamp updated_At;

    public NhanVien() {
    }

    public NhanVien(String id, String fist_Name, String last_Name, String nick_Name, Timestamp created_At ) {
        this.id = id;
        this.fist_Name = fist_Name;
        this.last_Name = last_Name;
        this.nick_Name = nick_Name;
        this.created_At = created_At;
    }

    public NhanVien(String id, String fist_Name, String last_Name, String nick_Name, boolean is_deleted, Timestamp created_At, Timestamp updated_At) {
        this.id = id;
        this.fist_Name = fist_Name;
        this.last_Name = last_Name;
        this.nick_Name = nick_Name;
        this.is_deleted = is_deleted;
        this.created_At = created_At;
        this.updated_At = updated_At;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFist_Name() {
        return fist_Name;
    }

    public void setFist_Name(String fist_Name) {
        this.fist_Name = fist_Name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public String getNick_Name() {
        return nick_Name;
    }

    public void setNick_Name(String nick_Name) {
        this.nick_Name = nick_Name;
    }

    public boolean getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(boolean is_deleted) {
        this.is_deleted = is_deleted;
    }

    public void setCreated_At(Timestamp created_At) {
        this.created_At = created_At;
    }

    public void setUpdated_At(Timestamp updated_At) {
        this.updated_At = updated_At;
    }

    public Timestamp getCreated_At() {
        return created_At;
    }

    public Timestamp getUpdated_At() {
        return updated_At;
    }

    public String thongTinNhanVien() {
        return "Nhanvien{" +
                "ID= '" + id + ", Full name= '" + fist_Name + " " + last_Name +", nick_Name= '" + nick_Name + '\'' +
                ", is_deleted=" + is_deleted + ", created_At=" + created_At + ", updated_At=" + updated_At + '}';
    }
}
