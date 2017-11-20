package com.bjsxt.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RandomController implements BaseController
{
	private static final int WIDTH = 300;
	private static final int HEIGHT = 50;
	private static final int COUNT = 4;

	@RequestMapping({ "random" })
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D g = (Graphics2D) image.getGraphics();
		Random random = new Random(
				(System.currentTimeMillis() * 2 / 3 - 19) / 2);
		g.setColor(getRandColor(180, 255));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setFont(new Font("Times New Roman", Font.PLAIN, WIDTH / COUNT));
		g.setColor(getRandColor(160, 200));
		for (int i = 0; i < WIDTH * HEIGHT / 100; i++)
		{
			int x = random.nextInt(WIDTH);
			int y = random.nextInt(HEIGHT);
			int xl = random.nextInt(HEIGHT / 4);
			int yl = random.nextInt(HEIGHT / 4);
			g.setColor(getRandColor(0, 255));
			g.drawLine(x, y, x + xl, y + yl);
		}
		String sRand = "";
		for (int i = 0; i < COUNT; i++)
		{
			String rand = String.valueOf(random.nextInt(10));
			sRand += rand;
			g.setColor(new Color(20 + random.nextInt(110), 20 + random
					.nextInt(110), 20 + random.nextInt(110)));
			g.drawString(rand, WIDTH / COUNT * i + 6, HEIGHT / 2 + WIDTH / COUNT / 2 - WIDTH / COUNT / 6);
		}
		g.dispose();
		try
		{
			ImageIO.write(image, "JPEG", response.getOutputStream());
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		request.getSession().setAttribute("RandStr", sRand);
	}

	private Color getRandColor(int fc, int bc)
	{
		Random random = new Random();
		if (fc > 255)
		{
			fc = 255;
		}
		if (bc > 255)
		{
			bc = 255;
		}
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}
}