package com.luneice;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

//����
public class Bird {

	BufferedImage birdImage;
	int width, height;// ͼƬ���
	int x, y;// �����λ��
	int radius;// �뾶

	public Bird() {
		// TODO Auto-generated constructor stub
		try {
			birdImage = ImageIO.read(getClass().getResource("./images/0.png"));
			width = birdImage.getWidth();
			height = birdImage.getHeight();
			radius = 40;
			x = 120;
			y = 250;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// �Զ�׹��
	public void birdFall() {
		if (y < 498 - radius / 2) {
			y++;
		}

	}
	//���ɷ���
	public void birdFly() {
		if (y > radius) {
			y -= 35;
		}
	}
}
