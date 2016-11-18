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
		randomTopicGenerator();
	}
	public ChatFrame getBaseFrame()
	{
		return appFrame;
	}
	
	public Chatbot getChatbot()
	{
		return stupidBot;
	}
	
	public String useChatBotCheckers(String input)
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
		
		if(!stupidBot.lengthChecker(checkedInput))
		{
			checkedInput = "I have no idea what you mean about " + input;
		}
		
		if(stupidBot.quitChecker(input))
		{
			System.exit(0);
		}
		int canBeRandom = (int) (Math.random() * 2);
		if(canBeRandom % 7 == 0)
		{
			checkedInput += randomTopicGenerator();
		}
		return checkedInput;
	}
	
	private String randomTopicGenerator()
	{
		String randomTopic = "";
		int random = (int) (Math.random() * 7);
		
		switch(random)
		{
		case 0:
			randomTopic = "Ddid you hear about the daft punk beastie boys mix?";
			break;
		case 1:
			randomTopic = "Can you bring me some sriracha?";
			break;
		case 2: 
			randomTopic = "Something is here";
			break;
		case 3:
			randomTopic = "Reading noels is fantastic";
			break;
		case 4:
			randomTopic = "Computational and algorithmic thinking for the win";
			break;
		case 5:
			randomTopic = "I heart Java";
			break;
		case 6: 
			randomTopic = "This are words";
			break;
		default:
			randomTopic ="This can't be happening!";
			break;
		}
		return randomTopic;
	}
	
}
