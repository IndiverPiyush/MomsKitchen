package test;
import java.io.*;
@SuppressWarnings("serial")
public class CRegBean implements Serializable{
	private String cuName,cpWord,cfName,clName,caddr,cmid,cloc,cmob;

	public String getCuName() {
		return cuName;
	}

	public void setCuName(String cuName) {
		this.cuName = cuName;
	}

	public String getCpWord() {
		return cpWord;
	}

	public void setCpWord(String cpWord) {
		this.cpWord = cpWord;
	}

	public String getCfName() {
		return cfName;
	}

	public void setCfName(String cfName) {
		this.cfName = cfName;
	}

	public String getClName() {
		return clName;
	}

	public void setClName(String clName) {
		this.clName = clName;
	}

	public String getCaddr() {
		return caddr;
	}

	public void setCaddr(String caddr) {
		this.caddr = caddr;
	}

	public String getCmid() {
		return cmid;
	}

	public void setCmid(String cmid) {
		this.cmid = cmid;
	}

	public String getCloc() {
		return cloc;
	}

	public void setCloc(String cloc) {
		this.cloc = cloc;
	}

	public String getCmob() {
		return cmob;
	}

	public void setCmob(String cmob) {
		this.cmob = cmob;
	}
}