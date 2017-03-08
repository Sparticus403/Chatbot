package chat.model;

import chat.controller.ChatController;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.Twitter;
import java.util.List;
import java.util.ArrayList;
import twitter4j.Status;

public class CTECTwitter 
{
	private ChatController baseController;
	private Twitter chatbotTwitter;
	private List<Status> searchedTweets;
	private List<String> ignoredWords;
	
	public CTECTwitter(ChatController baseController)
	{
		this.baseController = baseController;
		this.chatbotTwitter = TwitterFactory.getSingleton();
		searchedTweets = new ArrayList<Status>();
		ignoredWords = new ArrayList<String>();
	}
	
	public void sendTweet(String text)
	{
		try
		{
			chatbotTwitter.updateStatus(text);
		}
		catch(TwitterException tweetError)
		{
			baseController.handleErrors(tweetError);
		}
		catch(Exception otherError)
		{
			baseController.handleErrors(otherError);
		}
	}
	
	private String [] createIgnoredWordArray()
	{
		return null;
	}
	
	private void collectTweets(String username)
	{
		
	}
	
	public String getMostCommonWord(String user)
	{
		return null;
	}

}
