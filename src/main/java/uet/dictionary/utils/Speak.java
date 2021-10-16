package uet.dictionary.utils;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class Speak {
    private static final String VOICENAME_kevin = "kevin16";

    public static void speakEnglish(String english) {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        Voice voice = VoiceManager.getInstance().getVoice(VOICENAME_kevin);
        if (voice != null) {
            voice.allocate();
            voice.setRate(135);//Setting the rate of the voice
            voice.setPitch(160);//Setting the Pitch of the voice
            boolean status = voice.speak(english);
            voice.deallocate();
        } else {
            System.out.println("Error");
        }

    }
}
