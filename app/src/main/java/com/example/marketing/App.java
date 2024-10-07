package com.example.marketing;

import com.backstage.app.utils.SpringApplicationUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.example")
@SpringBootApplication
public class App
{
	public static void main(String[] args)
	{
		SpringApplicationUtils.runWithBufferingApplicationStartup(args, App.class);
	}
}
