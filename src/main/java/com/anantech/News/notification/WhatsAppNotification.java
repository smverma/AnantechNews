package com.anantech.News.notification;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class WhatsAppNotification {
    // Find your Account Sid and Token at twilio.com/console
    public static final String ACCOUNT_SID = "AC910b2424ef5717e075bb2499436368b5";
    public static final String AUTH_TOKEN = "18814730317d559ad18cd345d1e5ce68";


    public  void notify(List<String> newsItems) {
        String finalNews=" News Bytes from Anantech  \n ";
        finalNews=finalNews.concat(" \n ");
        for(String news:newsItems){
            finalNews=finalNews.concat(news);
            finalNews=finalNews.concat(" \n ");
            finalNews=finalNews.concat(" \n ");
        }
        notify(finalNews);
    }
    public  void notify(String news) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:+919867228892"),
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),

                        news)

                        .create();

        System.out.println(message.getSid());
    }
}
