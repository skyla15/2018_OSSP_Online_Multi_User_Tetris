package com.tetris.network;

import com.tetris.classes.*;
import java.io.*;
import java.util.ArrayList;

public class DataShip implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public static final int CLOSE_NETWORK = 0;	//서버와 연결을 끊음.
	public static final int EXIT = 1;			//프로그램종료
	public static final int SERVER_EXIT = 2;	//서버가 종료될 경우
	public static final int PRINT_SYSTEM_OPEN_MESSAGE = 3;	//리스트 이름 받아오기.
	public static final int PRINT_SYSTEM_ADDMEMBER_MESSAGE = 4;	//그 이후 들어오는 사람.
	public static final int GAME_START = 5;
	public static final int GAME_OVER = 6;
	public static final int ADD_BLOCK = 7;
	public static final int SET_INDEX = 8;
	public static final int PRINT_MESSAGE = 9;
	public static final int PRINT_SYSTEM_MESSAGE=10;
	public static final int GAME_WIN=11;
	public static final int GAME_MODE=12;
	public static final int ITEM_BLIND=13;
	public static final int ITEM_CLEAR=14;
	public static final int BOARD_INFO = 15; //server
	public static final int BOARD_INFO1 = 16; // cli1 
	public static final int BOARD_INFO2 = 17; // cli2  
	public static final int BOARD_INFO3 = 18; // cli3
	public static final int BOARD_INFO4 = 19; // cli4
	public static final int BOARD_INFO5 = 20; // cli4

	private int cmd = -1;
	private String name;
	private String ip;
	private String msg;
	private int numOfBlock;
	private int index;
	private int rank;
	private boolean isPlay;
	private int totalAdd;
	private int speed;
	private int game_mode;
	
	
	private  ArrayList<Block> block_info1;
	private  ArrayList<Block> block_info2;
	private  ArrayList<Block> block_info3;
	private  ArrayList<Block> block_info4;
	private  ArrayList<Block> block_info5;
	
	private Block[][] map_info1;
	private Block[][] map_info2;
	private Block[][] map_info3;
	private Block[][] map_info4;
	private Block[][] map_info5;
	//21 10
	public DataShip(){
		block_info1 = new ArrayList<Block>();
		block_info2 = new ArrayList<Block>();
		block_info3 = new ArrayList<Block>();
		block_info4 = new ArrayList<Block>();
		block_info5 = new ArrayList<Block>();
		map_info1 = new Block[21][10];
		map_info2 = new Block[21][10];
		map_info3 = new Block[21][10];
		map_info4 = new Block[21][10];
		map_info5 = new Block[21][10];
		
	}
	public DataShip(int cmd){this.cmd = cmd;
	block_info1 = new ArrayList<Block>();
	block_info2 = new ArrayList<Block>();
	block_info3 = new ArrayList<Block>();
	block_info4 = new ArrayList<Block>();
	block_info5 = new ArrayList<Block>();
	
	map_info1 = new Block[21][10];
	map_info2 = new Block[21][10];
	map_info3 = new Block[21][10];
	map_info4 = new Block[21][10];
	map_info5 = new Block[21][10];
	
	}


	public void setBlock1( ArrayList<Block> list) {
		this.block_info1.addAll(list);}
	public ArrayList<Block> getBlock1() {return block_info1;}
	public void setBlock2( ArrayList<Block> list) {this.block_info2.addAll(list);}
	public ArrayList<Block> getBlock2() {return block_info2;}
	public void setBlock3( ArrayList<Block> list) {this.block_info3.addAll(list);}
	public ArrayList<Block> getBlock3() {return block_info3;}
	public void setBlock4( ArrayList<Block> list) {this.block_info4.addAll(list);}
	public ArrayList<Block> getBlock4() {return block_info4;}
	public void setBlock5( ArrayList<Block> list) {this.block_info5.addAll(list);}
	public ArrayList<Block> getBlock5() {return block_info5;}

	public void set_map1_info(Block[][] m){ this.map_info1 =  m;}
	public void set_map2_info(Block[][] m){ this.map_info2 =  m;}
	public void set_map3_info(Block[][] m){ this.map_info3 =  m;}
	public void set_map4_info(Block[][] m){ this.map_info4 =  m;}
	public void set_map5_info(Block[][] m){ this.map_info5 =  m;}
	
	public Block[][] get_map1_info() {return map_info1; }
	public Block[][] get_map2_info() {return map_info2; }
	public Block[][] get_map3_info() {return map_info3; }
	public Block[][] get_map4_info() {return map_info4; }
	public Block[][] get_map5_info() {return map_info5; }
	
	public void setCommand(int type){this.cmd = type;};
	public int getCommand(){return cmd;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getIp() {return ip;}
	public void setIp(String ip) {this.ip = ip;}
	public String getMsg() {return msg;}
	public void setMsg(String msg) {this.msg = msg;}
	public int getNumOfBlock() {return numOfBlock;}
	public void setNumOfBlock(int numOfBlock) {this.numOfBlock = numOfBlock;}
	public int getIndex() {return index;}
	public void setIndex(int index) {this.index = index;}
	public int getRank() {return rank;}
	public void setRank(int rank) {this.rank = rank;}
	public boolean isPlay() {return isPlay;}
	public void setPlay(boolean isPlay) {this.isPlay = isPlay;}
	public int getTotalAdd() {return totalAdd;}
	public void setTotalAdd(int totalAdd) {this.totalAdd = totalAdd;}
	public int getSpeed() {return speed;}
	public void setSpeed(int speed) {this.speed = speed;}
	public int getgame_mode() {return game_mode;}
	public void setgame_mode(int mode) {this.game_mode = mode;}
	
}
