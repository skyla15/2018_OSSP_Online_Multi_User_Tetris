package com.tetris.classes;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

import com.tetris.window.TetrisBoard;

public class Block implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public int size = TetrisBoard.BLOCK_SIZE;
	public int width = size, height = size;
	public int gap = 3;
	public int fixGridX, fixGridY;
	public int posGridX, posGridY;
	public Color color;
	private Color ghostColor;	
	private boolean ghost;
	
	
	/**
	 * 
	 * @param fixGridX : 사각형 고정 X 그리드좌표
	 * @param fixGridY : 사각형 고정 Y 그리드좌표
	 * @param color : 사각형 색상
	 */
	public Block(int fixGridX, int fixGridY, Color color, Color ghostColor) {
		this.fixGridX = fixGridX;
		this.fixGridY = fixGridY;
		this.color=color;
		this.ghostColor = ghostColor;
	}
	

	/**
	 * 사각형을 그려준다.
	 * @param g
	 */
	public void drawColorBlock(Graphics g){
		if(ghost)g.setColor(ghostColor);
		else g.setColor(color);
		//칸 테투리그림
		g.fillRect((fixGridX+posGridX)*size + TetrisBoard.BOARD_X, (fixGridY+posGridY)*size + TetrisBoard.BOARD_Y, width, height);
		g.setColor(Color.BLACK);
		g.drawRect((fixGridX+posGridX)*size + TetrisBoard.BOARD_X, (fixGridY+posGridY)*size + TetrisBoard.BOARD_Y, width, height);
		g.drawLine((fixGridX+posGridX)*size + TetrisBoard.BOARD_X, (fixGridY+posGridY)*size + TetrisBoard.BOARD_Y, (fixGridX+posGridX)*size+width + TetrisBoard.BOARD_X, (fixGridY+posGridY)*size+height + TetrisBoard.BOARD_Y);
		g.drawLine((fixGridX+posGridX)*size + TetrisBoard.BOARD_X, (fixGridY+posGridY)*size+height + TetrisBoard.BOARD_Y, (fixGridX+posGridX)*size+width + TetrisBoard.BOARD_X, (fixGridY+posGridY)*size + TetrisBoard.BOARD_Y);
		if(ghost)g.setColor(ghostColor);
		else g.setColor(color);
		//네모칸으로 채우기 x대신
		g.fillRect((fixGridX+posGridX)*size+gap + TetrisBoard.BOARD_X, (fixGridY+posGridY)*size+gap + TetrisBoard.BOARD_Y, width-gap*2, height-gap*2);
		g.setColor(Color.BLACK);
		g.drawRect((fixGridX+posGridX)*size+gap + TetrisBoard.BOARD_X, (fixGridY+posGridY)*size+gap + TetrisBoard.BOARD_Y, width-gap*2, height-gap*2);
	}
	public void drawColorBlock2(Graphics g){
	      int size = TetrisBoard.BLOCK_SIZE/2;
	      int width = size;
	      int height = size;
	      if(ghost)g.setColor(ghostColor);
	      else g.setColor(color);
	      //칸 테투리그림
	      g.fillRect((fixGridX+posGridX)*size + TetrisBoard.BOARD_X*5 + 1, (fixGridY+posGridY)*size + TetrisBoard.BOARD_Y*2 + 10, width, height);
	      g.setColor(Color.BLACK);
	      g.drawRect((fixGridX+posGridX)*size + TetrisBoard.BOARD_X*5 + 1, (fixGridY+posGridY)*size + TetrisBoard.BOARD_Y*2 + 10, width, height);
	      if(ghost)g.setColor(ghostColor);
	      else g.setColor(color);
	      //네모칸으로 채우기 x대신
	      g.fillRect((fixGridX+posGridX)*size+gap + TetrisBoard.BOARD_X*5 + 1, (fixGridY+posGridY)*size+gap + TetrisBoard.BOARD_Y*2 + 10, width-gap*2, height-gap*2);
	      g.setColor(Color.BLACK);
	      g.drawRect((fixGridX+posGridX)*size+gap + TetrisBoard.BOARD_X*5 + 1, (fixGridY+posGridY)*size+gap + TetrisBoard.BOARD_Y*2 + 10, width-gap*2, height-gap*2);
	   }
	   public void drawColorBlock3(Graphics g){
	      int size = TetrisBoard.BLOCK_SIZE/2;
	      int width = size;
	      int height = size;
	      if(ghost)g.setColor(ghostColor);
	      else g.setColor(color);
	      //칸 테투리그림
	      g.fillRect((fixGridX+posGridX)*size + TetrisBoard.BOARD_X*7 + 1, (fixGridY+posGridY)*size + TetrisBoard.BOARD_Y*2 + 10, width, height);
	      g.setColor(Color.BLACK);
	      g.drawRect((fixGridX+posGridX)*size + TetrisBoard.BOARD_X*7 + 1, (fixGridY+posGridY)*size + TetrisBoard.BOARD_Y*2 + 10, width, height);
	      if(ghost)g.setColor(ghostColor);
	      else g.setColor(color);
	      //네모칸으로 채우기 x대신
	      g.fillRect((fixGridX+posGridX)*size+gap + TetrisBoard.BOARD_X*7 + 1, (fixGridY+posGridY)*size+gap + TetrisBoard.BOARD_Y*2 + 10, width-gap*2, height-gap*2);
	      g.setColor(Color.BLACK);
	      g.drawRect((fixGridX+posGridX)*size+gap + TetrisBoard.BOARD_X*7 + 1, (fixGridY+posGridY)*size+gap + TetrisBoard.BOARD_Y*2 + 10, width-gap*2, height-gap*2);
	   }
	   public void drawColorBlock4(Graphics g){
	      int size = TetrisBoard.BLOCK_SIZE/2;
	      int width = size;
	      int height = size;
	      if(ghost)g.setColor(ghostColor);
	      else g.setColor(color);
	      //칸 테투리그림
	      g.fillRect((fixGridX+posGridX)*size + TetrisBoard.BOARD_X*5 + 1, (fixGridY+posGridY)*size + TetrisBoard.BOARD_Y*9 + 30, width, height);
	      g.setColor(Color.BLACK);
	      g.drawRect((fixGridX+posGridX)*size + TetrisBoard.BOARD_X*5 + 1, (fixGridY+posGridY)*size + TetrisBoard.BOARD_Y*9 + 30, width, height);
	      if(ghost)g.setColor(ghostColor);
	      else g.setColor(color);
	      //네모칸으로 채우기 x대신
	      g.fillRect((fixGridX+posGridX)*size+gap + TetrisBoard.BOARD_X*5 + 1, (fixGridY+posGridY)*size+gap + TetrisBoard.BOARD_Y*9 + 30, width-gap*2, height-gap*2);
	      g.setColor(Color.BLACK);
	      g.drawRect((fixGridX+posGridX)*size+gap + TetrisBoard.BOARD_X*5 + 1, (fixGridY+posGridY)*size+gap + TetrisBoard.BOARD_Y*9 + 30, width-gap*2, height-gap*2);
	   }
	   public void drawColorBlock5(Graphics g){
	      int size = TetrisBoard.BLOCK_SIZE/2;
	      int width = size;
	      int height = size;
	      if(ghost)g.setColor(ghostColor);
	      else g.setColor(color);
	      //칸 테투리그림
	      g.fillRect((fixGridX+posGridX)*size + TetrisBoard.BOARD_X*7 + 1, (fixGridY+posGridY)*size + TetrisBoard.BOARD_Y*9 + 30, width, height);
	      g.setColor(Color.BLACK);
	      g.drawRect((fixGridX+posGridX)*size + TetrisBoard.BOARD_X*7 + 1, (fixGridY+posGridY)*size + TetrisBoard.BOARD_Y*9 + 30, width, height);
	      if(ghost)g.setColor(ghostColor);
	      else g.setColor(color);
	      //네모칸으로 채우기 x대신
	      g.fillRect((fixGridX+posGridX)*size+gap + TetrisBoard.BOARD_X*7 + 1, (fixGridY+posGridY)*size+gap + TetrisBoard.BOARD_Y*9 + 30, width-gap*2, height-gap*2);
	      g.setColor(Color.BLACK);
	      g.drawRect((fixGridX+posGridX)*size+gap + TetrisBoard.BOARD_X*7 + 1, (fixGridY+posGridY)*size+gap + TetrisBoard.BOARD_Y*9 + 30, width-gap*2, height-gap*2);
	   }
	/**
	 * 현재 블럭의 절대좌표를 보여준다.
	 * @return 현재블럭의 X절대좌표
	 */
	public int getX(){return posGridX + fixGridX;}	
	
	
	/**
	 * 현재 블럭의 절대좌표를 보여준다.
	 * @return 현재블럭의 Y절대좌표
	 */
	public int getY(){return posGridY + fixGridY;}

	
	/**
	 * Getter Setter
	 */
	public int getPosGridX(){return this.posGridX;}
	public int getPosGridY(){return this.posGridY;}
	public void setPosGridX(int posGridX) {this.posGridX = posGridX;}
	public void setPosGridY(int posGridY) {this.posGridY = posGridY;}
	public void setPosGridXY(int posGridX, int posGridY){this.posGridX = posGridX;this.posGridY = posGridY;}
	public void setFixGridX(int fixGridX) {this.fixGridX = fixGridX;}
	public void setFixGridY(int fixGridY) {this.fixGridY = fixGridY;}
	public void setFixGridXY(int fixGridX, int fixGridY){this.fixGridX = fixGridX;this.fixGridY = fixGridY;}
	public void setGhostView(boolean b){this.ghost = b;}
}
