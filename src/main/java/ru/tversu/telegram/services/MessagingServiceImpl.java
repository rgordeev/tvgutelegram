package ru.tversu.telegram.services;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class MessagingServiceImpl implements MessagingService {

    @Override
    public SendMessage constantMessage(Update update) {
        final String groupId = update.getMessage().getChatId().toString();
        final String payload = "Hello!";
        return new SendMessage(groupId, payload);
    }
}
