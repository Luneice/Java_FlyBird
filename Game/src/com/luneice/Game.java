package com.luneice;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

//继承JPanel
public class Game extends JPanel {
	private static final long serialVersionUID = 1L;
	BufferedImage bgImage;// 背景图片
	Bird bird;
	Ground ground;
	Column firstCol, secondCol;

	public Game() {
		// 加载图片和异常处理
		try {
			bgImage = ImageIO.read(getClass().getResource("./images/bg.png"));
			ground = new Ground();
			firstCol = new Column(1);
			secondCol = new Column(2);
			bird = new Bird();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 这个是主函数
	public static void main(String[] args) {
		JFrame window = new JFrame("早起的鸟儿要奋斗");
		Game game = new Game();// 实例化一个对象出来
		window.add(game);
		// 注意加的先后顺序
		window.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					game.bird.birdFly();
				}

			}
		});
		window.setSize(432, 644);
		window.setLocationRelativeTo(null);// 设置正中央显示窗口
		window.setAlwaysOnTop(true);// 覆盖其他窗口
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 退出时关闭
		window.setVisible(true);// 让它显示出来，它会调用paint方法
		game.move();// 调用

	}

	// 重写绘画方法
	public void paint(Graphics pen) {
		pen.drawImage(bgImage, 0, 0, null);
		pen.drawImage(firstCol.colImage, firstCol.x - firstCol.width / 2, firstCol.y - firstCol.height / 2, null);
		pen.drawImage(secondCol.colImage, secondCol.x - secondCol.width / 2, secondCol.y - secondCol.height / 2, null);
		pen.drawImage(bird.birdImage, bird.x - bird.width / 2, bird.y - bird.height / 2, null);
		pen.drawImage(ground.groundIamde, ground.x, ground.y, null);
	}

	// 运动起来吧
	public void move() {

		while (true) {
			ground.groundMove();
			bird.birdFall();
			firstCol.columnMove();
			secondCol.columnMove();
			repaint();
			try {
				Thread.sleep(1000 / 60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// 边缘处理
			boolean condition1_x = bird.x >0 ;
			if (condition1_x) {
				if (true) {
					System.out.println("游戏还可以继续");
				}
			}

			if (bird.y + bird.radius > 498 || bird.y - bird.radius < 0) {
				System.out.println("你死了");
			}
		}
	}

}
