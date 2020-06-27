package com.kh.project.movie.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class next extends JFrame{
	
	JPanel panel, seat;
	JLabel screan, seats[], peapleLabel,priceLabel;
	JButton next, cancle;
	boolean[] select;
	ArrayList<String> ticket;
	int member;
	
	public next(final String movieName,int people,final int price,final int ticketNum,final String time,final JFrame parent) {
		setSize(500, 400);
		setTitle("좌석 선택");
		member = people;
		panel = new JPanel(null);
		
		screan = new JLabel("화면");
		screan.setBackground(Color.white);
		screan.setOpaque(true);
		
		next = new JButton("완료");
		cancle = new JButton("취소하기");
		ticket = new ArrayList<String>();
		
		seat = new JPanel(new GridLayout(8, 8));
		seats = new JLabel[65];
		select = new boolean[65];
		
		seat.setBackground(Color.black);
		seat.setOpaque(true);
		
		for(int i = 0; i<8; i++)
			for(int j=0; j<8; j++) {
				final int k = i*7 +j;
				seats[k] = new JLabel(Integer.toString(k+1));
				seats[k].setHorizontalAlignment(JLabel.CENTER);
				seats[k].addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						if(seats[k].getBackground()==Color.MAGENTA) {
									seats[k].setBackground(Color.WHITE);
									select[k] = false;
									member++;
						} else if(member>0 && seats[k].getBackground()!= Color.GREEN) {
							seats[k].setBackground(Color.MAGENTA);
							select[k] = false;
							member--;
						}
						seats[k].setOpaque(true);
					}
				});
				seat.add(seats[k]);
			}
		try {
			FileReader fr = new FileReader("ticket.txt");
			BufferedReader br = new BufferedReader(fr);
			String str;
			while((str = br.readLine())!= null) {
				ticket.add(str); 														
				StringTokenizer st = new StringTokenizer(str);						
				String name = st.nextToken("\t ");										
				String str2 = st.nextToken("\t ");									
				str2 = st.nextToken("\t ");
				String seats = st.nextToken("\t ");
				String tim = st.nextToken("\t ");
				StringTokenizer st2 = new StringTokenizer(seats,",");				
				System.out.println(seats);
				if(movieName.equals(name) && time.equals(tim)) {						
					while(st2.hasMoreTokens()) {
						str2 = st2.nextToken();											
						int k = Integer.parseInt(str2);
						this.seats[k].setBackground(Color.GREEN);
						this.seats[k].setOpaque(true);
					}
				}
			}
			br.close();
			fr.close();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		cancle.addActionListener(new ActionListener() {									
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				parent.setVisible(true);												
				next.this.dispose();												
			}
		});
		next.addActionListener(new ActionListener() {									
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(member>0) 
					new MsgBox(new JFrame("") ,null,null,"좌석을 전부 선택해주세요",null, false,null); 		
				else {
					String msg = movieName+"\t"+ticketNum+"\t"+price;								
					String seats = "\t";
					String etc = "시    간 : "+time+"   가     격 : "+price;
					for(int i=0;i<49;i++) {															
						if(select[i])																
							seats+=(i+1)+",";
					}
					seats = seats.substring(0, seats.length()-1);									
					new MsgBox(new JFrame("") ,"영화 이름 : "+movieName,"예약 번호 : "+ticketNum, etc,"좌     석   : "+seats, false,next.this); 
					msg +=seats+"\t"+time;
					ticket.add(msg);																
					try {
						FileWriter fw = new FileWriter("ticket.txt"); 							
						BufferedWriter bw = new BufferedWriter(fw);															
						for(int i = 0 ; i<ticket.size();i++)																	
							bw.write(ticket.get(i)+"\n");
						bw.close();
						fw.close();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}

		});
		 
		peapleLabel = new JLabel("인원       :     "+people+"명");
		priceLabel = new JLabel("가격       :     " +price+"원");
		screan.setBounds(40,20,430,30);
		screan.setHorizontalAlignment(SwingConstants.CENTER);
		
//		cancle.setBounds();															// widget들 절대좌표지정
//		next.setBounds();
//		seat.setBounds();
//		peapleLabel.setBounds();
//		priceLabel.setBounds();                                         --> 연결 시킨후 정확한 위치 잡아야함.
		
		panel.add(seat);
		panel.add(screan);
		panel.add(cancle);
		panel.add(next);
		panel.add(peapleLabel);
		panel.add(priceLabel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);				 // 크기 조절 불가
		add(panel);		
	}

}
