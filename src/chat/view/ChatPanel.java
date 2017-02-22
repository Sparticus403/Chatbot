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
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.green);
		this.add(chatButton);
		this.add(chatDisplay);
		this.add(chatField);
		this.add(chatRadioButton);
		this.add(chatScroll);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, chatButton, 50, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatButton, -92, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatField, 7, SpringLayout.SOUTH, chatButton);
		baseLayout.putConstraint(SpringLayout.WEST, chatField, 0, SpringLayout.WEST, chatButton);
		baseLayout.putConstraint(SpringLayout.WEST, chatDisplay, 0, SpringLayout.WEST, chatButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatDisplay, -24, SpringLayout.NORTH, chatButton);
		baseLayout.putConstraint(SpringLayout.NORTH, chatRadioButton, 0, SpringLayout.NORTH, chatButton);
		baseLayout.putConstraint(SpringLayout.WEST, chatRadioButton, 8, SpringLayout.EAST, chatButton);
	}
	
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent click)
					{
						String personWords = chatField.getText();
						String chatbotResponse = baseController.useChatBotCheckers(personWords);
						
						chatDisplay.setText("You said: " + personWords + "\nChatbot says: " + chatbotResponse);
					}
				});
	}
}
