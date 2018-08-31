package com.seeth.handlers.builtins;

import org.springframework.stereotype.Component;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.Card;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.seeth.handlers.IntentHandler;
import com.seeth.utils.AlexaUtils;

@Component
public class FallbackIntentHandler implements IntentHandler {

	@Override
	public SpeechletResponse handleIntent(Intent intent, IntentRequest request, Session session) {
		Card card = AlexaUtils.newCard("Alexa Demo Skill", "Conversation Ended...Byee!!!");
		
		PlainTextOutputSpeech speech = AlexaUtils.newSpeech("Ok... Byee!!!", AlexaUtils.inConversationMode(session));
		
		AlexaUtils.setConversationMode(session, true);
		
		return AlexaUtils.newSpeechletResponse(card, speech, session, true);
	}

}
