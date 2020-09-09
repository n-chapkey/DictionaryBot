package dictionaryPackage;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.*;

public class Main {
	public static JDA jda;
	public static String prefix = "~";
	public static void main(String[] args) throws LoginException {
		JDA jda = JDABuilder.createDefault("NzUzMDQ3MTY5MjYyNDIwMDE4.X1gf1A.4pxKXllODLXdw089vY_z9-TWxOA").build();
		jda.getPresence().setStatus(OnlineStatus.DO_NOT_DISTURB);
		jda.getPresence().setActivity(Activity.watching("Tutorials on Youtube."));
		
		jda.addEventListener(new Commands());
	}
	
	

}
