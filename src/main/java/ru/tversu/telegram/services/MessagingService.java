package ru.tversu.telegram.services;

import java.io.IOException;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface MessagingService {
    SendMessage constantMessage(Update update);

    SendPhoto constantPhoto(Update update) throws IOException;
}
