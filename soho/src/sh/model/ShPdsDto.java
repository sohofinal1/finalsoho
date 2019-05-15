package sh.model;

import java.io.Serializable;

/*
DROP TABLE SH_PDS		      		--°¶·¯¸®(SH_PDS)
CASCADE CONSTRAINTS;

DROP SEQUENCE SH_PDS_SEQ;

CREATE TABLE SH_PDS(
	SEQ NUMBER(8) PRIMARY KEY,
	ID VARCHAR2(10) NOT NULL,

    TITLE VARCHAR2(100) NOT NULL,
	CONTENT VARCHAR2(400) NOT NULL,
	FILENAME VARCHAR2(50) NOT NULL,
    READCOUNT NUMBER(8) NOT NULL,
    DOWNCOUNT NUMBER(8) NOT NULL,
    REGDATE DATE NOT NULL
);

CREATE SEQUENCE SH_PDS_SEQ
START WITH 1
INCREMENT BY 1;

ALTER TABLE SH_PDS
ADD CONSTRAINT SH_PDS_FK FOREIGN KEY(ID)
REFERENCES SH_MEMBER(ID);
*/


public class ShPdsDto implements Serializable {
	
	private int seq;
	private String id;
	private String title;
	private String content;
	private String filename;
	private int readcount;
	private int downcount;
	private String regdate;

	
	public ShPdsDto() {}


	public ShPdsDto(int seq, String id, String title, String content, String filename, int readcount, int downcount,
			String regdate) {
		super();
		this.seq = seq;
		this.id = id;
		this.title = title;
		this.content = content;
		this.filename = filename;
		this.readcount = readcount;
		this.downcount = downcount;
		this.regdate = regdate;
	}


	public ShPdsDto(String id, String title, String content, String filename) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.filename = filename;
	}


	public int getSeq() {
		return seq;
	}


	public void setSeq(int seq) {
		this.seq = seq;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getFilename() {
		return filename;
	}


	public void setFilename(String filename) {
		this.filename = filename;
	}


	public int getReadcount() {
		return readcount;
	}


	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}


	public int getDowncount() {
		return downcount;
	}


	public void setDowncount(int downcount) {
		this.downcount = downcount;
	}


	public String getRegdate() {
		return regdate;
	}


	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
}
