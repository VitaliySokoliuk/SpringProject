package ua.lviv.SpringUniversity.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSendingService {

    private static final Logger LOG = LoggerFactory.getLogger(EmailSendingService.class);
    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailSendingService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Value("${appBaseDomain}")
    private String appBaseDomain;
    @Value("${verifyLink}")
    private String verifyLink;

    public void sendEmail(String userEmail, String hash) {
        LOG.info("Email was send with hash " + hash);
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(userEmail);
        simpleMailMessage.setSubject("Підтвердження реєстрації");

        String text = "Доброго дня, закінчіть процес реєстрації за посиланням ";
        String link = appBaseDomain + verifyLink + hash;
        String text2 = "\nЯкщо ви не реєструвалися на сервіс MyUniversity то проігноруйте це повідомлення.";

        simpleMailMessage.setText(text + link + text2);

        try {
            javaMailSender.send(simpleMailMessage);
        } catch (MailException e) {
            LOG.error("Can`t send email to " + userEmail);
            e.printStackTrace();
        }

    }

}