package chat.controller;

import chat.model.Chatbot;
import chat.view.*;

public class ChatController
{
	private Chatbot stupidBot;
	private ChatViewer display;
	private ChatFrame appFrame;

	public ChatController()
	{
		stupidBot = new Chatbot("wall-e");
		display = new ChatViewer();
		appFrame = new ChatFrame(this);
	}
	
	public void start()
	{
		String response = display.collectResponse("What do you want to talk about?");
		
		while(stupidBot.lengthChecker(response))
		{
			display.displayMessage(useChatBotCheckers(response));
			response = display.collectResponse("Oh, you want to talk about " + response + " ? Tell me more.");
			
		}
		
		getBaseFrame();
		getChatbot();
	}
	public ChatFrame getBaseFrame()
	{
		return appFrame;
	}
	
	public Chatbot getChatbot()
	{
		return stupidBot;
	}
	
	private String useChatBotCheckers(String input)
	{
		String checkedInput = "";
		if(stupidBot.memeChecker(input))
		{
			checkedInput += "\nYou like memes!\n";
		}
		if(stupidBot.contentChecker(input))
		{
			checkedInput += "\nYou know my secret topic!\n";
		}
		if(stupidBot.politicalTopicChecker(input))
		{
			checkedInput += "\nPolitics\n";
		}
		
		if(checkedInput.length() == 0)
		{
			checkedInput = "I have no idea what you mean about " + input;
		}
		
		if(stupidBot.quitChecker(input))
		{
			System.exit(0);
		}
		return checkedInput;
	}
}
