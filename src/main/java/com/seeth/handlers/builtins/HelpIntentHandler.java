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
public class HelpIntentHandler implements IntentHandler {

	@Override
	public SpeechletResponse handleIntent(Intent intent, IntentRequest request, Session session) {
		
		Card card = AlexaUtils.newCard("Alexa Demo Skill", "Ask from following questions \n 1. Region name of the countries \n 2. What is the region name \n 3. Region name");
		
		PlainTextOutputSpeech speech = AlexaUtils.newSpeech("Ask from following questions Region name of the countries or What is the region name or Region name", AlexaUtils.inConversationMode(session));
		
		AlexaUtils.setConversationMode(session, true);
		
		return AlexaUtils.newSpeechletResponse( card, speech, session, false);
	}

}
