package com.luneice;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

//�̳�JPanel
public class Game extends JPanel {
	private static final long serialVersionUID = 1L;
	BufferedImage bgImage;// ����ͼƬ
	Bird bird;
	Ground ground;
	Column firstCol, secondCol;

	public Game() {
		// ����ͼƬ���쳣����
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

	// �����������
	public static void main(String[] args) {
		JFrame window = new JFrame("��������Ҫ�ܶ�");
		Game game = new Game();// ʵ����һ���������
		window.add(game);
		// ע��ӵ��Ⱥ�˳��
		window.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					game.bird.birdFly();
				}

			}
		});
		window.setSize(432, 644);
		window.setLocationRelativeTo(null);// ������������ʾ����
		window.setAlwaysOnTop(true);// ������������
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// �˳�ʱ�ر�
		window.setVisible(true);// ������ʾ�������������paint����
		game.move();// ����

	}

	// ��д�滭����
	public void paint(Graphics pen) {
		pen.drawImage(bgImage, 0, 0, null);
		pen.drawImage(firstCol.colImage, firstCol.x - firstCol.width / 2, firstCol.y - firstCol.height / 2, null);
		pen.drawImage(secondCol.colImage, secondCol.x - secondCol.width / 2, secondCol.y - secondCol.height / 2, null);
		pen.drawImage(bird.birdImage, bird.x - bird.width / 2, bird.y - bird.height / 2, null);
		pen.drawImage(ground.groundIamde, ground.x, ground.y, null);
	}

	// �˶�������
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

			// ��Ե����
			boolean condition1_x = bird.x >0 ;
			if (condition1_x) {
				if (true) {
					System.out.println("��Ϸ�����Լ���");
				}
			}

			if (bird.y + bird.radius > 498 || bird.y - bird.radius < 0) {
				System.out.println("������");
			}
		}
	}

}
