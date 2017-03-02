package chat.view;

import javax.swing.*;
import chat.controller.ChatController;
import java.awt.Color;
import java.awt.event.*;


public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private SpringLayout baseLayout;
	private JTextArea chatDisplay;
	private JTextField chatField;
	private JButton chatButton;
	private JRadioButton chatRadioButton;
	private JScrollPane chatScroll;
	
	private JButton saveChat;
	private JButton searchTwitter;
	private JButton loadChat;
	private JButton sendTweet;
	
	public ChatPanel(ChatController baseController)
	{
		super();
		this.baseController = baseController;
		
		baseLayout = new SpringLayout();
		chatDisplay = new JTextArea(5, 25);
		chatField = new JTextField(25);
		chatButton = new JButton("Chat with the bot");
		chatRadioButton = new JRadioButton();
		chatScroll = new JScrollPane();
		
		saveChat = new JButton("Save Chat");
		loadChat = new JButton("Load Chat");
		searchTwitter = new JButton("Search Twitter");
		sendTweet = new JButton("Send Tweet");
		
		setupChatDisplay();
		setupPanel();
		setupListeners();
		setupLayout();
	}
	private void setupChatDisplay()
	{
		chatDisplay.setEditable(false);
		chatDisplay.setEnabled(false);
		chatDisplay.setWrapStyleWord(true);
		chatDisplay.setLineWrap(true);
		
		chatScroll.setViewportView(chatDisplay);
		chatScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		chatScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.green);
		this.add(chatButton);
		this.add(chatField);
		this.add(chatRadioButton);
		this.add(chatScroll);
		this.setSize(900, 600);
		
		this.add(saveChat);
		this.add(loadChat);
		this.add(searchTwitter);
		this.add(sendTweet);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, chatDisplay, 300, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatDisplay, -52, SpringLayout.NORTH, chatField);
		baseLayout.putConstraint(SpringLayout.NORTH, sendTweet, 0, SpringLayout.NORTH, loadChat);
		baseLayout.putConstraint(SpringLayout.WEST, sendTweet, 0, SpringLayout.WEST, chatButton);
		baseLayout.putConstraint(SpringLayout.NORTH, searchTwitter, 6, SpringLayout.SOUTH, chatField);
		baseLayout.putConstraint(SpringLayout.WEST, searchTwitter, 0, SpringLayout.WEST, chatButton);
		baseLayout.putConstraint(SpringLayout.NORTH, loadChat, 6, SpringLayout.SOUTH, saveChat);
		baseLayout.putConstraint(SpringLayout.EAST, loadChat, 0, SpringLayout.EAST, chatField);
		baseLayout.putConstraint(SpringLayout.NORTH, saveChat, 5, SpringLayout.SOUTH, chatField);
		baseLayout.putConstraint(SpringLayout.EAST, saveChat, 0, SpringLayout.EAST, chatField);
		baseLayout.putConstraint(SpringLayout.NORTH, chatButton, 6, SpringLayout.SOUTH, chatScroll);
		baseLayout.putConstraint(SpringLayout.NORTH, chatField, 36, SpringLayout.SOUTH, chatScroll);
		baseLayout.putConstraint(SpringLayout.WEST, chatField, 0, SpringLayout.WEST, chatScroll);
		baseLayout.putConstraint(SpringLayout.EAST, chatField, 0, SpringLayout.EAST, chatScroll);
		baseLayout.putConstraint(SpringLayout.NORTH, chatScroll, 100, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatScroll, 250, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatScroll, -400, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatScroll, -250, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatRadioButton, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatRadioButton, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatButton, 0, SpringLayout.WEST, chatField);
		
	}
	
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent click)
					{
						String personWords = chatField.getText();
						String chatbotResponse = baseController.useChatBotCheckers(personWords);
						String currentText = chatDisplay.getText();
						
						chatDisplay.setText("\nYou said: " + personWords + "\nChatbot says: " + chatbotResponse + "\n" + currentText);
						chatDisplay.setCaretPosition(0);
						chatField.setText("");
					}
				});
	}
}
