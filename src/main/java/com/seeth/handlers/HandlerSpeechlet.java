package com.seeth.handlers;

import org.springframework.stereotype.Component;

import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.SessionEndedRequest;
import com.amazon.speech.speechlet.SessionStartedRequest;
import com.amazon.speech.speechlet.SpeechletException;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.speechlet.SpeechletV2;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SimpleCard;

@Component
public class HandlerSpeechlet implements SpeechletV2 {
	
	@Override
	public void onSessionStarted(
			SpeechletRequestEnvelope<SessionStartedRequest> requestEnvelope) {
		
	}
	
	@Override
	public SpeechletResponse onLaunch(
			SpeechletRequestEnvelope<LaunchRequest> requestEnvelope) {
		PlainTextOutputSpeech outputSpeech = new PlainTextOutputSpeech();
		outputSpeech.setText("Welcome to Seethend's Amazon Skill");
		
		PlainTextOutputSpeech repromtSpeech = new PlainTextOutputSpeech();
		repromtSpeech.setText("Now I'll ask a question");
		Reprompt reprompt = new Reprompt();
		reprompt.setOutputSpeech(repromtSpeech);
		return SpeechletResponse.newAskResponse(outputSpeech, reprompt);
	}

	@Override
	public SpeechletResponse onIntent(
			SpeechletRequestEnvelope<IntentRequest> requestEnvelope) {
		
		IntentRequest request = requestEnvelope.getRequest();
		
		Intent intent = request.getIntent();
		
		String intentName = intent.getName();
		
		SpeechletResponse response = null;
		
		if(intentName.equals("regioninfo")) {
			String speechText = "Hello, World.  I am a Spring Boot custom skill.";

            SimpleCard card = new SimpleCard();
            card.setTitle("Hello World");
            card.setContent(speechText);

            PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
            speech.setText(speechText);

            response = SpeechletResponse.newTellResponse(speech, card);
        }
        else {
            try {
				throw new SpeechletException("I don't understand that intent.");
			} catch (SpeechletException e) {
				e.printStackTrace();
			}
        }
		return response;
	}
	

	@Override
	public void onSessionEnded(
			SpeechletRequestEnvelope<SessionEndedRequest> requestEnvelope) {
		
	}



}
