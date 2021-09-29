package ru.tversu.telegram.services;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class MessagingServiceImpl implements MessagingService {

    @Override
    public SendMessage constantMessage(Update update) {
        final String groupId = update.getMessage().getChatId().toString();
        final String payload = "Hello!";
        return new SendMessage(groupId, payload);
    }

    @Override
    public SendPhoto constantPhoto(Update update) throws IOException {
        final String chatId = update.getMessage().getChatId().toString();
        final Resource resource = new ClassPathResource("media/photo.jpeg");
        final InputStream fileStream = new FileInputStream(resource.getFile());
        return new SendPhoto(chatId, new InputFile(fileStream, resource.getFilename()));
    }
}
