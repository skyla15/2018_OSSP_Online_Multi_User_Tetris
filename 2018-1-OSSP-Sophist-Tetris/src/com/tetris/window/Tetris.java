package com.tetris.window;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.tetris.network.GameClient;
import com.tetris.network.GameServer;

public class Tetris extends JFrame implements ActionListener{
	public static final int PLAY_BGM = 4;

	private static final long serialVersionUID = 1L;
	private GameServer server;
	private GameClient client;
	private TetrisBoard board = new TetrisBoard(this,client);
	public JMenuItem itemServerStart = new JMenuItem("서버로 접속하기");
	public JMenuItem itemClientStart = new JMenuItem("클라이언트로 접속하기");
	
	private boolean isNetwork;
	private boolean isServer;
	
	public int check_sc = 0; //0 is unselect

	public Tetris() {
		
		JMenuBar mnBar = new JMenuBar();
		JMenu mnGame = new JMenu("게임하기");
		
		mnGame.add(itemServerStart);
		mnGame.add(itemClientStart);
		mnBar.add(mnGame);
		
		this.setJMenuBar(mnBar);
		
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.getContentPane().add(board);
		
		this.setResizable(false);
		this.pack();
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		//프로그램 생성위치
		this.setLocation((size.width-this.getWidth()),(size.height-this.getHeight()));
		this.setVisible(true);
		
		itemServerStart.addActionListener(this);
		itemClientStart.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				if(client!=null ){
					
					if(isNetwork){
						client.closeNetwork(isServer);
					}
				}else{
					System.exit(0);
				}
				
			}
			
		});
	

		board.playSound(PLAY_BGM);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String ip=null;
		int port=0;
		String nickName=null;
		if(e.getSource() == itemServerStart){ //is started as a server, START BUTTON ENABLE.
			
			String sp = JOptionPane.showInputDialog("port번호를 입력해주세요","9500");
			if(sp!=null && !sp.equals(""))port = Integer.parseInt(sp);
			nickName = JOptionPane.showInputDialog("닉네임을 입력해주세요","이름없음");
			
			if(port!=0){ 
				if(server == null) server = new GameServer(port);
				server.startServer();
				try {ip = InetAddress.getLocalHost().getHostAddress();
				} catch (UnknownHostException e1) {e1.printStackTrace();}
				if(ip!=null){
					client = new GameClient(this,ip,port,nickName);
					if(client.start()){
						itemServerStart.setEnabled(false);
						itemClientStart.setEnabled(false);
						board.setClient(client);
						board.getBtnStart().setEnabled(true);
						board.startNetworking(ip, port, nickName);
						isNetwork = true;
						isServer = true;
					}
				}
			}
		}else if(e.getSource() == itemClientStart){ //if started as a client, NO STARTBTN OPTION AVAILABLE
			try {
				ip = InetAddress.getLocalHost().getHostAddress();
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			}
			
			ip = JOptionPane.showInputDialog("IP를 입력해주세요.",ip);
			String sp = JOptionPane.showInputDialog("port번호를 입력해주세요","9500");
			if(sp!=null && !sp.equals(""))port = Integer.parseInt(sp);
			nickName = JOptionPane.showInputDialog("닉네임을 입력해주세요","이름없음");

		
			if(ip!=null){
				client = new GameClient(this,ip,port,nickName);
				if(client.start()){
					itemServerStart.setEnabled(false);
					itemClientStart.setEnabled(false);
					board.comboSpeed.setEnabled(false);
					board.checktimemod.setEnabled(false); //클라는 모드 선택 x
					board.setClient(client);
					board.startNetworking(ip, port, nickName);
					isNetwork = true;
				}
			}
		}
	}

	public void closeNetwork(){
		isNetwork = false;
		client = null;
		itemServerStart.setEnabled(true);
		itemClientStart.setEnabled(true);
		board.setPlay(false);
		board.setClient(null);
	}
	
	

	public JMenuItem getItemServerStart() {return itemServerStart;}
	public JMenuItem getItemClientStart() {return itemClientStart;}
	public TetrisBoard getBoard(){return board;}
	public void gameStart(int speed, int mode){board.gameStart(speed, mode);}
	public boolean isNetwork() {return isNetwork;}
	public void setNetwork(boolean isNetwork) {this.isNetwork = isNetwork;}
	public void printSystemMessage(String msg){board.printSystemMessage(msg);}
	public void printMessage(String msg){board.printMessage(msg);}
	public boolean isServer() {return isServer;}
	public void setServer(boolean isServer) {this.isServer = isServer;}
	public void changeSpeed(Integer speed) {board.changeSpeed(speed);}

}
