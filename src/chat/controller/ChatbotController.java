package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatViewer;

public class ChatbotController
{
	private Chatbot stupidBot;
	private ChatViewer display;

	public ChatbotController()
	{
		stupidBot = new Chatbot("wall-e");
		display = new ChatViewer();
	}
	
	public void start()
	{
		String response = display.collectResponse("What do you want to talk about?");
		
		while(stupidBot.lengthChecker(response))
		{
			display.displayMessage(useChatBotCheckers(response));
			response = display.collectResponse("Oh, you want to talk about " + response + " ? Tell me more.");
			
		}

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
		
		if(checkedInput.length() == 0)
		{
			checkedInput = "I have no idea what you mean about " + input;
		}
		return checkedInput;
	}
}
