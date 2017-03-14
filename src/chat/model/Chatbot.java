package chat.model;

import java.util.ArrayList;

/**
 * Base version of the 2015 Chatbot class. Only stub methods are provided.
 * Students will complete methods as part * of the project. * @author Cody
 * Henrichsen * @version 1.0 10/14/15
 */
public class Chatbot
{
	private ArrayList<String> memesList;
	private ArrayList<String> politicalTopicList;
	private String userName;
	private String content;
	private ArrayList<String> keyboardMashList;
//	private ArrayList<String> inputHTMLList;
//	private ArrayList<String> twitterList;
	private String quit;

	/**
	 * * Creates an instance of the Chatbot with the supplied username. * @param
	 * userName The username for the chatbot.
	 */
	public Chatbot(String userName)
	{
		memesList = new ArrayList<String>();
		politicalTopicList = new ArrayList<String>();
		content = new String("Anything");
		buildMemesList();
		buildPoliticalTopicsList();
		this.userName = userName;
		this.content = "Something nifty";
		keyboardMashList = new ArrayList<String>();
		buildKeyboardMashList();
//		inputHTMLList = new ArrayList<String>();
//		buildInputHTMLList();
//		buildTwitterList();
		this.quit = "quit";
	}

	private void buildMemesList()
	{		
		memesList.add("doge");
		memesList.add("cute animals");
		memesList.add("grumpy cat");
		memesList.add("dat boi");
		memesList.add("willy wonka");
		memesList.add("john cena");
		memesList.add("success kid");
		memesList.add("bad luck brian");
		memesList.add("harambe");
		memesList.add("true story");
		memesList.add("doge");
		memesList.add("cute animals");
		memesList.add("grumpy cat");
		memesList.add("yee");
		memesList.add("important videos");
		memesList.add("the bee movie");
		memesList.add("we are number one");
		memesList.add("the legend 27");
		memesList.add("one does not simply");
	}

	private void buildPoliticalTopicsList()
	{
		politicalTopicList.add("Democrat");
		politicalTopicList.add("Republican");
		politicalTopicList.add("11/8/16");
		politicalTopicList.add("conservative");
		politicalTopicList.add("Clinton");
		politicalTopicList.add("Trump");
		politicalTopicList.add("Kaine");
		politicalTopicList.add("Pence");
		politicalTopicList.add("Stein");
		politicalTopicList.add("Johnson");
		politicalTopicList.add("election");
		politicalTopicList.add("Trump's wall");
		politicalTopicList.add("American politics");
		politicalTopicList.add("liberal");
		politicalTopicList.add("Hillary");
		politicalTopicList.add("@realdonaldtrump");
		politicalTopicList.add("Something else political");
		politicalTopicList.add("Last political message");
	}
	
	private void buildKeyboardMashList()
	{
		keyboardMashList.add("sdf");
		keyboardMashList.add("dfg");
		keyboardMashList.add("cvb");
		keyboardMashList.add(",./");
	}
	
//	private void buildInputHTMLList()
//	{
//		inputHTMLList.add("<B> </B>");
//		inputHTMLList.add("<I> sdadas </i>");
//		inputHTMLList.add("<P>");
//		inputHTMLList.add("<A HREF=\"sdfs.html\"> </a>");
//	}
	
//	private void buildTwitterList()
//	{
//		twitterList.add("#dw35 f");
//		twitterList.add("@d4d sretsf");
//	}

	/**
	 * * Checks the length of the supplied string. Returns false if the supplied
	 * String is empty or null, otherwise returns true. 
	 * @param currentInput
	 * @return A true or false based on the length of the supplied String.
	 */
	public boolean lengthChecker(String currentInput)
	{
		boolean hasLength = false;
		if(currentInput != null && !currentInput.equals(""))
		{
			hasLength = true;
		}
		return hasLength;
	}

	/**
	 * Checks if the supplied String matches the content area for this Chatbot
	 * instance.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked. * @return Whether it
	 *            matches the content area.
	 */
	public boolean contentChecker(String currentInput)
	{
		boolean hasContent = false;
		
		if (currentInput.toLowerCase().contains(content.toLowerCase()))
		{
			hasContent = true;
		}
		return hasContent;
	}

	/**
	 * Checks if supplied String matches ANY of the topics in the
	 * politicalTopicsList. Returns true if it does find a match and false if it
	 * does not match.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked. * @return Whether the
	 *            String is contained in the ArrayList.
	 */
	public boolean politicalTopicChecker(String currentInput)
	{
		boolean hasPoliticalTopic = false;
		
		for(int index = 0; index < politicalTopicList.size(); index ++)
		{	
			if(currentInput.equals(politicalTopicList.get(index)))
			{
				hasPoliticalTopic = true;
			}
		}
		
		return hasPoliticalTopic;
	}

	/**
	 * Checks to see that the supplied String value is in the current
	 * memesList variable.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked. * @return Whether the
	 *            supplied String is a recognized meme.
	 */
	public boolean memeChecker(String currentInput)
	{
		boolean isMeme = false;
		
		for ( int index = 0; index < memesList.size(); index ++)
		{
			if(currentInput.equalsIgnoreCase(memesList.get(index)))
			{
				isMeme = true;
			}
		
		}
		return isMeme;
	}
	
	public boolean keyboardMashChecker(String currentInput)
	{
		boolean isKeyMash = false;
		
		for (int index = 0; index < keyboardMashList.size(); index ++)
		{
			if(currentInput.equalsIgnoreCase(keyboardMashList.get(index)))
			{
				isKeyMash = true;
			}
		}
		
		return isKeyMash;
	}
	
	public boolean twitterChecker(String currentInput)
	{
		boolean isTweet = false;
		if(currentInput.substring(0).equalsIgnoreCase("#dw35 f") || currentInput.substring(0).equalsIgnoreCase("@d4d sretsf "))
		{
			isTweet = true;
		}
		
		return isTweet;
	}
	
	public boolean inputHTMLChecker(String currentInput)
	{
		boolean isHTML = false;
		
		if(currentInput.indexOf("<") == 0 && currentInput.indexOf(">") >= 2)
		{
			if(currentInput.indexOf("B") == 1 && currentInput.indexOf("</B>") > 1)
			{
				isHTML = true;
			}
			if(currentInput.indexOf("I") == 1 && currentInput.indexOf("</i>") > 1)
			{
				isHTML = true;
			}
			if(currentInput.indexOf("P") == 1)
			{
				isHTML = true;
			}
			if(currentInput.indexOf("A") == 1 && currentInput.indexOf("</a>") > 1)
			{
				if(currentInput.indexOf("HREF") == 3)
				{
					isHTML = true;
				}
			}
			
		}
		return isHTML;
	}
		
	public boolean quitChecker(String currentInput)
	{
		boolean hasQuit = false;
		
		if(currentInput.equalsIgnoreCase(quit))
		{
			hasQuit = true;
		}
		
		return hasQuit;
	}

	/**
	 * Returns the username of this Chatbot instance. 
	 * @return The username of the Chatbot.
	 */
	public String getUserName()
	{
		return userName;
	}

	/**
	 * Returns the content area for this Chatbot instance. 
	 * @return The content area for this Chatbot instance.
	 */
	public String getContent()
	{
		return content;
	}

	/**
	 * Getter method for the memesList object. 
	 * @return The reference to the meme list.
	 */
	public ArrayList<String> getMemesList()
	{
		return memesList;
	}

	/**
	 * Getter method for the politicalTopicList object. 
	 * @return The reference to the political topic list.
	 */
	public ArrayList<String> getPoliticalTopicList()
	{
		return politicalTopicList;
	}
	
	public ArrayList<String> getKeyboardMashList()
	{
		return keyboardMashList;
	}

	/**
	 * * Updates the content area for this Chatbot instance. * @param content
	 * The updated value for the content area.
	 */
	public void setContent(String content)
	{
		this.content = content;
	}

}