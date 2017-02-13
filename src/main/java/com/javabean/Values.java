package com.javabean;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

@ManagedBean(name="values")
@ViewScoped
public class Values {
	private String firstValue;
	private String secondValue;
	private String thirdValue;
	private String fourthValue;
	private String fifthValue;
	private String sixthValue;
	private String seventhValue;
	private String eighthValue;
	
	private boolean pageLoad = true;
	
	@PostConstruct
	public void doInit() {
		String currentPage = FacesContext.getCurrentInstance().getViewRoot().getViewId();
		String page[] = currentPage.split("/");
		currentPage = page[page.length-1];
		currentPage = currentPage.substring(0,currentPage.indexOf('.'));
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		if(session== null)
			FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		else {
			Values values =(Values) session.getAttribute("valueBean");
			session.removeAttribute("valueBean");
			if("finalResult".equals(currentPage) && values==null) {
				try {
					FacesContext.getCurrentInstance().getExternalContext().redirect("/Topcoder/faces/home.xhtml");
				}
				catch (IOException e) {
				}
				return ;
			}
			else if(values!=null) {
				this.firstValue = values.getFifthValue();
				this.secondValue = values.getSecondValue();
				this.thirdValue = values.getThirdValue();
				this.fourthValue = values.getFourthValue();
				this.fifthValue = values.getFifthValue();
				this.sixthValue = values.getSixthValue();
				this.seventhValue = values.getSeventhValue();
				this.eighthValue = values.getEighthValue();
			}
		}
		pageLoad = true;
	}
	
	public String getFirstValue() {
		return firstValue;
	}
	public void setFirstValue(String firstValue) {
		this.firstValue = firstValue;
	}
	public String getSecondValue() {
		return secondValue;
	}
	public void setSecondValue(String secondValue) {
		this.secondValue = secondValue;
	}
	public String getThirdValue() {
		return thirdValue;
	}
	public void setThirdValue(String thirdValue) {
		this.thirdValue = thirdValue;
	}
	public String getFourthValue() {
		return fourthValue;
	}
	public void setFourthValue(String fourthValue) {
		this.fourthValue = fourthValue;
	}
	public String getFifthValue() {
		return fifthValue;
	}
	public void setFifthValue(String fifthValue) {
		this.fifthValue = fifthValue;
	}
	public String getSixthValue() {
		return sixthValue;
	}
	public void setSixthValue(String sixthValue) {
		this.sixthValue = sixthValue;
	}
	public String getSeventhValue() {
		return seventhValue;
	}
	public void setSeventhValue(String seventhValue) {
		this.seventhValue = seventhValue;
	}
	public String getEighthValue() {
		return eighthValue;
	}
	public void setEighthValue(String eighthValue) {
		this.eighthValue = eighthValue;
	}
	public boolean isPageLoad() {
		return pageLoad;
	}
	public void setPageLoad(boolean pageLoad) {
		this.pageLoad = pageLoad;
	}
	
	public boolean processValues(int id) {
		if(isPageLoad()) {
			if(id==80) {
				setPageLoad(false);
				id=8;
			}
			return false;
		}
		switch(id) {
		case 1 : return StringUtils.isEmpty(getFirstValue());
		case 2 : return StringUtils.isEmpty(getSecondValue());
		case 3 : return StringUtils.isEmpty(getThirdValue());
		case 4 : return StringUtils.isEmpty(getFourthValue());
		case 5 : return StringUtils.isEmpty(getFifthValue());
		case 6 : return StringUtils.isEmpty(getSixthValue()) || Integer.parseInt(getSixthValue())<=0;
		case 7 : return StringUtils.isEmpty(getSeventhValue());
		case 8 : return StringUtils.isEmpty(getEighthValue());
		default : return StringUtils.isEmpty(getEighthValue());
		}
	}
}
