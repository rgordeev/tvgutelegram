package ru.tversu.telegram.services;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface MessagingService {
    SendMessage constantMessage(Update update);
}
