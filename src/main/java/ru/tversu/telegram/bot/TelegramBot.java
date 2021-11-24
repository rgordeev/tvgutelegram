package ru.tversu.telegram.bot;

import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.tversu.telegram.services.MessagingService;

@Slf4j
@Component
public class TelegramBot extends TelegramLongPollingBot {

    private final MessagingService messagingService;

    @Autowired
    public TelegramBot(MessagingService messagingService) {
        this.messagingService = messagingService;
    }

    @Override
    public java.lang.String getBotUsername() {
        return "TVGU_bot";
    }

    @Override
    public java.lang.String getBotToken() {
        return "2036658509:AAH_Ly5P4qzlUURlk_faUtDqWOH20YvJNd8";
    }

    @Override
    public void onUpdateReceived(Update update) {
        log.info("Message: " + update);
        try {
            sendApiMethod(messagingService.constantMessage(update));
            execute(messagingService.constantPhoto(update));
        } catch (TelegramApiException | IOException e) {
            log.error("Error", e);
        }
    }
}
