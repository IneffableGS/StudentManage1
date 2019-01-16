package project.obj;

public class Course {
    private int cno;
    private String cname;
    private String cdate;
    private String cteacher;

    public Course() {

    }

    public Course(int cno, String cname, String cdate, String cteacher) {
        this.cno = cno;
        this.cname = cname;
        this.cdate = cdate;
        this.cteacher = cteacher;
    }

    public Course(String cname, String cdate, String cteacher) {
        this.cname = cname;
        this.cdate = cdate;
        this.cteacher = cteacher;
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

    @Override
    public String toString() {
        return "Course{" +
                "cno=" + cno +
                ", cname='" + cname + '\'' +
                ", cdate='" + cdate + '\'' +
                ", cteacher='" + cteacher + '\'' +
                '}';
    }
}
