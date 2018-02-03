package pampushko.telegram;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

/**
 *
 */
@Slf4j
@Component
class MyBot extends TelegramLongPollingBot
{
	@Override
	public void onUpdateReceived(Update update)
	{
		// We check if the update has a message and the message has text
		if (update.hasMessage() && update.getMessage().hasText())
		{
			try
			{
				String sourceText = update.getMessage().getText();
				//берем текст входящего сообщения - переворачиваем - и отправляем в ответ
				String newMessageText = StringUtils.reverse(sourceText);
				log.info("source : {}", sourceText);
				log.info("result : {}", newMessageText);
				
				//Create a SendMessage object with mandatory fields
				SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId()).setText(newMessageText);
				execute(message); //Call method to send the message
				sourceText = null;
				newMessageText = null;
				System.gc();
			}
			catch (TelegramApiException ex)
			{
				log.error(ex.getStackTrace().toString());
			}
		}
	}
	
	@Override
	public String getBotUsername()
	{
		//имя бота установленное при регистрации
		return "littlecat01bot";
	}
	
	@Override
	public String getBotToken()
	{
		//токен бота полученный при регистрации
		return "511238190:AAH6XAxgXPv8wFiI78BtNV8vMQJbFtu2-MQ";
	}
}
