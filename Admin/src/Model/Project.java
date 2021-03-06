package Model;

import java.sql.Date;

public class Project {
	private int pid;
	private String pname;
	private String ptid;
	private Date pdatefrom;
	private Date pdateto;
	private int pnum;
	private String prequire;
	private String pintroduction;
	private String pelse;
	private String pcondition;
	
	public Project() {}

	public Project(int pid, String pname, String ptid, Date pdatefrom,
			Date pdateto, int pnum, String prequire, String pintroduction,
			String pelse, String pcondition) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.ptid = ptid;
		this.pdatefrom = pdatefrom;
		this.pdateto = pdateto;
		this.pnum = pnum;
		this.prequire = prequire;
		this.pintroduction = pintroduction;
		this.pelse = pelse;
		this.pcondition = pcondition;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPtid() {
		return ptid;
	}

	public void setPtid(String ptid) {
		this.ptid = ptid;
	}

	public Date getPdatefrom() {
		return pdatefrom;
	}

	public void setPdatefrom(Date pdatefrom) {
		this.pdatefrom = pdatefrom;
	}

	public Date getPdateto() {
		return pdateto;
	}

	public void setPdateto(Date pdateto) {
		this.pdateto = pdateto;
	}

	public int getPnum() {
		return pnum;
	}

	public void setPnum(int pnum) {
		this.pnum = pnum;
	}

	public String getPrequire() {
		return prequire;
	}

	public void setPrequire(String prequire) {
		this.prequire = prequire;
	}

	public String getPintroduction() {
		return pintroduction;
	}

	public void setPintroduction(String pintroduction) {
		this.pintroduction = pintroduction;
	}

	public String getPelse() {
		return pelse;
	}

	public void setPelse(String pelse) {
		this.pelse = pelse;
	}

	public String getPcondition() {
		return pcondition;
	}

	public void setPcondition(String pcondition) {
		this.pcondition = pcondition;
	}
	
	
}
