package com.seeth.handlers.custom;

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
public class RegionInfoHandler implements IntentHandler {

	@Override
	public SpeechletResponse handleIntent(Intent intent, IntentRequest request, Session session) {
		
		Card card = AlexaUtils.newCard("My Demo Skill", "This is Demo Skill using Spring Boot");
		
		PlainTextOutputSpeech speech = AlexaUtils.newSpeech("Hello, World.  I am a Spring Boot custom skill.", AlexaUtils.inConversationMode(session));
		
		AlexaUtils.setConversationMode(session, true);
		
		return AlexaUtils.newSpeechletResponse( card, speech, session, false);
	}

}
