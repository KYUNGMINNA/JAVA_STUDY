package stu.Spring0613_;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SearchVO extends PageVO{
	

	private String keyword;
	private String condition;
	
	

}
