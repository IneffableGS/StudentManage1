package project.obj;

public class Score {
    private int sno;
    private String sname;
    private int cno;
    private String cname;

    private String cdate;
    private String cteacher;
    private int score;

    public Score(int sno, String sname, int cno, String cname, String cdate, String cteacher, int score) {
        this.sno = sno;
        this.sname = sname;
        this.cno = cno;
        this.cname = cname;
        this.cdate = cdate;
        this.cteacher = cteacher;
        this.score = score;
    }

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }

    public String getCteacher() {
        return cteacher;
    }

    public void setCteacher(String cteacher) {
        this.cteacher = cteacher;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "cno=" + cno +
                ", cname='" + cname + '\'' +
                ", sno=" + sno +
                ", sname='" + sname + '\'' +
                ", cdate='" + cdate + '\'' +
                ", cteacher='" + cteacher + '\'' +
                ", score=" + score +
                '}';
    }
}
