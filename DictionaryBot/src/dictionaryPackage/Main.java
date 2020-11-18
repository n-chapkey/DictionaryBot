package dictionaryPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.*;

public class Main {
	public static JDA jda;
	public static String prefix = "~";
	
	public static void main(String[] args) throws LoginException, FileNotFoundException {
		
		File tokenObj = new File("token.txt");
		Scanner reader = new Scanner(tokenObj);
		String token = reader.nextLine();
		reader.close();
		
		JDA jda = JDABuilder.createDefault(token).build();
		jda.getPresence().setStatus(OnlineStatus.ONLINE);
		jda.getPresence().setActivity(Activity.watching("for ~commands to be written"));
		
		jda.addEventListener(new Commands());
	}
	
	

}
