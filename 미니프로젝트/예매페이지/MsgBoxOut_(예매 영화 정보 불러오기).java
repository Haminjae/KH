package com.kh.project.movie.vo;

public class MsgBoxOut {
	private String moviename;
	private String movieday;
	private String movietime;
	private int price;
	private int ticketnum;
	
	public MsgBoxOut() {}
	public MsgBoxOut(String moviename, String movieday, String movietime, int price, int ticketnum) {
		this.movieday = movieday;
		this.moviename = moviename;
		this.movietime = movietime;
		this.price = price;
		this.ticketnum = ticketnum;
	}
	
	public String getmovieday() {
		return movieday;
	}
	public void setmovieday(String movieday) {
		this.movieday = movieday;
	}
	
	public String getmoviename() {
		return moviename;
	}
	public void setmoviename(String moviename) {
		this.moviename = moviename;
	}
	
	public String getmovietime() {
		return movietime;
	}
	public void setmovietime(String movietime) {
		this.movietime = movietime;
	}
	
	public int getprice() {
		return price;
	}
	public void setprice(int price) {
		this.price = price;
	}
	
	public int getticketnum() {
		return ticketnum;
	}
	public void setticketnum(int ticketnum) {
		this.ticketnum = ticketnum;
	}
	
	private String toStirng() {
			return "영화 제목 : " + moviename + "\n" + "상영 날짜 : " + movieday + "\n" + "상영 시간 : " + movietime + "\n" + "가격 : " + price + "\n" + "예약번호 : " + ticketnum + "\n";
	}
}
