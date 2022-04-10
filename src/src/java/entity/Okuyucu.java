package entity;


public class Okuyucu {
    private User user;
    private int userid,haberid;

    public Okuyucu() {
    }
    

    public Okuyucu(int userid, int haberid) {
        this.userid = userid;
        this.haberid = haberid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getHaberid() {
        return haberid;
    }

    public void setHaberid(int haberid) {
        this.haberid = haberid;
    }
    
    
    
    
}
