package support.component;

import java.util.*;

import org.zkoss.bind.annotation.*;
import org.zkoss.zul.ListModelList;

public class BandboxVM {
	String[] lang = {"Ada","Basic","C","C++","CSS","Cobol","Forth","Fortran",
            "Go","Groovy","Haskell","HTML","Java","JavaScript","Lisp","Python","Ruby",
            "Scala","Scheme"};
	ListModelList languages = new ListModelList<String>(Arrays.asList(lang));
	String inputValue="";
	
	@Init
	public void init(){
	}

	public ListModelList getLanguages() {
		return languages;
	}

	public void setLanguages(ListModelList languages) {
		this.languages = languages;
	}

	public String getInputValue() {
		return inputValue;
	}

	public void setInputValue(String inputValue) {
		this.inputValue = inputValue;
	}
	
	@Command
	public void add(){
		languages.add(inputValue);
	}
}
