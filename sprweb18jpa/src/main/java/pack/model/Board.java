package pack.model;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="springboard")
public class Board {
	@Id
	private int num;
	
	private int readcnt;
	private String author, title, content;
	private Timestamp bwrite;
}
