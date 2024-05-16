package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static es.codegym.telegrambot.TelegramBotContent.*;


public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "yortzedBot";
    public static final String TOKEN = "7199677960:AAEp5e66-8oveJPMDzmh-LQ6sRIsul-Il98";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        // TODO: escribiremos la funcionalidad principal del bot aquí
        if(getMessageText().equals("/start")){
            setUserGlory(0);
            sendTextMessageAsync(STEP_1_TEXT,
                    Map.of("Hakear nevera", "step_1_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_1_btn")) {
            setUserGlory(20);
            sendTextMessageAsync(STEP_2_TEXT, Map.of(
                    "tomar slachicha + 20 de fama ", "step_2_btn",
                    "tomar pescado + 20 de fama", "step_2_btn",
                    "tomar lata + 20 de fama", "step_2_btn"
            ));
        }
        if (getCallbackQueryButtonKey().equals("step_2_btn")) {
            setUserGlory(20);
            sendTextMessageAsync(STEP_3_TEXT, Map.of(
                    "hackear robot aspiradora + 30 de fama", "step_3_btn"
            ));
        }
        if (getCallbackQueryButtonKey().equals("step_3_btn")) {
            setUserGlory(30);
            sendTextMessageAsync(STEP_4_TEXT, Map.of(
                    "Enviar al robot por algo de comer + 30 de fama ", "step_4_btn",
                    "Dar vueltas en el robot + 30 de fama", "step_4_btn",
                    "Huir de el + 30 de fama", "step_4_btn"
                    ));
        }
        if (getCallbackQueryButtonKey().equals("step_4_btn")) {
            setUserGlory(30);
            sendTextMessageAsync(STEP_5_TEXT, Map.of(
                    "Poner y encender GoPro + 40 de fama ", "step_5_btn"
            ));
        }
        if (getCallbackQueryButtonKey().equals("step_5_btn")) {
            setUserGlory(30);
            sendTextMessageAsync(STEP_6_TEXT, Map.of(
                    "Grabar un reto + 40 de fama ", "step_6_btn",
                    "Grabar un Tutorial + 40 de fama", "step_6_btn",
                    "Grabar un blog + 40 de fama", "step_6_btn"
            ));
        }
        if (getCallbackQueryButtonKey().equals("step_6_btn")) {
            setUserGlory(30);
            sendTextMessageAsync(STEP_7_TEXT, Map.of(
                    "Hackear computadora + 50 de fama ", "step_7_btn"
            ));
        }
        if (getCallbackQueryButtonKey().equals("step_7_btn")) {
            setUserGlory(30);
            sendTextMessageAsync(STEP_8_TEXT, Map.of(
                    "Publicar video + 40 de fama ", "step_8_btn"
            ));
        }
        if (getCallbackQueryButtonKey().equals("step_8_btn")) {
            setUserGlory(30);
            sendTextMessageAsync(FINAL_TEXT);
        }
    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}